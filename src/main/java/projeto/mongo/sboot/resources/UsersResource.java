package projeto.mongo.sboot.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.mongo.sboot.domain.Users;
import projeto.mongo.sboot.services.UsersServices;

@RestController
@RequestMapping(value="/users")
public class UsersResource {
	@Autowired

	private UsersServices service;
	
	@GetMapping
	public ResponseEntity<List<Users>> findAll(){
		List<Users> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	
}
