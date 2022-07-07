package projeto.mongo.sboot.dto;

import java.io.Serializable;


import projeto.mongo.sboot.domain.Users;

public class AuthorDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDTO() {
		
	}
	public AuthorDTO(Users use) {
		super();
		this.id = use.getId();
		this.name = use.getName();
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
	
	
	
	

}
