package br.com.digitalhouse.springchallenge.dataprovider;

import br.com.digitalhouse.springchallenge.dataprovider.DTO.FeedDTO;
import br.com.digitalhouse.springchallenge.dataprovider.DTO.PostDTO;
import br.com.digitalhouse.springchallenge.dataprovider.DTO.ProductDTO;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Post;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Product;
import br.com.digitalhouse.springchallenge.dataprovider.repository.ProductRepository;
import br.com.digitalhouse.springchallenge.dataprovider.repository.UserRepository;
import br.com.digitalhouse.springchallenge.domain.UserGateway;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;

import br.com.digitalhouse.springchallenge.usecases.exceptions.AlreadyDoneException;
import br.com.digitalhouse.springchallenge.usecases.exceptions.NotFoundException;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostPromoRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserDataProvider implements UserGateway {
    private UserRepository userRepository;
    private ProductRepository productRepository;

    public UserDataProvider(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void follow (Long userId, Long userToFollowId) {

        User userFollowing = this.getUserById(userId);
        User userToFollow = this.getUserById(userToFollowId);

        if(!userToFollow.getIsSeller()) {
            throw new AlreadyDoneException("User " + userToFollowId + " can't be followed"); }

        if(userFollowing.getFollowing().contains(userToFollow)) {
            throw new AlreadyDoneException("User " + userId + " already follows user " + userToFollow); }

        userFollowing.addFollowing(userToFollow);

        this.userRepository.save(userFollowing);
    }

    @Override
    public void unfollow (Long userId, Long userToUnfollowId) {

        User userFollowing = this.getUserById(userId);
        User userToUnfollow = this.getUserById(userToUnfollowId);

        if(!userFollowing.getFollowing().contains(userToUnfollow)) {
            throw new AlreadyDoneException("User " + userId + " does not follow user " + userToUnfollowId); }

        userFollowing.removeFollowing(userToUnfollow);

        this.userRepository.save(userFollowing);
    }

    @Override
    public User getUserById (Long userId) {
        Optional<User> userOpt = this.userRepository.findAll().stream().filter(s -> s.getId().equals(userId)).findFirst();

        if(userOpt.isEmpty()) {
            throw new NotFoundException("User " + userId + " not found"); }

        return userOpt.get();
    }

    @Override
    public Product getProductById (Long userId, Long productId) {
        User user = getUserById(userId);
        if(!user.getIsSeller()) {
            throw new AlreadyDoneException("User " + userId + " is not a seller"); }

        Optional<Product> productOpt = user.getProducts().stream().filter(p -> p.getId().equals(productId)).findFirst();

        if(productOpt.isEmpty()) {
            throw new NotFoundException("Product " + productId + " not found for user " + userId); }

        return productOpt.get();
    }

    @Override
    public void newPost (Long userId, Long productId) {
        Product product = getProductById(userId,productId);
        Post post = new Post();
        product.addPost(post);
        this.productRepository.save(product);
    }

    @Override
    public void newPromoPost (Long userId, Long productId, PostPromoRequest postPromoRequest) {
        Product product = getProductById(userId,productId);
        Post post = new Post(postPromoRequest.getDiscount());
        product.addPost(post);
        this.productRepository.save(product);
    }

    @Override
    public FeedDTO getFeed (Long userId) {
        User user = this.getUserById(userId);
        List<User> userFollowing = user.getFollowing();

        List<PostDTO> postsFeed = new ArrayList<>();

        for(User userFollowed : userFollowing) {
            postsFeed.addAll(getPostsByUser(userFollowed));
        }
        return new FeedDTO(user.getId(), user.getName(), postsFeed);
    }

    @Override
    public FeedDTO getOwnPosts(Long userId) {
        User user = this.getUserById(userId);

        if(!user.getIsSeller()) { throw new AlreadyDoneException("User " + userId + " is not a seller"); }

        List<PostDTO> postsFeed = getPostsByUser(user);

        return new FeedDTO(user.getId(), user.getName(), postsFeed);
    }

    public List<PostDTO> getPostsByUser (User user) {
        List<PostDTO> postsByUser = new ArrayList<>();
        List<Product> userProducts = user.getProducts();
        Date date = Calendar.getInstance().getTime(); // DATA P ULTIMA SEMANA AQUI!!!!!!

        for(Product product : userProducts) {
            ProductDTO productDTO = new ProductDTO(
                    product.getId(),
                    product.getName(),
                    product.getType(),
                    product.getBrand(),
                    product.getColor(),
                    product.getNotes(),
                    product.getCategory(),
                    product.getPrice());

            List<Post> posts = product.getPosts().stream().filter(p -> p.getDate().before(date)).collect(Collectors.toList());

            for (Post post : posts) {
                PostDTO postDTO = new PostDTO(
                        post.getId(),
                        user.getName(),
                        post.getDate(),
                        productDTO,
                        post.getHasPromo(),
                        post.getDiscount());
                postsByUser.add(postDTO);
            }
        }
        return postsByUser;
    }
}
