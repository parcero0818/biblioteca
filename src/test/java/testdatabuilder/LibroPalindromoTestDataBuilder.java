package testdatabuilder;

import dominio.Libro;

public class LibroPalindromoTestDataBuilder {

	private static final int ANIO = 2010;
	private static final String TITULO = "Cien años de soledad";
	private static final String ISBN = "1221";
	
	private String isbn;
	private String titulo;
	private int anio;

	public LibroPalindromoTestDataBuilder() {
		this.isbn = ISBN;
		this.titulo = TITULO;
		this.anio = ANIO;
	}

	public LibroPalindromoTestDataBuilder conTitulo(String titulo) {
		this.titulo = titulo;
		return this;
	}

	public LibroPalindromoTestDataBuilder conIsbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	public LibroPalindromoTestDataBuilder conAnio(int anio) {
		this.anio = anio;
		return this;
	}

	public Libro build() {
		return new Libro(this.isbn, this.titulo, this.anio);
	}
}
