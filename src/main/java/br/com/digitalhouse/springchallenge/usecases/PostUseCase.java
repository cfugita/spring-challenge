package br.com.digitalhouse.springchallenge.usecases;

import br.com.digitalhouse.springchallenge.usecases.models.requests.PostRequest;

public interface PostUseCase {
    void create(Long sellerId, PostRequest postRequest);
}
