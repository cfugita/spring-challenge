package br.com.digitalhouse.springchallenge.controllers;

import br.com.digitalhouse.springchallenge.usecases.SellerUseCase;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostPromoRequest;
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
        return new ResponseEntity<>(this.sellerUseCase.countFollowers(sellerId), HttpStatus.OK);
    }

    @GetMapping("/{sellerId}/followers/list/")
    public ResponseEntity<Object> listFollowers (@PathVariable Long sellerId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(this.sellerUseCase.getListFollowers(sellerId, order), HttpStatus.OK);
    }

    @PostMapping("{sellerId}/product/{productId}/newpost")
    void newPost(@PathVariable Long sellerId, @PathVariable Long productId){
        this.sellerUseCase.newPost(sellerId, productId);
    }

    @PostMapping("{sellerId}/product/{productId}/newpromopost")
    void newPromoPost(@PathVariable Long sellerId, @PathVariable Long productId, @RequestBody PostPromoRequest postPromoRequest){
        this.sellerUseCase.newPromoPost(sellerId, productId, postPromoRequest);
    }

    @GetMapping("/{sellerId}/product/countPromo")
    public ResponseEntity<Object> countPromoPosts (@PathVariable Long sellerId) {
        return new ResponseEntity<>(this.sellerUseCase.countPromoPosts(sellerId),HttpStatus.OK);
    }

    @GetMapping("/{sellerId}/product/listPromo")
    public ResponseEntity<Object> listPromoPosts (@PathVariable Long sellerId) {
        return new ResponseEntity<>(this.sellerUseCase.getPromoPosts(sellerId),HttpStatus.OK);
    }
}
