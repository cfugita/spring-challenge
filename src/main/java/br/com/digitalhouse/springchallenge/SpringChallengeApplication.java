package br.com.digitalhouse.springchallenge;

import br.com.digitalhouse.springchallenge.dataprovider.entity.Product;
import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;
import br.com.digitalhouse.springchallenge.dataprovider.repository.SellerRepository;
import br.com.digitalhouse.springchallenge.dataprovider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringChallengeApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SellerRepository sellerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("aaaaaaaa");
		User user1 = new User("Camila");
		User user2 = new User("Pedro");
		Seller seller1 = new Seller ("Antonio");
		Seller seller2 = new Seller ("Marcelo");

		sellerRepository.save(seller1);
		sellerRepository.save(seller2);

		userRepository.save(user1);
		userRepository.save(user2);

		Product product1 = new Product("Cadeira Gamer", "Gamer","Racer","Red","Special Edition");

		seller1.addProduct(product1);
		sellerRepository.save(seller1);
	}
}
