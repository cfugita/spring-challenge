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

		User user1 = new User("Camila Oliveira");
		User user2 = new User("Pedro Lima");
		Seller seller1 = new Seller ("Fast Shop");
		Seller seller2 = new Seller ("Americanas");

		sellerRepository.save(seller1);
		sellerRepository.save(seller2);

		userRepository.save(user1);
		userRepository.save(user2);

		Product product1 = new Product("Chair", "Gamer","Racer","Red","Special Edition");
		Product product2 = new Product("Keyboard", "Gamer","Racer","White","Connection Bluetooth");

		seller1.addProduct(product1);
		seller2.addProduct(product2);
		sellerRepository.save(seller1);
		sellerRepository.save(seller2);
	}
}
