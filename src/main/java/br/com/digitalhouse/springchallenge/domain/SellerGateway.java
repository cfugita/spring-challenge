package br.com.digitalhouse.springchallenge.domain;

import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.usecases.models.responses.SellerFollowerCountResponse;

public interface SellerGateway {
    void create (String name);
    Seller getById(Long sellerId);
}
