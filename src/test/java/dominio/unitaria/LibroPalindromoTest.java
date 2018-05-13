package dominio.unitaria;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import dominio.Bibliotecario;
import dominio.Libro;
import dominio.repositorio.RepositorioLibro;
import dominio.repositorio.RepositorioPrestamo;
import testdatabuilder.LibroPalindromoTestDataBuilder;

public class LibroPalindromoTest {

	@Test
	public void esPalindromoTest() {
		// arrange
		LibroPalindromoTestDataBuilder libroPalindromoDataBuilder = new LibroPalindromoTestDataBuilder();
		
		Libro libro = libroPalindromoDataBuilder.build(); 
		
		RepositorioPrestamo repositorioPrestamo = mock(RepositorioPrestamo.class);
		RepositorioLibro repositorioLibro = mock(RepositorioLibro.class);
		
		when(repositorioPrestamo.obtenerLibroPrestadoPorIsbn(libro.getIsbn())).thenReturn(libro);
		
		Bibliotecario bibliotecario = new Bibliotecario(repositorioLibro, repositorioPrestamo);
		
		// act 
		boolean esPalindromo =  bibliotecario.isbnPalindromo(libro.getIsbn());
		
		//assert
		assertTrue(esPalindromo);
	}
	
}
