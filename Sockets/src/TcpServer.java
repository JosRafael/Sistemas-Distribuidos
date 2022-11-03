import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) {
		System.out.println("-----------------------");
		System.out.println(":: SERVIDOR INICIADO ::");
		System.out.println("-----------------------");
			
		int port = 4500;
		
		
		try {
			
			ServerSocket socketServer = new ServerSocket(port);
			System.out.println("Ouvindo a porta "+port+"...");
			
			Socket socketClient = socketServer.accept();			
						
			PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
			
			String entrada;
			
			while ((entrada=in.readLine()) != null) {
				System.out.println("Mensagem do cliente:  "+entrada);	
				
				out.println(entrada.toUpperCase());
				
				if(entrada.equalsIgnoreCase("sair")) 
					break;
				
			}
			out.close();
			in.close();
			socketClient.close();
			socketServer.close();
			
			System.out.println("\n-----------------------");
			System.out.println(":: Cliente digou SAIR...");
			
			
		} catch (IOException e) {
			System.out.println("ERRO: "+e.getMessage());
			e.printStackTrace();
		}
		
	}
}