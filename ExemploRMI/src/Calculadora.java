import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Calculadora implements ICalculadora {

	private static final long serialVersionUID = 1L;

	private static int chamadas = 0;

	public int soma(int a, int b) throws RemoteException {
		System.out.println("M�todo soma chamado " + chamadas++);
		return a + b;
	}

	// implementando o m�todo da subtra��o
	public int subtrai(int a, int b) throws RemoteException {
		System.out.println("M�todo subtrai chamado " + chamadas++);
		return a - b;
	}

	// implementando o m�todo da multiplica��o
	public int multiplica(int a, int b) throws RemoteException {
		System.out.println("M�todo multiplica chamado " + chamadas++);
		return a * b;
	}

	// implementando o m�todo da divis�o
	public int divide(int a, int b) throws RemoteException {
		System.out.println("M�todo divide chamado " + chamadas++);
		return a / b;
	}

	public static void main(String[] args) throws AccessException, RemoteException, AlreadyBoundException {
		Calculadora calculadora = new Calculadora();
		Registry reg = null;
		ICalculadora stub = (ICalculadora) UnicastRemoteObject.exportObject(calculadora, 1100);
		try {
			System.out.println("Creating registry...");
			
			// Criando o registro.
			reg = LocateRegistry.createRegistry(1099);//retorna um objeto que representa
                                                      //a vincula��o remota 
		} catch (Exception e) {
			try {
				reg = LocateRegistry.getRegistry(1099);
			} catch (Exception e1) {
				System.exit(0);
			}
		}
		// M�todo usado pelo servidor para registrar o identificador do objeto remoto
		reg.rebind("calculadora", stub);
	}
}
