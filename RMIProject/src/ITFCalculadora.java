import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITFCalculadora extends Remote{
	int adicao(int x, int y) throws RemoteException;
	int subtracao(int x, int y) throws RemoteException;
	int multiplicacao(int x, int y) throws RemoteException;
	int divisao(int x, int y) throws RemoteException;
}
