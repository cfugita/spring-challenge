package br.com.digitalhouse.springchallenge.controllers;

import br.com.digitalhouse.springchallenge.usecases.SellerUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
