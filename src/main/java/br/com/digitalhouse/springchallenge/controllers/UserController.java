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

    @PostMapping("/create")
    public void create (@RequestBody String name) {
        this.userUseCase.create(name);
    }

    @PostMapping("/{userId}/follow/{sellerId}")
    public void followSeller (@PathVariable Long userId, @PathVariable Long sellerId) {
        this.userUseCase.followSeller(userId,sellerId);
    }

    @GetMapping("/{userId}/following/list")
    public ResponseEntity<Object> listFollowers (@PathVariable Long userId) {
        try {
            return new ResponseEntity<>(this.userUseCase.getListFollowing(userId), HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
