import com.sun.jndi.rmi.registry.RemoteReference;
import entity.Car;
import remotes.SellPriceServiceRemote;
import remotes.TaxServiceRemote;
import services.ISellPriceService;
import services.ITaxService;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main{

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        TaxServiceRemote obj=new TaxServiceRemote();
        SellPriceServiceRemote obj2=new SellPriceServiceRemote();
        ITaxService stub=(ITaxService)UnicastRemoteObject.exportObject(obj,4447);
        ISellPriceService stub2=(ISellPriceService)UnicastRemoteObject.exportObject(obj2,4447);
        Registry registry=LocateRegistry.createRegistry(4447);

        registry.bind("tax", stub);
        registry.bind("sell", stub2);

        System.err.println("Server ready");

        try {

            registry = LocateRegistry.getRegistry(4447);

            ITaxService stub3 = (ITaxService) registry.lookup("tax");
            ISellPriceService stub4=(ISellPriceService) registry.lookup("sell");

            double tax=stub3.computeTax(new Car(2002,1650,300.8));

            System.out.println(tax);

            double price=stub4.computeSellingPrice(new Car(2002,1650,300.8));

            System.out.println(price);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }
}
