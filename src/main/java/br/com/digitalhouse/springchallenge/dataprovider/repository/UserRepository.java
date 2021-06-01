package br.com.digitalhouse.springchallenge.dataprovider.repository;

import br.com.digitalhouse.springchallenge.dataprovider.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
