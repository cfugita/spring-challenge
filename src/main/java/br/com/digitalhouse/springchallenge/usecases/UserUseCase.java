package br.com.digitalhouse.springchallenge.usecases;

import br.com.digitalhouse.springchallenge.usecases.models.requests.PostPromoRequest;
import br.com.digitalhouse.springchallenge.usecases.models.responses.*;

public interface UserUseCase {
    void follow (Long userId, Long userToFollowId);
    void unfollow (Long userId, Long userToUnfollowId);
    UserFollowingListResponse getListFollowing (Long userId, String order);
    UserFollowerCountResponse countFollowers (Long userId);
    UserFollowerListResponse getListFollowers (Long userId, String order);
    void newPost (Long userId, Long productId);
    void newPromoPost (Long userId, Long productId, PostPromoRequest postPromoRequest);
    UserFeedResponse getFeed (Long userId, String order);
    PostCountResponse countPosts (Long userId, String type);
    UserFeedResponse getOwnPosts(Long userId, String type);
}
