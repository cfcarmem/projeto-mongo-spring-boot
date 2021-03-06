package projeto.mongo.sboot.dto;

import java.io.Serializable;

import projeto.mongo.sboot.domain.Users;


public class UsersDTO implements Serializable {
	/**
	 * usa padrão DTO para definir quais campos vamos trabalhar.
	 * se tiver uma tabela de 40 campos e só precisamos de 3, criamos um DTO.
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String email;
	
	public UsersDTO() {
		
	}
	
	public UsersDTO(Users users) {
		id = users.getId();
		email = users.getEmail();
		name = users.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
