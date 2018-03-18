package services;

import entity.Car;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITaxService extends Remote{

    double computeTax(Car car) throws RemoteException;
}
