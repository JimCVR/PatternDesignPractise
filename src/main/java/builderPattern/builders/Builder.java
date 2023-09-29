package builderPattern.builders;

import builderPattern.cars.CarType;
import builderPattern.components.Engine;
import builderPattern.components.GPSNavigator;
import builderPattern.components.Transmission;
import builderPattern.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);

}
