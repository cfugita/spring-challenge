package br.com.digitalhouse.springchallenge.usecases.impl;

import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;
import br.com.digitalhouse.springchallenge.domain.SellerGateway;
import br.com.digitalhouse.springchallenge.domain.UserGateway;
import br.com.digitalhouse.springchallenge.usecases.SellerUseCase;
import br.com.digitalhouse.springchallenge.usecases.models.responses.SellerFollowerCountResponse;
import br.com.digitalhouse.springchallenge.usecases.models.responses.SellerFollowerListResponse;
import br.com.digitalhouse.springchallenge.usecases.models.responses.UserFollowerResponse;
import org.springframework.stereotype.Service;

@Service
public class SellerUseCaseImpl implements SellerUseCase {
    private SellerGateway sellerGateway;
    private UserGateway userGateway;

    public SellerUseCaseImpl(SellerGateway sellerGateway, UserGateway userGateway) {
        this.sellerGateway = sellerGateway;
        this.userGateway = userGateway;
    }

    @Override
    public void create(String name) {
        this.sellerGateway.create(name);
    }

    @Override
    public SellerFollowerCountResponse countFollowers(Long sellerId) {

        Seller seller = this.sellerGateway.getById(sellerId);

        Integer countFollowers = seller.getFollowers().size();

        return new SellerFollowerCountResponse(seller.getId(),seller.getName(),countFollowers);
    }

    @Override
    public SellerFollowerListResponse getListFollowers (Long sellerId) {

        Seller seller = this.sellerGateway.getById(sellerId);
        SellerFollowerListResponse sellerFollowerListResponse = new SellerFollowerListResponse();

        for (User user : seller.getFollowers()) {
//            User user = this.userGateway.getById(userId);
            UserFollowerResponse userFollowerResponse = new UserFollowerResponse(user.getId(), user.getName());
            sellerFollowerListResponse.getFollowers().add(userFollowerResponse);
        }

        sellerFollowerListResponse.setSellerName(seller.getName());
        sellerFollowerListResponse.setSellerId(seller.getId());

        return sellerFollowerListResponse;
    }
}
