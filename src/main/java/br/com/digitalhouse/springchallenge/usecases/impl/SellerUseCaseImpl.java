package br.com.digitalhouse.springchallenge.usecases.impl;

import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.domain.SellerGateway;
import br.com.digitalhouse.springchallenge.usecases.SellerUseCase;
import br.com.digitalhouse.springchallenge.usecases.models.responses.SellerFollowerCountResponse;
import org.springframework.stereotype.Service;

@Service
public class SellerUseCaseImpl implements SellerUseCase {
    private SellerGateway sellerGateway;

    public SellerUseCaseImpl(SellerGateway sellerGateway) {
        this.sellerGateway = sellerGateway;
    }

    @Override
    public void create(String name) {
        this.sellerGateway.create(name);
    }

    @Override
    public SellerFollowerCountResponse countFollowers(Long sellerId) {
        Seller seller = this.sellerGateway.getById(sellerId);
        Integer countFollowers = seller.getFollowers().size();
        System.out.println(countFollowers);
        return new SellerFollowerCountResponse(seller.getId(),seller.getName(),countFollowers);
    }
}
