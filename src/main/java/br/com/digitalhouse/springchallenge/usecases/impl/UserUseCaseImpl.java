package br.com.digitalhouse.springchallenge.usecases.impl;

import br.com.digitalhouse.springchallenge.dataprovider.DTO.PostDTO;
import br.com.digitalhouse.springchallenge.dataprovider.DTO.ProductDTO;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Product;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;
import br.com.digitalhouse.springchallenge.dataprovider.repository.ProductRepository;
import br.com.digitalhouse.springchallenge.domain.UserGateway;
import br.com.digitalhouse.springchallenge.usecases.UserUseCase;
import br.com.digitalhouse.springchallenge.usecases.models.responses.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public UserFollowingListResponse getListFollowing(Long userId) {
        User user = this.userGateway.getById(userId);
        UserFollowingListResponse userFollowingListResponse = new UserFollowingListResponse();

        for (Seller seller : user.getFollowing()) {
//            User user = this.userGateway.getById(userId);
            SellerFollowedResponse sellerFollowedResponse = new SellerFollowedResponse(seller.getId(), seller.getName());
            userFollowingListResponse.getFollowing().add(sellerFollowedResponse);
        }

        userFollowingListResponse.setUserName(user.getName());
        userFollowingListResponse.setUserId(user.getId());

        return userFollowingListResponse;
    }

    @Override
    public UserFeedResponse getFeed(Long userId) {
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
        return new UserFeedResponse(userId,posts);
    }
}
