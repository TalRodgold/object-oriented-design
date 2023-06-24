package WS1.Observers;

import WS1.Observables.WeatherMonitoringSystem;

public class MonitoringScreen {
    public MonitoringScreen(WeatherMonitoringSystem ws) {
        ws.addPressureObserver(new MSPressObserver(this));
        ws.addTemperatureObserver(new MSTempObserver(this));
        System.out.println("MonitoringScreen was created\nMSTempObserver observes temperature\nMSPressObserver observes pressure");
    }

    void displayPressure(int d){
        System.out.println("MonitoringScreen: pressure = " + d + " millibars");
    }

    void displayTemp(int d){
        System.out.println("MonitoringScreen: temperature = " + d + " Celsius");
    }
}
