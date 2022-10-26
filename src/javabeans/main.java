package javabeans;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		
		String libreria = null;
		
		libro libro1 = new libro("SPQR","Mary Bear","12",32);
		libro libro2 = new libro("LOS OTROS VUELOS A LA LUNA","Rafael Clemente","23",(double) 19.5);
		libro libro3 = new libro("EL ARTE DE LA FELICIDAD","Dalai Lama","34",(double)12.5);
		libro libro4 = new libro("LA VIDA ES SUEÑO","Pedro Calderon de la Barca","56",32);
		libro libro5 = new libro("VIAJE AL CENTRO DE LA TIERRA","Julio Verne","78",(double) 10.5);
		
		biblioteca l1 = new biblioteca(libreria);
		
		l1.addLibro(libro1);
		l1.addLibro(libro2);
		l1.addLibro(libro3);
		l1.addLibro(libro4);
		l1.addLibro(libro5);
		
		System.out.println(l1.getLibroIsbn("78"));
		
		
		
	
		
		
	}

}
