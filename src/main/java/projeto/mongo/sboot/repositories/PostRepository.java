package projeto.mongo.sboot.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import projeto.mongo.sboot.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	//query methods do mongo
	List<Post>findByTitleContainingIgnoreCase(String text);
	
	//?0 primeiro parâmentro
	@Query("{ 'title': {$regex: ?0, $options: 'i'}}")
	List<Post>searchTitleQuery(String text);
	
	
	//seguindo parâmetros do método  (comment.text busca no texto de cada comentario o pos comment é objeto)
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comment.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> searchAvancada(String text, Date minDate, Date maxDate);
}
