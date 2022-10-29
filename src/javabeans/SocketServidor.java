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
	public static String libreria = null;
	public static String[] datosbulk = null;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("[APLICACION SERVIDOR]");
		System.out.println("[CARGANDO LIBROS]");
		libro libro1 = new libro("SPQR","MARY BEAR","12",32);
		libro libro2 = new libro("LOS OTROS VUELOS A LA LUNA","RAFAEL CLEMENTE","23",19.5);
		libro libro3 = new libro("EL ARTE DE LA FELICIDAD","DALAI LAMA","34",12.5);
		libro libro4 = new libro("20000 LEGUAS DE VIAJE SUBMARINO","JULIO VERNE","56",32);
		libro libro5 = new libro("VIAJE AL CENTRO DE LA TIERRA","JULIO VERNE","78",10.5);
		biblioteca l1 = new biblioteca(libreria);
		l1.addLibro(libro1);
		l1.addLibro(libro2);
		l1.addLibro(libro3);
		l1.addLibro(libro4);
		l1.addLibro(libro5);

		InputStreamReader datos_entrada = null;
		PrintStream datos_salida = null;
		Socket socketAlCliente = null;
		InetSocketAddress direccion = new InetSocketAddress(servidor_puerto);
		try (ServerSocket serverSocket = new ServerSocket()){			
			
			serverSocket.bind(direccion);
		
			while(true){		
				
				System.out.println("[ESCUCHANDO PUERTO]" + servidor_puerto);
				socketAlCliente = serverSocket.accept();
				System.out.println("[PETICION RECIBIDA]");
				datos_entrada = new InputStreamReader(socketAlCliente.getInputStream());
				BufferedReader bf = new BufferedReader(datos_entrada);			
				String datos_recibidos = bf.readLine();
				if (datos_recibidos == null || datos_recibidos.length() == 0) {
					System.out.println("Buffer vacio");
					continue;
				} 
				datosbulk = datos_recibidos.split(";");
				System.out.println(datos_recibidos);
				System.out.println("[DATOS RECIBIDOS]");
				System.out.println("[==============================]");
				System.out.println("[ OPCION : " + datosbulk[0] + "]");
				System.out.println("[ DATOS  : " + datosbulk[1] + "]");
				System.out.println("[==============================]");
				datos_salida = new PrintStream(socketAlCliente.getOutputStream());
				
				switch (datosbulk[0]) {
				
				case "1":
					datos_salida.print(l1.getLibroIsbn(datosbulk[1]).toString());
					break;
				case "2":
					datos_salida.print(l1.getLibroTitulo(datosbulk[1]).toString());
					break;
				case "3":
					datos_salida.print(l1.getLibrosAutor(datosbulk[1]));
					break;

				}
				socketAlCliente.close();
		}		
				
		} catch (IOException e) {
			System.err.println("[ERROR I/O]");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("[ERROR INDETERMINADO]" + e);
			e.printStackTrace();
		}
	}
}

		