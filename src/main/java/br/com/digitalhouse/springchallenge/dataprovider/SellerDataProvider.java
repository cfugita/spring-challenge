package br.com.digitalhouse.springchallenge.dataprovider;

import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;
import br.com.digitalhouse.springchallenge.dataprovider.repository.SellerRepository;
import br.com.digitalhouse.springchallenge.domain.SellerGateway;
import br.com.digitalhouse.springchallenge.usecases.models.responses.SellerFollowerCountResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerDataProvider implements SellerGateway {

    SellerRepository sellerRepository;

    public SellerDataProvider(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public void create(String name) {
        Seller seller = new Seller(null,name);
        var userData = sellerRepository.save(seller);
    }

    @Override
    public Seller getById(Long sellerId) {
//        Seller seller = this.sellerRepository.getById(sellerId);
        Optional<Seller> seller = this.sellerRepository.findAll().stream().filter(s -> s.getId().equals(sellerId)).findFirst();
        return seller.orElse(null);
    }
}
