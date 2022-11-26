
import java.rmi.Naming;


public class RmiClient {

	public static void main(String[] args) throws Exception {
		String objNome = "rmi://10.105.2.48:1099/calc";
		ICalculadora calc = (ICalculadora) Naming.lookup(objNome);
		System.out.println("\n---------------------------------------");
		System.out.println("A soma de 2 + 2 = " + calc.adicao(2, 2));
	}

}
