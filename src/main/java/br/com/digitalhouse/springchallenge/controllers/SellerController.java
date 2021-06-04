package br.com.digitalhouse.springchallenge.controllers;

import br.com.digitalhouse.springchallenge.usecases.SellerUseCase;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
public class SellerController {

    SellerUseCase sellerUseCase;

    public SellerController(SellerUseCase sellerUseCase) {
        this.sellerUseCase = sellerUseCase;
    }

    @GetMapping("/{sellerId}/followers/count/")
    public ResponseEntity<Object> countFollowers (@PathVariable Long sellerId) {
        try {
            return new ResponseEntity<>(this.sellerUseCase.countFollowers(sellerId), HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{sellerId}/followers/list/")
    public ResponseEntity<Object> listFollowers (@PathVariable Long sellerId) {
        try {
            return new ResponseEntity<>(this.sellerUseCase.getListFollowers(sellerId), HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("{sellerId}/product/{productId}/newPost")
    void newPost(@PathVariable Long sellerId, @PathVariable Long productId, @RequestBody PostRequest postRequest){
        this.sellerUseCase.newPost(sellerId, productId, postRequest);
    }
}
