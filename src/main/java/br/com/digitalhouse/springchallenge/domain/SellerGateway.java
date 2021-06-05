package br.com.digitalhouse.springchallenge.domain;

import br.com.digitalhouse.springchallenge.dataprovider.DTO.FeedDTO;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Product;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostPromoRequest;
import br.com.digitalhouse.springchallenge.usecases.models.responses.UserFeedResponse;

public interface SellerGateway {
    Seller getSellerById(Long sellerId);
    void newPost(Long sellerId, Long productId);
    void newPromoPost(Long sellerId, Long productId, PostPromoRequest postPromoRequest);
    Product getProductById(Long sellerId, Long productId);
    FeedDTO getPosts(Long sellerId);
}
