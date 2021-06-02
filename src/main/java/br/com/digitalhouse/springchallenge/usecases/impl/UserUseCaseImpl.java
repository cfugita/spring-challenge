package br.com.digitalhouse.springchallenge.usecases.impl;

import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;
import br.com.digitalhouse.springchallenge.domain.UserGateway;
import br.com.digitalhouse.springchallenge.usecases.UserUseCase;
import br.com.digitalhouse.springchallenge.usecases.models.responses.SellerFollowedResponse;
import br.com.digitalhouse.springchallenge.usecases.models.responses.SellerFollowerListResponse;
import br.com.digitalhouse.springchallenge.usecases.models.responses.UserFollowerResponse;
import br.com.digitalhouse.springchallenge.usecases.models.responses.UserFollowingListResponse;
import org.springframework.stereotype.Service;

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
}
