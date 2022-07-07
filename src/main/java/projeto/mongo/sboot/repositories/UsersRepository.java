package projeto.mongo.sboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import projeto.mongo.sboot.domain.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {

}
