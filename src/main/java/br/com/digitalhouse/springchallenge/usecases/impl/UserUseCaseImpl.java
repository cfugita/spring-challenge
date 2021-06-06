package br.com.digitalhouse.springchallenge.usecases.impl;

import br.com.digitalhouse.springchallenge.dataprovider.DTO.FeedDTO;
import br.com.digitalhouse.springchallenge.dataprovider.DTO.PostDTO;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;
import br.com.digitalhouse.springchallenge.domain.UserGateway;
import br.com.digitalhouse.springchallenge.usecases.UserUseCase;
import br.com.digitalhouse.springchallenge.usecases.exceptions.AlreadyDoneException;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostPromoRequest;
import br.com.digitalhouse.springchallenge.usecases.models.responses.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserUseCaseImpl implements UserUseCase {
    private UserGateway userGateway;

    public UserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void follow (Long userId, Long userToFollowId) {
        this.userGateway.follow(userId,userToFollowId);
    }
    @Override
    public void unfollow (Long userId, Long userToUnfollowId) {
        this.userGateway.unfollow(userId,userToUnfollowId);
    }

    @Override
    public UserFollowingListResponse getListFollowing (Long userId, String order) {
        User user = this.userGateway.getUserById(userId);
        UserFollowingListResponse userFollowingListResponse = new UserFollowingListResponse();

        for (User userFollowed : user.getFollowing()) {
            UserResponse userResponse = new UserResponse(userFollowed.getId(), userFollowed.getName());
            userFollowingListResponse.getFollowing().add(userResponse);
        }

        if(order != null) { this.orderListByName(userFollowingListResponse.getFollowing(), order); }

        userFollowingListResponse.setUserName(user.getName());
        userFollowingListResponse.setUserId(user.getId());

        return userFollowingListResponse;
    }

    @Override
    public UserFollowerCountResponse countFollowers(Long userId) {
        User user = this.userGateway.getUserById(userId);
        if(!user.getIsSeller()) { throw new IllegalArgumentException("User " + userId + " can't be followed"); }

        Integer countFollowers = user.getFollowers().size();

        return new UserFollowerCountResponse(user.getId(),user.getName(),countFollowers);
    }

    @Override
    public UserFollowerListResponse getListFollowers(Long userId, String order) {
        User user = this.userGateway.getUserById(userId);
        if(!user.getIsSeller()) { throw new IllegalArgumentException("User " + userId + " can't be followed"); }
        UserFollowerListResponse userFollowerListResponse = new UserFollowerListResponse();

        for (User userFollowed : user.getFollowers()) {
            UserResponse userResponse = new UserResponse(userFollowed.getId(), userFollowed.getName());
            userFollowerListResponse.getFollowers().add(userResponse);
        }

        if(order != null) { this.orderListByName(userFollowerListResponse.getFollowers(), order); }

        userFollowerListResponse.setUserName(user.getName());
        userFollowerListResponse.setUserId(user.getId());

        return userFollowerListResponse;
    }

    @Override
    public void newPost(Long userId, Long productId) {
        this.userGateway.newPost(userId,productId);
    }

    @Override
    public void newPromoPost(Long userId, Long productId, PostPromoRequest postPromoRequest) {
        this.userGateway.newPromoPost(userId, productId, postPromoRequest);
    }

    @Override
    public UserFeedResponse getFeed (Long userId, String order) {
        FeedDTO feedDTO = this.userGateway.getFeed(userId);
        List<PostResponse> posts = getPostResponse(feedDTO.getPosts());

        if(order != null) { this.orderPostsByDate(posts, order); }

        return new UserFeedResponse(feedDTO.getUserId(), feedDTO.getUserName(), posts);
    }

    @Override
    public PostCountResponse countPosts (Long userId, String type) {
        FeedDTO feedDTO = this.userGateway.getOwnPosts(userId);
        List<PostDTO> postDTOS = feedDTO.getPosts();

        if(type != null) { postDTOS = this.filterPromoPosts(feedDTO.getPosts(), type); }

        return new PostCountResponse(feedDTO.getUserId(), feedDTO.getUserName(), postDTOS.size());
    }

    @Override
    public UserFeedResponse getOwnPosts (Long userId, String type) {
        FeedDTO feedDTO = this.userGateway.getOwnPosts(userId);
        List<PostDTO> postDTOS = feedDTO.getPosts();

        if(type != null) { postDTOS = this.filterPromoPosts(feedDTO.getPosts(), type); }

        List<PostResponse> posts = getPostResponse(postDTOS);

//        if(order != null) { this.orderPostsByDate(posts, order); }

        return new UserFeedResponse(feedDTO.getUserId(), feedDTO.getUserName(), posts);
    }

    public List<PostResponse> getPostResponse (List<PostDTO> postsDTO) {
        List<PostResponse> posts = new ArrayList<>();

        for(PostDTO postDTO : postsDTO) {
            ProductResponse productResponse = new ProductResponse(postDTO.getDetails());

            if(postDTO.getHasPromo()) {
                PostPromoResponse postResponse = new PostPromoResponse(postDTO,productResponse);
                posts.add(postResponse);
            }
            else {
                PostResponse postResponse = new PostResponse(postDTO, productResponse);
                posts.add(postResponse);
            }
        }
        return posts;
    }

    public void orderPostsByDate (List<PostResponse> posts, String order) {

        if(order.equals("date_asc")){
            posts.sort(PostResponse::compareTo);
            return;
        }
        else if (order.equals("date_desc")) {
            posts.sort(PostResponse::compareTo);
            Collections.reverse(posts);
            return;
        }

        throw new IllegalArgumentException("Parameter 'order' not accepted");
    }

    public void orderListByName (List<UserResponse> following, String order) {

        if(order.equals("name_asc")){
            following.sort(UserResponse::compareTo);
            return;
        }
        else if(order.equals("name_desc")) {
            following.sort(UserResponse::compareTo);
            Collections.reverse(following);
            return;
        }

        throw new IllegalArgumentException("Parameter 'order' not accepted");
    }

    public List<PostDTO> filterPromoPosts (List<PostDTO> posts, String type) {
        if(type.equals("promo")) {
            return posts.stream().filter(PostDTO::getHasPromo).toList();
        }

        throw new IllegalArgumentException("Parameter 'type' not accepted");
     }
}
