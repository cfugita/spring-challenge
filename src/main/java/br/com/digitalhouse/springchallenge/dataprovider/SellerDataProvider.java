package br.com.digitalhouse.springchallenge.dataprovider;

import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;
import br.com.digitalhouse.springchallenge.dataprovider.repository.SellerRepository;
import br.com.digitalhouse.springchallenge.domain.SellerGateway;
import org.springframework.stereotype.Service;

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
}
