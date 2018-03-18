package remotes;


import entity.Car;
import services.ISellPriceService;

public class SellPriceServiceRemote implements ISellPriceService {

    public double computeSellingPrice(Car car) {

        return (car.getPricePurchasing()-(car.getPricePurchasing()/7.0))*(2015-car.getYear());
    }
}
