package WS1.Observers;

import WS1.Observables.WeatherMonitoringSystem;
import WS1.System.Trend;

public class Log {
    public Log(WeatherMonitoringSystem ws) {
        ws.addPressureTrendObserver(new LogPressTrendObserver(this));
        ws.addPressureObserver(new LogPressObserver(this));
        System.out.println("Log was created\nLogPressObserver observes pressure\nLogPressTrendObserver observes pressure trend");
    }
    public void displayPressure(int d){
        System.out.println("Log: pressure = " + d + " millibars");
    }
    public void displayPressureTrend(Trend t) {
        System.out.println("Log: pressure trend = " + t);
    }

}
