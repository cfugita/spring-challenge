package br.com.digitalhouse.springchallenge.controllers;

import br.com.digitalhouse.springchallenge.usecases.UserUseCase;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostPromoRequest;
import br.com.digitalhouse.springchallenge.usecases.models.requests.ProductRequest;
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

    @GetMapping("/all")
    public ResponseEntity<Object> getAllUsers () {
        return new ResponseEntity<>(this.userUseCase.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userToFollowId}")
    public void follow (@PathVariable Long userId, @PathVariable Long userToFollowId) {
        this.userUseCase.follow(userId, userToFollowId);
    }

    @PostMapping("/{userId}/unfollow/{userToUnfollowId}")
    public void unfollow (@PathVariable Long userId, @PathVariable Long userToUnfollowId) {
        this.userUseCase.unfollow(userId, userToUnfollowId);
    }

    @GetMapping("/{userId}/following/list")
    public ResponseEntity<Object> listFollowing (@PathVariable Long userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(this.userUseCase.getListFollowing(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<Object> countFollowers (@PathVariable Long userId) {
        return new ResponseEntity<>(this.userUseCase.countFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<Object> listFollowers (@PathVariable Long userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(this.userUseCase.getListFollowers(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/product/new")
    public ResponseEntity<Object> newProduct (@PathVariable Long userId, @RequestBody ProductRequest productRequest){
        return new ResponseEntity<>(this.userUseCase.newProduct(userId,productRequest), HttpStatus.OK);
    }

    @GetMapping("/{userId}/products")
    public ResponseEntity<Object> productsByUser (@PathVariable Long userId){
        return new ResponseEntity<>(this.userUseCase.productsByUser(userId), HttpStatus.OK);
    }

    @PostMapping("/{userId}/product/{productId}/newPost")
    public ResponseEntity<Object> newPost (@PathVariable Long userId, @PathVariable Long productId){
        return new ResponseEntity<>(this.userUseCase.newPost(userId, productId),HttpStatus.OK);
    }

    @PostMapping("/{userId}/product/{productId}/newPromoPost")
    public ResponseEntity<Object> newPromoPost (@PathVariable Long userId, @PathVariable Long productId, @RequestBody PostPromoRequest postPromoRequest){
        return new ResponseEntity<>(this.userUseCase.newPromoPost(userId, productId, postPromoRequest),HttpStatus.OK);
    }

    @GetMapping("/{userId}/following/posts")
    public ResponseEntity<Object> getFeed (@PathVariable Long userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(this.userUseCase.getFeed(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/posts/count")
    public ResponseEntity<Object> countPosts (@PathVariable Long userId, @RequestParam(required = false) String type) {
        return new ResponseEntity<>(this.userUseCase.countPosts(userId, type),HttpStatus.OK);
    }

    @GetMapping("/{userId}/posts/list")
    public ResponseEntity<Object> listPosts (@PathVariable Long userId, @RequestParam(required = false) String type) {
        return new ResponseEntity<>(this.userUseCase.getOwnPosts(userId, type),HttpStatus.OK);
    }
}
