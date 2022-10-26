package javabeans;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

	private Libro Libro;
	private int posicion;
	private List<javabeans.Libro> listaLibros;
	
	
	public Biblioteca(Libro Libro, int posicion) {
		this.Libro = Libro;
		this.posicion = posicion;
	}
	
	public Biblioteca() {
		super();
	}

	public Libro getLibro() {
		return Libro;
	}

	public void setLibro(Libro libro) {
		Libro = libro;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public List<Libro> getListaLibros() {
		return getListaLibros();
	}

	public void setListaLibros(List<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	
	
}
