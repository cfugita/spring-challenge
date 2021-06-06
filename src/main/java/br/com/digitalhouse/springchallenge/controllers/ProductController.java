package br.com.digitalhouse.springchallenge.controllers;

import br.com.digitalhouse.springchallenge.usecases.UserUseCase;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostPromoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/{userId}/product")
public class ProductController {
    private UserUseCase userUseCase;

    public ProductController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping("/{productId}/newPost")
    void newPost (@PathVariable Long userId, @PathVariable Long productId){
        this.userUseCase.newPost(userId, productId);
    }

    @PostMapping("/{productId}/newPromoPost")
    void newPromoPost(@PathVariable Long userId, @PathVariable Long productId, @RequestBody PostPromoRequest postPromoRequest){
        this.userUseCase.newPromoPost(userId, productId, postPromoRequest);
    }

    @GetMapping("/followingPosts")
    public ResponseEntity<Object> getFeed (@PathVariable Long userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(this.userUseCase.getFeed(userId, order), HttpStatus.OK);
    }

    @GetMapping("/countPosts")
    public ResponseEntity<Object> countPromoPosts (@PathVariable Long userId) {
        return new ResponseEntity<>(this.userUseCase.countPosts(userId),HttpStatus.OK);
    }

    @GetMapping("/listPosts")
    public ResponseEntity<Object> listPromoPosts (@PathVariable Long userId) {
        return new ResponseEntity<>(this.userUseCase.getOwnPosts(userId),HttpStatus.OK);
    }

}
