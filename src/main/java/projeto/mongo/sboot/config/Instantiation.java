package projeto.mongo.sboot.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import projeto.mongo.sboot.domain.Comment;
import projeto.mongo.sboot.domain.Post;
import projeto.mongo.sboot.domain.Users;
import projeto.mongo.sboot.dto.AuthorDTO;
import projeto.mongo.sboot.dto.CommentDTO;
import projeto.mongo.sboot.dto.UsersDTO;
import projeto.mongo.sboot.repositories.CommentRepository;
import projeto.mongo.sboot.repositories.PostRepository;
import projeto.mongo.sboot.repositories.UsersRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
  
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
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
		
		
		postRepository.deleteAll();
		Post p1 = new Post(null,sdf.parse("21/03/2018"), "Partiu viagems", "Vou viajar para EUA. Abs");
		Post p2 = new Post(null,sdf.parse("23/03/2018"), "Bom dia", "Acordei bem jhonson");
		postRepository.saveAll(Arrays.asList(p1,p2));
		 
	    p1.getAuthor().addAll(Arrays.asList(dtx,dtx1));
	    p2.getAuthor().addAll(Arrays.asList(dtx2,dtx1));
	    postRepository.save(p1);
	    postRepository.save(p2);
	    
		maria.getPosts().addAll(Arrays.asList(p1,p2));
		usersRepository.save(maria);
		
		commentRepository.deleteAll();
		//coment??rios
		Comment c1 = new Comment(null,"Aproveitem", sdf.parse("21/03/2018"),dtx);
		Comment c2 = new Comment(null,"Boa Viagem Mano", sdf.parse("21/03/2018"),dtx2);
		Comment c3 = new Comment(null,"Tenha um ??timo dia", sdf.parse("23/03/2018"),dtx1);
		commentRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		CommentDTO dt1 = new CommentDTO(c1);
		CommentDTO dt2 = new CommentDTO(c2);
		CommentDTO dt3 = new CommentDTO(c3);
		
		//comentarios nos posts
		
		p1.getComment().addAll(Arrays.asList(dt1,dt2));
		p2.getComment().addAll(Arrays.asList(dt3));
		postRepository.saveAll(Arrays.asList(p1,p2));
		
		

		
	}
	

}
