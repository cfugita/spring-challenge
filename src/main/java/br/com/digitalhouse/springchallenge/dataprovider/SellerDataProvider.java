package br.com.digitalhouse.springchallenge.dataprovider;

import br.com.digitalhouse.springchallenge.dataprovider.entity.Post;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Product;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;
import br.com.digitalhouse.springchallenge.dataprovider.repository.ProductRepository;
import br.com.digitalhouse.springchallenge.dataprovider.repository.SellerRepository;
import br.com.digitalhouse.springchallenge.domain.SellerGateway;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostRequest;
import br.com.digitalhouse.springchallenge.usecases.models.responses.SellerFollowerCountResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerDataProvider implements SellerGateway {

    SellerRepository sellerRepository;
    ProductRepository productRepository;

    public SellerDataProvider(SellerRepository sellerRepository, ProductRepository productRepository) {
        this.sellerRepository = sellerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Seller getById(Long sellerId) {
        Optional<Seller> seller = this.sellerRepository.findAll().stream().filter(s -> s.getId().equals(sellerId)).findFirst();
        return seller.orElse(null);
    }

    @Override
    public Product getProductById (Long sellerId, Long productId) {
        Seller seller = getById(sellerId);
        Optional<Product> product = seller.getProducts().stream().filter(p -> p.getId().equals(productId)).findFirst();
        return product.orElse(null);
    }

    @Override
    public void newPost(Long sellerId, Long productId, PostRequest postRequest) {
        Product product = getProductById(sellerId,productId);
        Post post = new Post(postRequest.getCategory(),postRequest.getPrice());
        product.addPost(post);
        this.productRepository.save(product);
    }

}
