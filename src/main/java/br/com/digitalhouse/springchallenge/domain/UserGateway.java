package br.com.digitalhouse.springchallenge.domain;


import br.com.digitalhouse.springchallenge.dataprovider.DTO.FeedDTO;
import br.com.digitalhouse.springchallenge.dataprovider.DTO.PostDTO;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Post;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Product;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostPromoRequest;

import java.util.List;

public interface UserGateway {
    void follow (Long userId, Long userToFollowId);
    void unfollow (Long userId, Long userToUnfollowId);
    User getUserById (Long userId);
    Product getProductById (Long userId, Long productId);
    void newPost (Long userId, Long productId);
    void newPromoPost(Long userId, Long productId, PostPromoRequest postPromoRequest);
    FeedDTO getFeed (Long userId);
    FeedDTO getOwnPosts (Long userId);
}
