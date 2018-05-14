package testdatabuilder;

import dominio.Libro;

public class LibroConFecEntregaTestDataBuilder {

	private static final int ANIO = 2010;
	private static final String TITULO = "Cien años de soledad";
	private static final String ISBN = "A874B69Q";
	
	private String isbn;
	private String titulo;
	private int anio;

	public LibroConFecEntregaTestDataBuilder() {
		this.isbn = ISBN;
		this.titulo = TITULO;
		this.anio = ANIO;
	}

	public LibroConFecEntregaTestDataBuilder conTitulo(String titulo) {
		this.titulo = titulo;
		return this;
	}

	public LibroConFecEntregaTestDataBuilder conIsbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	public LibroConFecEntregaTestDataBuilder conAnio(int anio) {
		this.anio = anio;
		return this;
	}

	public Libro build() {
		return new Libro(this.isbn, this.titulo, this.anio);
	}
}
