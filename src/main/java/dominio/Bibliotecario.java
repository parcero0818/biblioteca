package dominio;

import dominio.excepcion.PrestamoException;
import dominio.repositorio.RepositorioLibro;
import dominio.repositorio.RepositorioPrestamo;

public class Bibliotecario {

	public static final String EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE = "El libro no se encuentra disponible";

	private RepositorioLibro repositorioLibro;
	private RepositorioPrestamo repositorioPrestamo;

	public Bibliotecario(RepositorioLibro repositorioLibro, RepositorioPrestamo repositorioPrestamo) {
		this.repositorioLibro = repositorioLibro;
		this.repositorioPrestamo = repositorioPrestamo;

	}

	public String prestar(String isbn) {
		if(esPrestado(isbn)) {
			throw new PrestamoException("El libro no se encuentra disponible");
		}else if(isbnPalindromo(isbn)){
			return "Los libros palindromos solo se pueden utilizar en la biblioteca";
		}else{
			Libro libro = new Libro(isbn, "", 0);
			Prestamo prestamo = new Prestamo(null, libro, null, "usuario1");
			repositorioPrestamo.agregar(prestamo);
		}
		esPrestado(isbn);

		return "true";
	}

	public boolean esPrestado(String isbn) {
		Libro libro = repositorioPrestamo.obtenerLibroPrestadoPorIsbn(isbn);
		if(null != libro) {
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que permite identificar si un isbn de un libro es palindrono
	 * @param isbn
	 * @return
	 */
	private boolean isbnPalindromo(String isbn) {
		if (isbn == null) {
			return false;
		} else if (isbn.isEmpty() || isbn.length() == 1) {
			return true;
		}
		int len = isbn.length() - 1;
		return isbn.charAt(0) == isbn.charAt(len) && isbnPalindromo(isbn.substring(1, len));
	}

}
