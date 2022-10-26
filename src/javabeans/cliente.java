package javabeans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cliente {

		public static String servidor_ip = "localhost";
		public static int servidor_puerto = 1337;
		public static int opcion;
		
		public static void main(String[] args) {
			
		System.out.println("<------ APLICACION CLIENTE ------>");
		InetSocketAddress servidor = new InetSocketAddress(servidor_ip, servidor_puerto);
		while (opcion!=3) {
		try {
				Scanner sc = new Scanner(System.in);
				System.out.println("<------ 1 > Consulta isbn ------->");
				System.out.println("<------ 2 > Consulta titulo------>");
				System.out.println("<------ 3 > Salir --------------->");
				System.out.println("<-------------------------------->");
						
				System.out.println("CLIENTE: Seleccione opcion");
				String opcion = sc.nextLine();
				switch (opcion) {
				
				case "1":
					//System.out.println("INTRODUZCA ISBN:");
					//String isbnQuery = sc.nextLine();
					break;
				case "2":
					//System.out.println("INTRODUZCA TITULO:");
					//String tituloQuery = sc.nextLine();
					break;
				case "3":
					break;

				}
				
				Socket socketAlServidor = new Socket();
				System.out.println("<------ ESTABLECIENDO CONEXION ------>");
				socketAlServidor.connect(servidor);			
				System.out.println("<------ CONECTADO ------[" + servidor_ip 
						+ "] PUERTO [" + servidor_puerto + "]");
				
				PrintStream datos_salida = new PrintStream(socketAlServidor.getOutputStream());
				datos_salida.println(opcion);
				
				InputStreamReader datos_entrada = new InputStreamReader(socketAlServidor.getInputStream());
				BufferedReader bf = new BufferedReader(datos_entrada);
				System.out.println("<------ ESPERANDO RESPUESTA ------>");
				String resultado = bf.readLine();
				System.out.println(resultado);
				
		} catch (UnknownHostException e) {
			System.err.println("<------ NO HAY RESPUESTA DE LA DIRECCION ------>" + servidor_ip);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("<------ ERROR I/O ------>");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("<------ ERROR INDETERMINADO ------>" + e);
			e.printStackTrace();
		}
		}
	System.out.println("<------ CERRANDO CONEXION ------>");
}
}
