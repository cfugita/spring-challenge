package br.com.digitalhouse.springchallenge.controllers;

import br.com.digitalhouse.springchallenge.usecases.UserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/{userId}")
public class UserController {
    private UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping("/follow/{userToFollowId}")
    public void follow (@PathVariable Long userId, @PathVariable Long userToFollowId) {
        this.userUseCase.follow(userId,userToFollowId);
    }

    @PostMapping("/unfollow/{userToUnfollowId}")
    public void unfollow (@PathVariable Long userId, @PathVariable Long userToUnfollowId) {
        this.userUseCase.unfollow(userId,userToUnfollowId);
    }

    @GetMapping("/following/list")
    public ResponseEntity<Object> listFollowing (@PathVariable Long userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(this.userUseCase.getListFollowing(userId, order), HttpStatus.OK);
    }

    @GetMapping("/followers/count")
    public ResponseEntity<Object> countFollowers (@PathVariable Long userId) {
        return new ResponseEntity<>(this.userUseCase.countFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/followers/list")
    public ResponseEntity<Object> listFollowers (@PathVariable Long userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(this.userUseCase.getListFollowers(userId, order), HttpStatus.OK);
    }
}
