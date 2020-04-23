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
		System.out.println("Método soma chamado " + chamadas++);
		return a + b;
	}

	// implementando o método da subtração
	public int subtrai(int a, int b) throws RemoteException {
		System.out.println("Método subtrai chamado " + chamadas++);
		return a - b;
	}

	// implementando o método da multiplicação
	public int multiplica(int a, int b) throws RemoteException {
		System.out.println("Método multiplica chamado " + chamadas++);
		return a * b;
	}

	// implementando o método da divisão
	public int divide(int a, int b) throws RemoteException {
		System.out.println("Método divide chamado " + chamadas++);
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
                                                      //a vinculação remota 
		} catch (Exception e) {
			try {
				reg = LocateRegistry.getRegistry(1099);
			} catch (Exception e1) {
				System.exit(0);
			}
		}
		// Método usado pelo servidor para registrar o identificador do objeto remoto
		reg.rebind("calculadora", stub);
	}
}
