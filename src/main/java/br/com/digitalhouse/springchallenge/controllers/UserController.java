package br.com.digitalhouse.springchallenge.controllers;

import br.com.digitalhouse.springchallenge.usecases.UserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping("/{userId}/follow/{sellerId}")
    public void followSeller (@PathVariable Long userId, @PathVariable Long sellerId) {
        this.userUseCase.followSeller(userId,sellerId);
    }

    @PostMapping("/{userId}/unfollow/{sellerId}")
    public void unfollowSeller (@PathVariable Long userId, @PathVariable Long sellerId) {
        this.userUseCase.unfollowSeller(userId,sellerId);
    }

    @GetMapping("/{userId}/following/list")
    public ResponseEntity<Object> listFollowers (@PathVariable Long userId) {
        try {
            return new ResponseEntity<>(this.userUseCase.getListFollowing(userId), HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{userId}/products/following")
    public ResponseEntity<Object> getFeed (@PathVariable Long userId) {
        try {
            return new ResponseEntity<>(this.userUseCase.getFeed(userId), HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
