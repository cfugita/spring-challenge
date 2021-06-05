package br.com.digitalhouse.springchallenge.usecases.impl;

import br.com.digitalhouse.springchallenge.dataprovider.DTO.FeedDTO;
import br.com.digitalhouse.springchallenge.dataprovider.DTO.PostDTO;
import br.com.digitalhouse.springchallenge.dataprovider.DTO.ProductDTO;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;
import br.com.digitalhouse.springchallenge.domain.SellerGateway;
import br.com.digitalhouse.springchallenge.domain.UserGateway;
import br.com.digitalhouse.springchallenge.usecases.SellerUseCase;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostPromoRequest;
import br.com.digitalhouse.springchallenge.usecases.models.responses.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SellerUseCaseImpl implements SellerUseCase {
    private SellerGateway sellerGateway;
    private UserGateway userGateway;

    public SellerUseCaseImpl(SellerGateway sellerGateway, UserGateway userGateway) {
        this.sellerGateway = sellerGateway;
        this.userGateway = userGateway;
    }

    @Override
    public SellerFollowerCountResponse countFollowers(Long sellerId) {

        Seller seller = this.sellerGateway.getSellerById(sellerId);

        Integer countFollowers = seller.getFollowers().size();

        return new SellerFollowerCountResponse(seller.getId(),seller.getName(),countFollowers);
    }

    @Override
    public SellerFollowerListResponse getListFollowers (Long sellerId, String order) {

        Seller seller = this.sellerGateway.getSellerById(sellerId);
        SellerFollowerListResponse sellerFollowerListResponse = new SellerFollowerListResponse();

        for (User user : seller.getFollowers()) {
//            User user = this.userGateway.getById(userId);
            UserFollowerResponse userFollowerResponse = new UserFollowerResponse(user.getId(), user.getName());
            sellerFollowerListResponse.getFollowers().add(userFollowerResponse);
        }

        if(order != null) { this.orderListByName(sellerFollowerListResponse.getFollowers(), order); }

        sellerFollowerListResponse.setSellerName(seller.getName());
        sellerFollowerListResponse.setSellerId(seller.getId());

        return sellerFollowerListResponse;
    }

    @Override
    public void newPost(Long sellerId, Long productId) {
        this.sellerGateway.newPost(sellerId,productId);
    }

    @Override
    public void newPromoPost(Long sellerId, Long productId, PostPromoRequest postPromoRequest) {
        this.sellerGateway.newPromoPost(sellerId,productId,postPromoRequest);
    }

    @Override
    public SellerPromoPostCountResponse countPromoPosts(Long sellerId) {
        FeedDTO feedDTO = this.sellerGateway.getPosts(sellerId);
        return new SellerPromoPostCountResponse(feedDTO.getUserId(), feedDTO.getUserName(), feedDTO.getPosts().size());
    }

    @Override
    public UserFeedResponse getPromoPosts(Long sellerId) {
        FeedDTO feedDTO = this.sellerGateway.getPosts(sellerId);
        List<PostResponse> posts = new ArrayList<>();

        for(PostDTO postDTO : feedDTO.getPosts()) {
            ProductDTO productDTO = postDTO.getDetails();
            ProductResponse productResponse = new ProductResponse(
                    productDTO.getProductId(),
                    productDTO.getProductName(),
                    productDTO.getType(),
                    productDTO.getBrand(),
                    productDTO.getColor(),
                    productDTO.getNotes(),
                    productDTO.getCategory(),
                    productDTO.getPrice());

            if(postDTO.getHasPromo()) {
                PostPromoResponse postResponse = new PostPromoResponse(postDTO.getPostId(),postDTO.getDate(),productResponse,postDTO.getHasPromo(),postDTO.getDiscount());
                posts.add(postResponse);
            }
            else {
                PostResponse postResponse = new PostResponse(postDTO.getPostId(), postDTO.getDate(), productResponse);
                posts.add(postResponse);
            }
        }
//        if(order != null) { this.orderPostsByDate(posts,order); }

        return new UserFeedResponse(feedDTO.getUserId(),posts);
    }

    public void orderListByName (List<UserFollowerResponse> followers, String order) {
        followers.sort(UserFollowerResponse::compareTo);

        if(order.equals("name_desc")){
            Collections.reverse(followers);
        }
    }


}
