package WS1.Observers;

public class MSPressObserver implements Observer{
    MonitoringScreen monitoringScreen;
    MSPressObserver(MonitoringScreen m){
        monitoringScreen = m;
        System.out.println("MSPressObserver was created");
    }
    @Override
    public void update(Object d){
        monitoringScreen.displayPressure((int)d);
    }
}
