package br.com.digitalhouse.springchallenge.controllers;

import br.com.digitalhouse.springchallenge.usecases.SellerUseCase;
import br.com.digitalhouse.springchallenge.usecases.models.responses.SellerFollowerCountResponse;
import org.springframework.http.HttpEntity;
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

    @PostMapping("/create")
    void create (@RequestBody String name) {
        this.sellerUseCase.create(name);
    }

    @GetMapping("/{sellerId}/followers/count/")
    public ResponseEntity<Object> countFollowers (@PathVariable Long sellerId) {
        try {
            return new ResponseEntity<>(this.sellerUseCase.countFollowers(sellerId), HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
