package projeto.mongo.sboot.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import projeto.mongo.sboot.dto.AuthorDTO;

@Document
public class Comment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String text;
	private Date date;
	private AuthorDTO authorComentario;
	

	public Comment(String id, String text, Date date, AuthorDTO author) {
		super();
		this.id = id;
		this.text = text;
		this.date = date;
		this.authorComentario = author;
	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return authorComentario;
	}

	public void setAuthor(AuthorDTO author) {
		this.authorComentario = author;
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
		Comment other = (Comment) obj;
		return Objects.equals(id, other.id);
	}


	
	
	
}
