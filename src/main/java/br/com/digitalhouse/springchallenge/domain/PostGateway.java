package br.com.digitalhouse.springchallenge.domain;

import br.com.digitalhouse.springchallenge.usecases.models.requests.PostRequest;

public interface PostGateway {
    void create(Long sellerId, PostRequest postRequest);
}
