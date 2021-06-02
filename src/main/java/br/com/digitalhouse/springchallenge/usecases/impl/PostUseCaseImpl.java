package br.com.digitalhouse.springchallenge.usecases.impl;

import br.com.digitalhouse.springchallenge.domain.PostGateway;
import br.com.digitalhouse.springchallenge.usecases.PostUseCase;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostRequest;
import org.springframework.stereotype.Service;

@Service
public class PostUseCaseImpl implements PostUseCase {

    PostGateway postGateway;

    public PostUseCaseImpl(PostGateway postGateway) {
        this.postGateway = postGateway;
    }

    @Override
    public void create(Long sellerId, PostRequest postRequest) {
        this.postGateway.create(sellerId, postRequest);
    }
}
