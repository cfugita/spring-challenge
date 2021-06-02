package br.com.digitalhouse.springchallenge.usecases;

import br.com.digitalhouse.springchallenge.usecases.models.responses.SellerFollowerCountResponse;
import br.com.digitalhouse.springchallenge.usecases.models.responses.SellerFollowerListResponse;

public interface SellerUseCase {
    SellerFollowerCountResponse countFollowers (Long sellerId);
    SellerFollowerListResponse getListFollowers (Long sellerId);
}
