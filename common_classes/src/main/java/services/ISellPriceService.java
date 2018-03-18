package services;

import entity.Car;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISellPriceService extends Remote {

    double computeSellingPrice(Car car) throws RemoteException;
}
