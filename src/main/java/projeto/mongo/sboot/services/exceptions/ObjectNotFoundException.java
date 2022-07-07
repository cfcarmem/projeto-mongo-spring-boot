package projeto.mongo.sboot.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
 
	private static final long serialVersionUID = 1L;

	//passar o id do Objeto que não foi encontrado
	public ObjectNotFoundException(String msg) {
		super(msg);
		
	}
}
