package javabeans;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		
		Libro libro1 = new Libro("SPQR","Mary Bear","9788417067489",32);
		Libro libro2 = new Libro("LOS OTROS VUELOS A LA LUNA","Rafael Clemente","9788448028312",(float) 19.5);
		Libro libro3 = new Libro("EL ARTE DE LA FELICIDAD","Dalai Lama","9788497595957",(float)12.5);
		Libro libro4 = new Libro("LA VIDA ES SUEÑO","Pedro Calderon de la Barca","9788470397004",32);
		Libro libro5 = new Libro("VIAJE AL CENTRO DE LA TIERRA","Julio Verne","9788547858654",(float) 10.5);
		
		List<Libro> listaLibros = new ArrayList<>();
		listaLibros.add(libro1);
		listaLibros.add(libro2);
		listaLibros.add(libro3);
		listaLibros.add(libro4);
		listaLibros.add(libro5);
		
		
	
		
		
	}

}
