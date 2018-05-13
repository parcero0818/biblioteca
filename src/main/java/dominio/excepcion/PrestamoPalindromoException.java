package dominio.excepcion;

public class PrestamoPalindromoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PrestamoPalindromoException(String message) {
		super(message);
	}
}
