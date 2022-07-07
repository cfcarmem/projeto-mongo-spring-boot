package projeto.mongo.sboot.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projeto.mongo.sboot.domain.Users;

@RestController
@RequestMapping(value="/users")
public class UsersResource {

	@GetMapping
	public ResponseEntity<List<Users>> findAll(){
		Users maria = new Users("1","Maria Costa", "cfcarmem@sti.com.br");
		Users eraldo = new Users("1","eraldo Costa", "cferaldo@sti.com.br");
		List<Users> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(maria,eraldo));
		return ResponseEntity.ok().body(lista);
	}
	
}
