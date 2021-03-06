package projeto.mongo.sboot.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import projeto.mongo.sboot.domain.Post;
import projeto.mongo.sboot.domain.Users;
import projeto.mongo.sboot.dto.PostsDTO;
import projeto.mongo.sboot.dto.UsersDTO;
import projeto.mongo.sboot.services.UsersServices;

@RestController
@RequestMapping(value="/users")
public class UsersResource {
	@Autowired

	private UsersServices service;
	
	@GetMapping
	public ResponseEntity<List<UsersDTO>> findAll(){
		List<Users> lista = service.findAll();
		List<UsersDTO> listDTO = lista.stream().map(x-> new UsersDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UsersDTO> findbyId(@PathVariable String id){
		Users obj = service.findById(id);
		return ResponseEntity.ok().body(new UsersDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<Users> insert(@RequestBody UsersDTO usuarioDTO){
		//converter DTO para Users
		Users obj = service.fromDTO(usuarioDTO);
		URI uri  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(service.insere(obj));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		//converter DTO para Users
		service.deletar(id);
		//nocontent ?? o codigo 205
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UsersDTO objDTO){
		//converter DTO para Users
		Users obj = service.fromDTO(objDTO);
		obj.setId(id);
		service.update(obj);
		//nocontent ?? o codigo 205
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value="/postagens/{id}")
	public ResponseEntity<List<PostsDTO>> postagens(@PathVariable String id,@RequestBody UsersDTO objDto){
		Users usu = service.findById(id);
		List<Post> usup = usu.getPosts();
		List<PostsDTO> listagem = new ArrayList<>();
		for(Post p: usup) {
			PostsDTO dto = new PostsDTO(p);
			listagem.add(dto);
		}
		return ResponseEntity.ok().body(listagem);
	}
	
}
