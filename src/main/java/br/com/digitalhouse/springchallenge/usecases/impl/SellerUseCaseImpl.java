package br.com.digitalhouse.springchallenge.usecases.impl;

import br.com.digitalhouse.springchallenge.domain.SellerGateway;
import br.com.digitalhouse.springchallenge.usecases.SellerUseCase;
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
}
