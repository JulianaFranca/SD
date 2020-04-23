import java.rmi.Remote;
import java.rmi.RemoteException;

/*A interface ICalculadora declara os métodos que o cliente pode invocar 
a partir de uma máquina virtual remota*/
public interface ICalculadora extends Remote{

	//Cada declaração do método deve listar RemoteException em sua cláusula throws.
	public int soma(int a, int b) throws RemoteException;
	
	public int subtrai(int a, int b) throws RemoteException;
	
	public int multiplica(int a, int b) throws RemoteException;
	
	public int divide(int a, int b) throws RemoteException;
	
	}
