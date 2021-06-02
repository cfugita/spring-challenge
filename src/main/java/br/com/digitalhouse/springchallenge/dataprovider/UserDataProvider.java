package br.com.digitalhouse.springchallenge.dataprovider;

import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.dataprovider.repository.SellerRepository;
import br.com.digitalhouse.springchallenge.dataprovider.repository.UserRepository;
import br.com.digitalhouse.springchallenge.domain.UserGateway;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;

import org.springframework.stereotype.Service;

@Service
public class UserDataProvider implements UserGateway {
    private UserRepository userRepository;
    private SellerRepository sellerRepository;

    public UserDataProvider(UserRepository userRepository, SellerRepository sellerRepository) {
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public void followSeller(Long userId, Long sellerId) {
        Seller seller = this.sellerRepository.findAll().stream().filter(s -> s.getId().equals(sellerId)).findFirst().get();
        User user = this.userRepository.findAll().stream().filter(u -> u.getId().equals(userId)).findFirst().get();

        user.addFollowing(seller);
        seller.addFollower(user);
        this.sellerRepository.save(seller);
        this.userRepository.save(user);
    }

    @Override
    public void create(String name){
        User user = new User(null,name);
        var userData = userRepository.save(user);
    }
}
