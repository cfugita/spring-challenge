package br.com.digitalhouse.springchallenge.domain;


import br.com.digitalhouse.springchallenge.dataprovider.entity.User;

public interface UserGateway {
    void followSeller (Long userId,Long sellerId);
    User getById (Long userId);
}
