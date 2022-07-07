package projeto.mongo.sboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import projeto.mongo.sboot.domain.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

}
