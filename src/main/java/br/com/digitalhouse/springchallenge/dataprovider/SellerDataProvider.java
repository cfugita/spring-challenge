package br.com.digitalhouse.springchallenge.dataprovider;

import br.com.digitalhouse.springchallenge.dataprovider.DTO.FeedDTO;
import br.com.digitalhouse.springchallenge.dataprovider.DTO.PostDTO;
import br.com.digitalhouse.springchallenge.dataprovider.DTO.ProductDTO;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Post;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Product;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.dataprovider.repository.ProductRepository;
import br.com.digitalhouse.springchallenge.dataprovider.repository.SellerRepository;
import br.com.digitalhouse.springchallenge.domain.SellerGateway;
import br.com.digitalhouse.springchallenge.usecases.exceptions.NotFoundException;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostPromoRequest;
import br.com.digitalhouse.springchallenge.usecases.models.responses.PostResponse;
import br.com.digitalhouse.springchallenge.usecases.models.responses.UserFeedResponse;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SellerDataProvider implements SellerGateway {

    SellerRepository sellerRepository;
    ProductRepository productRepository;

    public SellerDataProvider(SellerRepository sellerRepository, ProductRepository productRepository) {
        this.sellerRepository = sellerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Seller getSellerById(Long sellerId) {
        Optional<Seller> sellerOpt = this.sellerRepository.findAll().stream().filter(s -> s.getId().equals(sellerId)).findFirst();

        if(sellerOpt.isEmpty()) { throw new NotFoundException("Seller " + sellerId + " not found"); }

        return sellerOpt.get();
    }

    @Override
    public Product getProductById (Long sellerId, Long productId) {
        Seller seller = getSellerById(sellerId);

        Optional<Product> productOpt = seller.getProducts().stream().filter(p -> p.getId().equals(productId)).findFirst();

        if(productOpt.isEmpty()) { throw new NotFoundException("Product " + productId + " not found for seller " + sellerId); }

        return productOpt.get();
    }

    @Override
    public FeedDTO getPosts(Long sellerId) {
        Seller seller = getSellerById(sellerId);
        List<PostDTO> posts = new ArrayList<>();

        Date date = Calendar.getInstance().getTime();

        for(Product product : seller.getProducts()) {
            ProductDTO productDTO = new ProductDTO(
                    product.getId(),
                    product.getName(),
                    product.getType(),
                    product.getBrand(),
                    product.getColor(),
                    product.getNotes(),
                    product.getCategory(),
                    product.getPrice());

            List<Post> postsOfProduct = product.getPosts().stream().filter(p -> p.getDate().before(date)).collect(Collectors.toList());

            for (Post post : postsOfProduct) {
                PostDTO postDTO = new PostDTO(post.getId(),post.getDate(),productDTO, post.getHasPromo(),post.getDiscount());
                posts.add(postDTO);
            }
        }
        return new FeedDTO(seller.getId(), seller.getName(), posts);
    }

    @Override
    public void newPost(Long sellerId, Long productId) {
        Product product = getProductById(sellerId,productId);
        Post post = new Post();
        product.addPost(post);
        this.productRepository.save(product);
    }

    @Override
    public void newPromoPost(Long sellerId, Long productId, PostPromoRequest postPromoRequest) {
        Product product = getProductById(sellerId,productId);
        Post post = new Post(postPromoRequest.getDiscount());
        product.addPost(post);
        this.productRepository.save(product);
    }

}
