package projeto.mongo.sboot.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import projeto.mongo.sboot.domain.Post;
import projeto.mongo.sboot.domain.Users;
import projeto.mongo.sboot.dto.AuthorDTO;
import projeto.mongo.sboot.dto.UsersDTO;
import projeto.mongo.sboot.repositories.PostRepository;
import projeto.mongo.sboot.repositories.UsersRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
  
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usersRepository.deleteAll();
		Users maria = new Users(null, "Maria Brown", "maria@gmail.com");
		Users alex = new Users(null, "Alex Green", "alex@gmail.com");
		Users bob = new Users(null, "Bob Grey", "bob@gmail.com");
		usersRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		
		List<Users> dto = new ArrayList<>();
		dto.add(maria);	
		dto.add(alex);
		
		AuthorDTO dtx = new AuthorDTO(maria) ;
		AuthorDTO dtx1 = new AuthorDTO(alex) ;
		AuthorDTO dtx2 = new AuthorDTO(bob) ;
		List<AuthorDTO> listagem1 = new ArrayList<>();
		listagem1.add(dtx);
		listagem1.add(dtx1);
		List<AuthorDTO> listagem2 = new ArrayList<>();
		listagem2.add(dtx2);
		
		
		postRepository.deleteAll();
		Post p1 = new Post(null,sdf.parse("21/03/2018"), "Partiu viagems", "Vou viajar para EUA. Abs",listagem1);
		Post p2 = new Post(null,sdf.parse("23/03/2018"), "Bom dia", "Acordei bem jhonson",listagem2);
		
		postRepository.saveAll(Arrays.asList(p1,p2));
	}
	

}
