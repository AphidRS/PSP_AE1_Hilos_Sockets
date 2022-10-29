package javabeans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class cliente {

	public static String servidor_ip = "localhost";
	public static int servidor_puerto = 1337;
	public static ArrayList<String> datos = new ArrayList();

	public static void main(String[] args) {
		
		String opcion = "-1";
		System.out.println("[APLICACION CLIENTE]");
		InetSocketAddress servidor = new InetSocketAddress(servidor_ip, servidor_puerto);

		do {
			try (Socket socketAlServidor = new Socket()) {
				datos.removeAll(datos);
				System.out.println("[ESTABLECIENDO CONEXION]");
				socketAlServidor.connect(servidor);
				System.out.println("[CONECTADO][" + servidor_ip + "][PUERTO][" + servidor_puerto + "]");
				PrintStream datos_salida = new PrintStream(socketAlServidor.getOutputStream());
				Scanner sc = new Scanner(System.in);
				System.out.println(" 1 > Consulta isbn ");
				System.out.println(" 2 > Consulta titulo");
				System.out.println(" 3 > Consulta libros por autor ");
				System.out.println(" 4 > Salir ");
				System.out.println("--------------------------------");
				System.out.println("Seleccione opcion ");
				opcion = sc.nextLine();
				datos.add(opcion);
				switch (opcion) {

				case "1":
					System.out.println("INTRODUZCA ISBN: ");
					datos.add(sc.nextLine());
					break;
				case "2":
					System.out.println("INTRODUZCA TITULO: ");
					datos.add(sc.nextLine());
					break;
				case "3":
					System.out.println("CONSULTA LIBROS POR AUTOR: ");
					datos.add(sc.nextLine());
					break;
				}
				if (opcion.compareTo("4") != 0) {
					String a = String.join(";",datos); 
					datos_salida.println(a);
					System.out.println("[ESPERANDO RESPUESTA]");
					InputStreamReader datos_entrada = new InputStreamReader(socketAlServidor.getInputStream());
					BufferedReader bf = new BufferedReader(datos_entrada);
					System.out.println("[RECIBIENDO RESPUESTA]");
					String resultado = bf.readLine();

					System.out.println("[RESULTADO]");
					System.out.println(resultado);

					
				}

			} catch (UnknownHostException e) {
				System.err.println("[NO HAY RESPUESTA DE LA DIRECCION]" + servidor_ip);
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("[ERROR I/O]");
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println("[ERROR INDETERMINADO]" + e);
				e.printStackTrace();
			}
		} while (opcion.compareTo("3") != 0);
		System.out.println("[CERRANDO CONEXION]");
	}

}
