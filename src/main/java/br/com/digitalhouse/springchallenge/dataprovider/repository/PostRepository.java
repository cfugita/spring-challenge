package br.com.digitalhouse.springchallenge.dataprovider.repository;

import br.com.digitalhouse.springchallenge.dataprovider.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
