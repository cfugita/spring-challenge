package br.com.digitalhouse.springchallenge.domain;


import br.com.digitalhouse.springchallenge.dataprovider.DTO.FeedDTO;
import br.com.digitalhouse.springchallenge.dataprovider.DTO.PostDTO;
import br.com.digitalhouse.springchallenge.dataprovider.DTO.ProductDTO;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Product;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostPromoRequest;
import br.com.digitalhouse.springchallenge.usecases.models.requests.ProductRequest;

import java.util.List;

public interface UserGateway {
    List<User> getAllUsers ();
    void follow (Long userId, Long userToFollowId);
    void unfollow (Long userId, Long userToUnfollowId);
    User getUserById (Long userId);
    Product getProductById (Long userId, Long productId);
    ProductDTO newProduct (Long userId, ProductRequest productRequest);
    List<ProductDTO> productsByUser (Long userId);
    PostDTO newPost (Long userId, Long productId);
    PostDTO newPromoPost(Long userId, Long productId, PostPromoRequest postPromoRequest);
    FeedDTO getFeed (Long userId);
    FeedDTO getOwnPosts (Long userId);
}
