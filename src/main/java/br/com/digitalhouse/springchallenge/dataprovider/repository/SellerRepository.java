package br.com.digitalhouse.springchallenge.dataprovider.repository;

import br.com.digitalhouse.springchallenge.dataprovider.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Long> {
}
