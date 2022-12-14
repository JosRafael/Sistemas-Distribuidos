import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		System.out.println("+------------------------+");
		System.out.println("Servidor TCP foi iniciado!");
		System.out.println("+------------------------+");
		
		int port = 4500;
		
		ServerSocket socketServidor = new ServerSocket(port);
		Socket socketClient = socketServidor.accept();
		
		PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
		FileWriter dados = new FileWriter("registro.txt");
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		
		String entrada[] = new String[1000];
		
		for(int i = 0; i <= entrada.length; i++) {
			if((entrada[i] = in.readLine()) != null) {
				System.out.println("Dados do cliente: " + entrada[i].toString());
				out.println(entrada[i]);
				dados.write("Dados do cliente: " + entrada[i] + " Data de entrada:" + LocalDateTime.now().format(formatoData) +"\n");
			}
			
			if(entrada[i].equalsIgnoreCase("sair")) {
				break;
			}
		}
		
		dados.close();
		out.close();
		in.close();
		socketClient.close();
		socketServidor.close();
		
		System.out.println("\n_________________________");
		System.out.println("\nO cliente solicitou a saida...");
		System.out.println("\n_________________________");
		System.out.println("\nEncerrando a conexão...");
	}
}
