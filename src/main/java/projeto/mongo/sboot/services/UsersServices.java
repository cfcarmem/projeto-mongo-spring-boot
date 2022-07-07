package projeto.mongo.sboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.mongo.sboot.domain.Users;
import projeto.mongo.sboot.dto.UsersDTO;
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
	
	public Users fromDTO(UsersDTO objDto) {
		//vamos retornar um objeto Users
		return new Users(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	public Users insere(Users user) {
		//usar o Option da classe Optional para retornar 
		return  repository.save(user);
	}
	
	public void deletar(String id) {
		//usar o Option da classe Optional para retornar 
		  repository.deleteById(id);
	}
	

}
