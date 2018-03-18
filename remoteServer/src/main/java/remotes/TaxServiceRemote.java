package remotes;

import entity.Car;
import services.ITaxService;

public class TaxServiceRemote implements ITaxService {

    public double computeTax(Car car) {

        double sum=0.0;
        double engineCapacity=car.getEngineCapacity();

        if(engineCapacity<1600)
            sum = 8;
        if(engineCapacity >=1601 && engineCapacity<=2000)
            sum=18;
        if(engineCapacity >=2001 && engineCapacity<=2600)
            sum=72;
        if(engineCapacity >=2601 && engineCapacity<=3000)
            sum=144;
        if(engineCapacity>3001)
            sum=290;

        return (engineCapacity/200.0)*sum;
    }
}
