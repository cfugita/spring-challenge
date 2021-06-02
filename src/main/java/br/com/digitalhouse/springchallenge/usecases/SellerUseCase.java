package br.com.digitalhouse.springchallenge.usecases;

import br.com.digitalhouse.springchallenge.usecases.models.responses.SellerFollowerCountResponse;

public interface SellerUseCase {
    void create (String name);
    SellerFollowerCountResponse countFollowers (Long sellerId);
}
