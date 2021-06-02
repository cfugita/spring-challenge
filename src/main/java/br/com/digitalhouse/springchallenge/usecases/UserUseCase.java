package br.com.digitalhouse.springchallenge.usecases;

import br.com.digitalhouse.springchallenge.usecases.models.responses.UserFollowingListResponse;

public interface UserUseCase {
    void followSeller (Long userId, Long sellerId);
    UserFollowingListResponse getListFollowing (Long userId);
}
