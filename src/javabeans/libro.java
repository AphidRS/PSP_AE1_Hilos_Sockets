package javabeans;

public class libro {
	private String ISBN;
	private String titulo;
	private String autor;
	private double precio;
	
	public libro(String titulo, String autor, String isbn, double precio) {
	
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = isbn;
		this.precio = precio;
		
	}
		
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "libro [ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + "]";
	}
	
}
