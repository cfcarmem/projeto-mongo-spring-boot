package projeto.mongo.sboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.mongo.sboot.domain.Users;
import projeto.mongo.sboot.repositories.UsersRepository;
import projeto.mongo.sboot.services.exceptions.ObjectNotFoundException;

@Service
public class UsersServices {
	@Autowired
	private UsersRepository repository;
	
	public List<Users>findAll(){
		return repository.findAll();
	}
	
	public Users findById(String id) {
		//usar o Option da classe Optional para retornar 
		 Optional<Users> obj = repository.findById(id);
		 //return obj.get();
		 //depois de criar as exceções personalizadas, vamos retornar assim
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
	}

}
