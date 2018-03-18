import remotes.SellPriceServiceRemote;
import remotes.TaxServiceRemote;
import services.ISellPriceService;
import services.ITaxService;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) throws RemoteException {

        TaxServiceRemote obj=new TaxServiceRemote();
        SellPriceServiceRemote obj2=new SellPriceServiceRemote();
        ITaxService stub=(ITaxService) UnicastRemoteObject.exportObject(obj,4447);
        ISellPriceService stub2=(ISellPriceService)UnicastRemoteObject.exportObject(obj2,4447);
        Registry registry= null;
        try {
            registry = LocateRegistry.createRegistry(4447);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            try {
                registry.bind("tax", stub);
                registry.bind("sell", stub2);

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
        System.out.println("The server started.");
    }
}
