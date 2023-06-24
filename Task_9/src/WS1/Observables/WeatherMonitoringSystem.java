package WS1.Observables;

import WS1.Nimbus1.*;
import WS1.Observers.*;
public class WeatherMonitoringSystem {
    private Sensor pressureSensor;
    private Sensor tempSensor;
    private PressureTrendSensor pressureTrendSensor;
    private static WeatherMonitoringSystem instance = null;

    private WeatherMonitoringSystem() {
        Nimbus1Clock.theInstance();
        pressureSensor = new Nimbus1PressureSensor("Pressure", 1100);
        tempSensor = new Nimbus1TemperatureSensor("Temperature", 700);
        pressureTrendSensor = new PressureTrendSensor(pressureSensor);
        System.out.println("WeatherMonitoringSystem was created");
    }
    public void addTemperatureObserver(Observer TemperatureObserver) {
        tempSensor.addObserver(TemperatureObserver);
    }
    public void addPressureObserver(Observer PressureObserver) {
        pressureSensor.addObserver(PressureObserver);
    }

    public void addPressureTrendObserver(Observer PressureTrendObserver) {
        pressureTrendSensor.addObserver(PressureTrendObserver);
    }

    public static WeatherMonitoringSystem theInstance() {
        if (instance == null){
            instance = new WeatherMonitoringSystem();
        }
        return instance;
    }
}
