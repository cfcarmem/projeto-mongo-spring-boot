package projeto.mongo.sboot.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.mongo.sboot.domain.Users;
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
	
	
}
