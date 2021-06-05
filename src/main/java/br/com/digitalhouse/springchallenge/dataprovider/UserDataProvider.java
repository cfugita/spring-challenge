package br.com.digitalhouse.springchallenge.dataprovider;

import br.com.digitalhouse.springchallenge.dataprovider.DTO.PostDTO;
import br.com.digitalhouse.springchallenge.dataprovider.DTO.ProductDTO;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Post;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Product;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.dataprovider.repository.SellerRepository;
import br.com.digitalhouse.springchallenge.dataprovider.repository.UserRepository;
import br.com.digitalhouse.springchallenge.domain.UserGateway;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;

import br.com.digitalhouse.springchallenge.usecases.exceptions.AlreadyDoneException;
import br.com.digitalhouse.springchallenge.usecases.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

        Seller seller = this.getSellerById(sellerId);
        User user = this.getUserById(userId);

        if(user.getFollowing().contains(seller)) { throw new AlreadyDoneException("User " + userId + " already follows seller " + sellerId); }

        user.addFollowing(seller);
        seller.addFollower(user);
        this.sellerRepository.save(seller);
        this.userRepository.save(user);
    }

    @Override
    public void unfollowSeller(Long userId, Long sellerId) {
        Seller seller = this.getSellerById(sellerId);
        User user = this.getUserById(userId);

        if(!user.getFollowing().contains(seller)) { throw new AlreadyDoneException("User " + userId + " does not follow seller " + sellerId); }

        user.removeFollowing(seller);
        seller.removeFollower(user);
        this.sellerRepository.save(seller);
        this.userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> userOpt = this.userRepository.findAll().stream().filter(s -> s.getId().equals(userId)).findFirst();

        if(userOpt.isEmpty()) { throw new NotFoundException("User " + userId + " not found"); }

        return userOpt.get();
    }

    public Seller getSellerById(Long sellerId) {
        Optional<Seller> sellerOpt = this.sellerRepository.findAll().stream().filter(s -> s.getId().equals(sellerId)).findFirst();

        if(sellerOpt.isEmpty()) { throw new NotFoundException("Seller " + sellerId + " not found"); }

        return sellerOpt.get();
    }

    @Override
    public List<PostDTO> getFeed(Long userId) {
        User user = this.getUserById(userId);
        List<Seller> sellerFollowing = user.getFollowing();

        Date date = Calendar.getInstance().getTime();

        List<PostDTO> postsFeed = new ArrayList<>();

        for(Seller seller : sellerFollowing) {

            List<Product> sellerProducts = seller.getProducts();

            for(Product product : sellerProducts) {
                ProductDTO productDTO = new ProductDTO(product.getId(), product.getName(), product.getType(),product.getBrand(), product.getColor(), product.getNotes());
                List<Post> posts = product.getPosts().stream().filter(p -> p.getDate().before(date)).collect(Collectors.toList());

                for (Post post : posts) {
                    PostDTO postDTO = new PostDTO(post.getId(),post.getDate(),productDTO,post.getCategory(),post.getPrice());
                    postsFeed.add(postDTO);
                }
            }
        }
        return postsFeed;
    }
}
