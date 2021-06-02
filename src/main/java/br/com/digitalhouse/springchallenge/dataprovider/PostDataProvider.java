package br.com.digitalhouse.springchallenge.dataprovider;

import br.com.digitalhouse.springchallenge.dataprovider.entity.Post;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Product;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.dataprovider.repository.PostRepository;
import br.com.digitalhouse.springchallenge.dataprovider.repository.ProductRepository;
import br.com.digitalhouse.springchallenge.dataprovider.repository.SellerRepository;
import br.com.digitalhouse.springchallenge.domain.PostGateway;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostRequest;
import br.com.digitalhouse.springchallenge.usecases.models.requests.ProductRequest;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class PostDataProvider implements PostGateway {
    PostRepository postRepository;
    ProductRepository productRepository;
    SellerRepository sellerRepository;

    public PostDataProvider(PostRepository postRepository, ProductRepository productRepository, SellerRepository sellerRepository) {
        this.postRepository = postRepository;
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public void create(Long sellerId, PostRequest postRequest) {

        Seller seller = this.sellerRepository.getById(sellerId);

        ProductRequest productRequest = postRequest.getProductRequest();
        Product product = new Product(
                productRequest.getName(),
                productRequest.getType(),
                productRequest.getBrand(),
                productRequest.getColor(),
                productRequest.getNotes());

        Date date = Calendar.getInstance().getTime();
//        Post post = new Post(date,postRequest.getCategory(),postRequest.getPrice());

    }
}
