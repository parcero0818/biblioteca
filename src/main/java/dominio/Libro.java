package dominio;

public class Libro {

	private String isbn;
	private String titulo;
	private int anio;
	
	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public Libro(String isbn, String titulo, int anio) {

		this.isbn = isbn;
		this.titulo = titulo;
		this.anio = anio;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getAnio() {
		return anio;
	}

	public String getIsbn() {
		return isbn;
	}
	
	/***
	 * Metodo recursivo que permite identificar si un isbn de un libro es palindrono
	 * 
	 * @author Edward
	 * @param isbn
	 * @return
	 */
	public boolean isbnPalindromo(String isbn) {
		if (isbn == null) {
			return false;
		} else if (isbn.isEmpty() || isbn.length() == 1) {
			return true;
		}
		int len = isbn.length() - 1;
		return isbn.charAt(0) == isbn.charAt(len) && isbnPalindromo(isbn.substring(1, len));
	}

}
