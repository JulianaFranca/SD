import java.rmi.Remote;
import java.rmi.RemoteException;

/*A interface ICalculadora declara os m�todos que o cliente pode invocar 
a partir de uma m�quina virtual remota*/
public interface ICalculadora extends Remote{

	//Cada declara��o do m�todo deve listar RemoteException em sua cl�usula throws.
	public int soma(int a, int b) throws RemoteException;
	
	public int subtrai(int a, int b) throws RemoteException;
	
	public int multiplica(int a, int b) throws RemoteException;
	
	public int divide(int a, int b) throws RemoteException;
	
	}
