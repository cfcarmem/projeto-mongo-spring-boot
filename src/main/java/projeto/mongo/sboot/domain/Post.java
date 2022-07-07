package projeto.mongo.sboot.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import projeto.mongo.sboot.dto.AuthorDTO;
import projeto.mongo.sboot.dto.CommentDTO;
import projeto.mongo.sboot.dto.UsersDTO;

@Document
public class Post implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private Date date;
	private String title;
	private String body;
	private List<AuthorDTO> author = new ArrayList<>();
    private List<CommentDTO> comment = new ArrayList<>();
	
	public Post() {}
	
	
	public Post(String id, Date date, String title, String body) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
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
	public void setDate(Date date2) {
		this.date = date2;
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
	

	public List<AuthorDTO> getAuthor() {
		return author;
	}


	public void setAuthor(List<AuthorDTO> author2) {
		this.author = author2;
	}
	
	public List<CommentDTO> getComment() {
		return comment;
	}


	public void setComment(List<CommentDTO> comment) {
		this.comment = comment;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}






	
	

}
