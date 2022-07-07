package projeto.mongo.sboot.resources;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projeto.mongo.sboot.domain.Post;
import projeto.mongo.sboot.dto.PostsDTO;
import projeto.mongo.sboot.resources.util.URL;
import projeto.mongo.sboot.services.PostServices;


@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostServices service;
	
	@GetMapping
	public ResponseEntity<List<PostsDTO>>findAll(){
		List<Post> lista =  service.findAll();
		List<PostsDTO> listDTO = lista.stream().map(x-> new PostsDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<PostsDTO> findbyId(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(new PostsDTO(obj));
	}
	
	@GetMapping(value="/titlesearch")
	//aqui nós criamos um método que está na documentação do Mongo. É busca por nome. Tem que implementar no Repositories.
	public ResponseEntity<List<Post>> findByTitulo(@RequestParam(value="text", defaultValue="") String text){
		text = URL.decodeParam(text);
		List<Post> lista = service.searchTitleQuery(text);
		return ResponseEntity.ok().body(lista);
	}
	
	
	@GetMapping(value="/findSearchFull")
	//aqui nós criamos um método que está na documentação do Mongo. É busca por nome. Tem que implementar no Repositories.
	public ResponseEntity<List<Post>> fullSearch(
													@RequestParam(value="text", defaultValue="") String text
												   ,@RequestParam(value="minDate", defaultValue = "") String minDate
												   ,@RequestParam(value="maxDate", defaultValue="") String maxDate){
		text = URL.decodeParam(text);
		Date minima = URL.convertDate(minDate, new Date(0));
		Date maxima = URL.convertDate(maxDate, new Date());
		List<Post> lista = service.fullSearchPost(text, minima, maxima);
		return ResponseEntity.ok().body(lista);
	}
	
	

}
