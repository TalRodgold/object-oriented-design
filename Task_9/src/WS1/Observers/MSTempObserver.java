package WS1.Observers;

public class MSTempObserver implements Observer{
    MonitoringScreen monitoringScreen;
    MSTempObserver(MonitoringScreen m){
        monitoringScreen = m;
        System.out.println("MSTempObserver was created");
    }


    @Override
    public void update(Object d){
        monitoringScreen.displayTemp((int)d);
    }
}
