package projeto.mongo.sboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.mongo.sboot.domain.Post;
import projeto.mongo.sboot.repositories.PostRepository;
import projeto.mongo.sboot.services.exceptions.ObjectNotFoundException;

@Service
public class PostServices {

	@Autowired
	private PostRepository repo;
	
	public List<Post>findAll(){
		return repo.findAll();
	}
	
	public Post findById(String id) {
		//usar o Option da classe Optional para retornar 
		 Optional<Post> obj = repo.findById(id);
		 //return obj.get();
		 //depois de criar as exceções personalizadas, vamos retornar assim
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
	}
}
