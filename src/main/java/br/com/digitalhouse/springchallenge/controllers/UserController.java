package br.com.digitalhouse.springchallenge.controllers;

import br.com.digitalhouse.springchallenge.usecases.UserUseCase;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostPromoRequest;
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
        this.userUseCase.follow(userId, userToFollowId);
    }

    @PostMapping("/unfollow/{userToUnfollowId}")
    public void unfollow (@PathVariable Long userId, @PathVariable Long userToUnfollowId) {
        this.userUseCase.unfollow(userId, userToUnfollowId);
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

    @PostMapping("/product/{productId}/newPost")
    void newPost (@PathVariable Long userId, @PathVariable Long productId){
        this.userUseCase.newPost(userId, productId);
    }

    @PostMapping("/product/{productId}/newPromoPost")
    void newPromoPost (@PathVariable Long userId, @PathVariable Long productId, @RequestBody PostPromoRequest postPromoRequest){
        this.userUseCase.newPromoPost(userId, productId, postPromoRequest);
    }

    @GetMapping("/following/posts")
    public ResponseEntity<Object> getFeed (@PathVariable Long userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(this.userUseCase.getFeed(userId, order), HttpStatus.OK);
    }

    @GetMapping("/posts/count")
    public ResponseEntity<Object> countPosts (@PathVariable Long userId, @RequestParam(required = false) String type) {
        return new ResponseEntity<>(this.userUseCase.countPosts(userId, type),HttpStatus.OK);
    }

    @GetMapping("/posts/list")
    public ResponseEntity<Object> listPosts (@PathVariable Long userId, @RequestParam(required = false) String type) {
        return new ResponseEntity<>(this.userUseCase.getOwnPosts(userId, type),HttpStatus.OK);
    }
}
