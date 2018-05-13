package dominio;

import java.util.Date;

import dominio.excepcion.PrestamoException;
import dominio.excepcion.PrestamoPalindromoException;
import dominio.repositorio.RepositorioLibro;
import dominio.repositorio.RepositorioPrestamo;

public class Bibliotecario {

	public static final String EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE = "El libro no se encuentra disponible";
	public static final String LIBRO_SOLO_PARA_USO_EN_BIBLIOTECA = "Los libros palíndromos solo se pueden utilizar en la biblioteca";

	private RepositorioLibro repositorioLibro;
	private RepositorioPrestamo repositorioPrestamo;

	public Bibliotecario(RepositorioLibro repositorioLibro, RepositorioPrestamo repositorioPrestamo) {
		this.repositorioLibro = repositorioLibro;
		this.repositorioPrestamo = repositorioPrestamo;

	}

	public void prestar(Libro libro, String nombreUsuario) {
		if(esPrestado(libro.getIsbn())) {
			throw new PrestamoException("El libro no se encuentra disponible");
		}else if(isbnPalindromo(libro.getIsbn())){
			throw new PrestamoPalindromoException("Los libros palíndromos solo se pueden utilizar en la biblioteca");
		}else{
			Prestamo prestamo = new Prestamo(new Date(), libro, null, nombreUsuario);
			repositorioPrestamo.agregar(prestamo);
		}
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
