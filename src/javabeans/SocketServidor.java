package javabeans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SocketServidor {

	public static int servidor_puerto = 1337;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("<------ APLICACION SERVIDOR ------>");
		System.out.println("----------------------------------");
		System.out.println("<------ CARGANDO LIBROS ------>");
		System.out.println("----------------------------------");
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

		InputStreamReader datos_entrada = null;
		PrintStream datos_salida = null;
		Socket socketAlCliente = null;
		InetSocketAddress direccion = new InetSocketAddress(servidor_puerto);
		System.out.println(libro1.getAutor());
		try (ServerSocket serverSocket = new ServerSocket()){			
			
			serverSocket.bind(direccion);
			
			while(true){		
				
				System.out.println("<------ ESCUCHANDO PUERTO ------>" + servidor_puerto);
				

				socketAlCliente = serverSocket.accept();
				System.out.println("<------ PETICION RECIBIDA ------>");
				
				datos_entrada = new InputStreamReader(socketAlCliente.getInputStream());
				BufferedReader bf = new BufferedReader(datos_entrada);
								
				
				String opcionRecibida = bf.readLine();
				System.out.println("<------ DATOS RECIBIDOS ------>" + opcionRecibida);
				System.out.println("<------"+ opcionRecibida + "------>");
							
				
				datos_salida = new PrintStream(socketAlCliente.getOutputStream());
				
				if (opcionRecibida == "1") {
					datos_salida.println(libro1.getTitulo());
				}
				if (opcionRecibida == "2") {
					datos_salida.println(libro2.getTitulo());
				}
				socketAlCliente.close();
		}		
				
		} catch (IOException e) {
			System.err.println("<------ ERROR I/O ------>");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("<------ ERROR INDETERMINADO ------>" + e);
			e.printStackTrace();
		}
	}
}

		