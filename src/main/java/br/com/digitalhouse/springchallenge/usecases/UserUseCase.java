package br.com.digitalhouse.springchallenge.usecases;

import br.com.digitalhouse.springchallenge.usecases.models.requests.PostPromoRequest;
import br.com.digitalhouse.springchallenge.usecases.models.requests.ProductRequest;
import br.com.digitalhouse.springchallenge.usecases.models.responses.*;

import java.util.List;

public interface UserUseCase {
    List<UserInfoResponse> getAllUsers ();
    void follow (Long userId, Long userToFollowId);
    void unfollow (Long userId, Long userToUnfollowId);
    UserFollowingListResponse getListFollowing (Long userId, String order);
    UserFollowerCountResponse countFollowers (Long userId);
    UserFollowerListResponse getListFollowers (Long userId, String order);
    ProductResponse newProduct (Long userId, ProductRequest productRequest);
    UserProductsResponse productsByUser (Long userId);
    PostResponse newPost (Long userId, Long productId);
    PostPromoResponse newPromoPost (Long userId, Long productId, PostPromoRequest postPromoRequest);
    UserFeedResponse getFeed (Long userId, String order);
    PostCountResponse countPosts (Long userId, String type);
    UserFeedResponse getOwnPosts(Long userId, String type);
}
