package br.com.digitalhouse.springchallenge.usecases;

public interface UserUseCase {
    void create (String name);
    void followSeller (Long userId, Long sellerId);
}
