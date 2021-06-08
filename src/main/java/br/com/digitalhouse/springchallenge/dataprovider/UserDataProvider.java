package br.com.digitalhouse.springchallenge.dataprovider;

import br.com.digitalhouse.springchallenge.dataprovider.DTO.FeedDTO;
import br.com.digitalhouse.springchallenge.dataprovider.DTO.PostDTO;
import br.com.digitalhouse.springchallenge.dataprovider.DTO.ProductDTO;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Post;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Product;
import br.com.digitalhouse.springchallenge.dataprovider.repository.PostRepository;
import br.com.digitalhouse.springchallenge.dataprovider.repository.ProductRepository;
import br.com.digitalhouse.springchallenge.dataprovider.repository.UserRepository;
import br.com.digitalhouse.springchallenge.domain.UserGateway;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;

import br.com.digitalhouse.springchallenge.usecases.exceptions.AlreadyDoneException;
import br.com.digitalhouse.springchallenge.usecases.exceptions.NotFoundException;
import br.com.digitalhouse.springchallenge.usecases.models.requests.PostPromoRequest;
import br.com.digitalhouse.springchallenge.usecases.models.requests.ProductRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserDataProvider implements UserGateway {
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private PostRepository postRepository;

    public UserDataProvider(UserRepository userRepository, ProductRepository productRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public void follow (Long userId, Long userToFollowId) {

        User userFollowing = this.getUserById(userId);
        User userToFollow = this.getUserById(userToFollowId);

        if(!userToFollow.getIsSeller()) {
            throw new IllegalArgumentException("User " + userToFollowId + " can't be followed"); }

        if(userFollowing.getFollowing().contains(userToFollow)) {
            throw new AlreadyDoneException("User " + userId + " already follows user " + userToFollowId); }

        if(userId.equals(userToFollowId)) {
            throw new IllegalArgumentException("Users can't follow themselves"); }

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
            throw new IllegalArgumentException("User " + userId + " is not a seller"); }

        Optional<Product> productOpt = user.getProducts().stream().filter(p -> p.getId().equals(productId)).findFirst();

        if(productOpt.isEmpty()) {
            throw new NotFoundException("Product " + productId + " not found for user " + userId); }

        return productOpt.get();
    }

    @Override
    public ProductDTO newProduct(Long userId, ProductRequest productRequest) {
        User user = getUserById(userId);

        if(!user.getIsSeller()) { throw new IllegalArgumentException("User " + userId + " is not a seller"); }

        Product product = new Product(
                productRequest.getName(),
                productRequest.getType(),
                productRequest.getBrand(),
                productRequest.getColor(),
                productRequest.getNotes(),
                productRequest.getCategory(),
                productRequest.getPrice());

        product = this.productRepository.save(product);
        user.addProducts(product);
        this.userRepository.save(user);

        return new ProductDTO(product);
    }

    @Override
    public List<ProductDTO> productsByUser(Long userId) {
        User user = this.getUserById(userId);

        if(!user.getIsSeller()) { throw new IllegalArgumentException("User " + userId + " is not a seller"); }

        List<ProductDTO> products = new ArrayList<>();

        for(Product product : user.getProducts()) {
            ProductDTO productDTO = new ProductDTO(product);
            products.add(productDTO);
        }

        return products;
    }

    @Override
    public PostDTO newPost (Long userId, Long productId) {
        Product product = getProductById(userId,productId);
        User user = this.getUserById(userId);
        Post post = new Post();
        post = this.postRepository.save(post);
        product.addPost(post);
        product = this.productRepository.save(product);

        return new PostDTO(user.getName(),post,product);
    }

    @Override
    public PostDTO newPromoPost (Long userId, Long productId, PostPromoRequest postPromoRequest) {
        Product product = getProductById(userId,productId);
        User user = this.getUserById(userId);
        Post post = new Post(postPromoRequest.getDiscount());
        post = this.postRepository.save(post);
        product.addPost(post);
        product = this.productRepository.save(product);
        product.addPost(post);
        return new PostDTO(user.getName(),post,product);
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

        if(!user.getIsSeller()) {
            throw new IllegalArgumentException("User " + userId + " is not a seller"); }

        List<PostDTO> postsFeed = getPostsByUser(user);

        return new FeedDTO(user.getId(), user.getName(), postsFeed);
    }

    public List<PostDTO> getPostsByUser (User user) {
        List<PostDTO> postsByUser = new ArrayList<>();
        List<Product> userProducts = user.getProducts();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -14);
        Date date = cal.getTime();

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

            List<Post> posts = product.getPosts().stream().filter(p -> p.getDate().after(date)).collect(Collectors.toList());

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
