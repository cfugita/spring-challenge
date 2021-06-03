package br.com.digitalhouse.springchallenge.domain;

import br.com.digitalhouse.springchallenge.dataprovider.entity.Product;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostRequest;
import br.com.digitalhouse.springchallenge.usecases.models.responses.SellerFollowerCountResponse;

public interface SellerGateway {
    Seller getById(Long sellerId);
    void newPost(Long sellerId, Long productId, PostRequest postRequest);
    Product getProductById(Long sellerId, Long productId);
}
