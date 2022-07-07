package projeto.mongo.sboot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import projeto.mongo.sboot.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	//query methods do mongo
	List<Post>findByTitleContainingIgnoreCase(String text);
}
