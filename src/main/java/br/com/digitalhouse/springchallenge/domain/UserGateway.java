package br.com.digitalhouse.springchallenge.domain;


public interface UserGateway {
    void create (String name);
    void followSeller (Long userId,Long sellerId);
}
