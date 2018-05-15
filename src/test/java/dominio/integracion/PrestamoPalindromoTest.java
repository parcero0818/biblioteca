package dominio.integracion;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Bibliotecario;
import dominio.Libro;
import dominio.excepcion.PrestamoException;
import dominio.excepcion.PrestamoPalindromoException;
import dominio.repositorio.RepositorioLibro;
import dominio.repositorio.RepositorioPrestamo;
import persistencia.sistema.SistemaDePersistencia;
import testdatabuilder.LibroPalindromoTestDataBuilder;
import testdatabuilder.LibroTestDataBuilder;

public class PrestamoPalindromoTest {

	private static final String CRONICA_DE_UNA_MUERTA_ANUNCIADA = "Cronica de una muerta anunciada";

	private SistemaDePersistencia sistemaPersistencia;

	private RepositorioLibro repositorioLibros;
	private RepositorioPrestamo repositorioPrestamo;

	@Before
	public void setUp() {

		sistemaPersistencia = new SistemaDePersistencia();

		repositorioLibros = sistemaPersistencia.obtenerRepositorioLibros();
		repositorioPrestamo = sistemaPersistencia.obtenerRepositorioPrestamos();

		sistemaPersistencia.iniciar();
	}

	@After
	public void tearDown() {
		sistemaPersistencia.terminar();
	}

	@Test
	public void prestarLibroPalindromoTest() {

		// arrange
		String nombreUsuario = "Usuario1";
		Libro libro = new LibroPalindromoTestDataBuilder().conTitulo(CRONICA_DE_UNA_MUERTA_ANUNCIADA).build();

		repositorioLibros.agregar(libro);

		Bibliotecario blibliotecario = new Bibliotecario(repositorioLibros, repositorioPrestamo);

		try {
			// act
			blibliotecario.prestar(libro, nombreUsuario);

			blibliotecario.prestar(libro, nombreUsuario);
			fail();
		
		} catch (PrestamoPalindromoException e) {
			Assert.assertEquals(Bibliotecario.LIBRO_SOLO_PARA_USO_EN_BIBLIOTECA, e.getMessage());
		}
	}
}
