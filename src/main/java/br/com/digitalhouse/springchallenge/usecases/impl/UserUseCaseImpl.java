package br.com.digitalhouse.springchallenge.usecases.impl;

import br.com.digitalhouse.springchallenge.dataprovider.DTO.PostDTO;
import br.com.digitalhouse.springchallenge.dataprovider.DTO.ProductDTO;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;
import br.com.digitalhouse.springchallenge.domain.UserGateway;
import br.com.digitalhouse.springchallenge.usecases.UserUseCase;
import br.com.digitalhouse.springchallenge.usecases.models.responses.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserUseCaseImpl implements UserUseCase {
    private UserGateway userGateway;

    public UserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void followSeller(Long userId, Long sellerId) {
        this.userGateway.followSeller(userId,sellerId);
    }
    @Override
    public void unfollowSeller(Long userId, Long sellerId) {
        this.userGateway.unfollowSeller(userId,sellerId);
    }

    @Override
    public UserFollowingListResponse getListFollowing(Long userId, String order) {
        User user = this.userGateway.getUserById(userId);
        UserFollowingListResponse userFollowingListResponse = new UserFollowingListResponse();

        for (Seller seller : user.getFollowing()) {
            SellerFollowedResponse sellerFollowedResponse = new SellerFollowedResponse(seller.getId(), seller.getName());
            userFollowingListResponse.getFollowing().add(sellerFollowedResponse);
        }

        if(order != null) { this.orderListByName(userFollowingListResponse.getFollowing(), order); }

        userFollowingListResponse.setUserName(user.getName());
        userFollowingListResponse.setUserId(user.getId());

        return userFollowingListResponse;
    }

    @Override
    public UserFeedResponse getFeed(Long userId, String order) {
        List<PostDTO> postsDTO = this.userGateway.getFeed(userId);
        List<PostResponse> posts = new ArrayList<>();

        for(PostDTO postDTO : postsDTO) {
            ProductDTO productDTO = postDTO.getDetails();
            ProductResponse productResponse = new ProductResponse(
                    productDTO.getProductId(),
                    productDTO.getProductName(),
                    productDTO.getType(),
                    productDTO.getBrand(),
                    productDTO.getColor(),
                    productDTO.getNotes());

            PostResponse postResponse = new PostResponse(postDTO.getPostId(),postDTO.getDate(),productResponse,postDTO.getCategory(),postDTO.getPrice());
            posts.add(postResponse);
        }
        if(order != null) { this.orderPostsByDate(posts,order); }

        return new UserFeedResponse(userId,posts);
    }

    public void orderPostsByDate (List<PostResponse> posts, String order) {
        posts.sort(PostResponse::compareTo);

        if(order.equals("date_desc")){
            Collections.reverse(posts);
        }
    }

    public void orderListByName (List<SellerFollowedResponse> following, String order) {
        following.sort(SellerFollowedResponse::compareTo);

        if(order.equals("name_desc")){
            Collections.reverse(following);
        }
    }
}
