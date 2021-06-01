package br.com.digitalhouse.springchallenge.usecases.impl;

import br.com.digitalhouse.springchallenge.domain.UserGateway;
import br.com.digitalhouse.springchallenge.usecases.UserUseCase;
import org.springframework.stereotype.Service;

@Service
public class UserUseCaseImpl implements UserUseCase {
    private UserGateway userGateway;

    public UserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void create(String name) {
        userGateway.create(name);
    }

    @Override
    public void followSeller(Long userId, Long sellerId) {
        this.userGateway.followSeller(userId,sellerId);
    }
}
