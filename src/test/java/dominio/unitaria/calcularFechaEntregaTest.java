package dominio.unitaria;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import dominio.Bibliotecario;
import dominio.Libro;
import dominio.repositorio.RepositorioLibro;
import dominio.repositorio.RepositorioPrestamo;
import testdatabuilder.LibroCalcularFecEntregaTestDataBuilder;

public class calcularFechaEntregaTest {

	@Test
	public void esPalindromoTest() {
		// arrange
		LibroCalcularFecEntregaTestDataBuilder libIsbnMayor30DataBuilder = new LibroCalcularFecEntregaTestDataBuilder();
		
		Libro libro = libIsbnMayor30DataBuilder.build(); 
		
		RepositorioPrestamo repositorioPrestamo = mock(RepositorioPrestamo.class);
		RepositorioLibro repositorioLibro = mock(RepositorioLibro.class);
		
		Bibliotecario bibliotecario = new Bibliotecario(repositorioLibro, repositorioPrestamo);
		// act 
		boolean calcularFecha =  bibliotecario.calcularFecha(libro.getIsbn());
		
		//assert
		assertTrue(calcularFecha);
	}
	
}
