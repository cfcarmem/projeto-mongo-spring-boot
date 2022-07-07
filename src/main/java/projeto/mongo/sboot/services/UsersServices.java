package projeto.mongo.sboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.mongo.sboot.domain.Users;
import projeto.mongo.sboot.repositories.UsersRepository;

@Service
public class UsersServices {
	@Autowired
	private UsersRepository repository;
	
	public List<Users>findAll(){
		return repository.findAll();
	}

}
