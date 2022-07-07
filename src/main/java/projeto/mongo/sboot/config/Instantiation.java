package projeto.mongo.sboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import projeto.mongo.sboot.domain.Users;
import projeto.mongo.sboot.repositories.UsersRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
  
	@Autowired
	private UsersRepository usersRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		usersRepository.deleteAll();
		Users maria = new Users(null, "Maria Brown", "maria@gmail.com");
		Users alex = new Users(null, "Alex Green", "alex@gmail.com");
		Users bob = new Users(null, "Bob Grey", "bob@gmail.com");
		usersRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
