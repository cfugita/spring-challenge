package br.com.digitalhouse.springchallenge;

import br.com.digitalhouse.springchallenge.dataprovider.entity.Product;
import br.com.digitalhouse.springchallenge.dataprovider.entity.User;
import br.com.digitalhouse.springchallenge.dataprovider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringChallengeApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User("Camila Oliveira", false);
		User user2 = new User("Pedro Lima", false);
		User user3 = new User ("Fast Shop", true);
		User user4 = new User ("Americanas", true);

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);

		Product product1 = new Product("Chair", "Gamer","Racer","Red","Special Edition",100,500.00);
		Product product2 = new Product("Keyboard", "Gamer","Racer","White","Connection Bluetooth",120,210.00);
		Product product3 = new Product("Notebook", "IdeaPad","Lenovo","Black","1TB",300,1200.00);

		user3.addProducts(product1);
		user4.addProducts(product2);
		user4.addProducts(product3);
		userRepository.save(user3);
		userRepository.save(user4);
	}
}
