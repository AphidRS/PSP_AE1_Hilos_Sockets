package javabeans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {

	public static int servidor_puerto = 1337;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("<------ APLICACION SERVIDOR ------>");
		System.out.println("----------------------------------");

		InputStreamReader datos_entrada = null;
		PrintStream datos_salida = null;
		Socket socketAlCliente = null;
		InetSocketAddress direccion = new InetSocketAddress(servidor_puerto);
		
		try (ServerSocket serverSocket = new ServerSocket()){			
			
			serverSocket.bind(direccion);
			
			while(true){		
				
				System.out.println("<------ ESCUCHANDO PUERTO ------>" + servidor_puerto);
				

				socketAlCliente = serverSocket.accept();
				System.out.println("<------ PETICION RECIBIDA ------>");
				
				datos_entrada = new InputStreamReader(socketAlCliente.getInputStream());
				BufferedReader bf = new BufferedReader(datos_entrada);
								
				
				String stringRecibido = bf.readLine();
				System.out.println("<------ DATOS RECIBIDOS ------>" + datos_entrada);
								
				
				//datos_salida = new PrintStream(socketAlCliente.getOutputStream());
				//datos_salida.println(resultado);
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

		