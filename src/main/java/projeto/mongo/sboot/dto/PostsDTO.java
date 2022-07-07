package projeto.mongo.sboot.dto;

import java.io.Serializable;
import java.util.Date;

import projeto.mongo.sboot.domain.Post;

public class PostsDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Date date;
	private String title;
	private String body;
	
	public  PostsDTO() {
	}

	public PostsDTO(Post post) {
		super();
		this.id = post.getId();
		this.date = post.getDate();
		this.title = post.getTitle();
		this.body = post.getBody();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	

}
