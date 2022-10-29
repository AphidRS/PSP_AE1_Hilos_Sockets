package javabeans;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import java.util.ArrayList; 

public class biblioteca {

	private libro libro;
	private String nombrelista;
	private ArrayList<libro> listalibros;
	private ArrayList<String> librosporautor;

	public biblioteca(String nombre) {

		nombrelista = nombre;
		listalibros = new ArrayList<>();

	}

	public void addLibro(libro libro) {

		listalibros.add(libro);

	}

	public libro getLibro() {
		return libro;
	}

	public void setLibro(libro libro) {
		this.libro = libro;
	}

	public String getNombrelista() {
		return nombrelista;
	}

	public void setNombrelista(String nombrelista) {
		this.nombrelista = nombrelista;
	}

	public ArrayList<libro> getListalibros() {
		return listalibros;
	}

	public void setListalibros(ArrayList<libro> listalibros) {
		this.listalibros = listalibros;
	}

	public libro getLibroIsbn(String isbn) {

		for (libro libro : listalibros) {
			if (libro.getISBN().contains(isbn)) {
				return libro;
			}
			
		}
		return null;
	}

	public libro getLibroTitulo(String titulo) {

		for (libro libro : listalibros) {
			if (libro.getTitulo().contains(titulo)) {
				return libro;
			}
		}

		return null;
	}
	
	public ArrayList<String> getLibrosAutor(String autor) {
		
		librosporautor = new ArrayList<>();
		for (libro libro : listalibros) {
			if (libro.getAutor().contains(autor)) {
				librosporautor.add(libro.toString());
			}
		}
		return librosporautor;
	}

}