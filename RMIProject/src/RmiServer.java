import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RmiServer {

	public static void main(String[] args) {
		try {
			ICalculadora calc = new Calculadora();
			String objNome = "rmi://localhost/calc";
			System.out.println("Registrando o objeto no RMIRegistry...");
			LocateRegistry.createRegistry(1099);
			Naming.rebind(objNome, calc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
