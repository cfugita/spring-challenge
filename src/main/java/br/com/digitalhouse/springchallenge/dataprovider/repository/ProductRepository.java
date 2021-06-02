package br.com.digitalhouse.springchallenge.dataprovider.repository;

import br.com.digitalhouse.springchallenge.dataprovider.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
