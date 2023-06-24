package WS1.Observers;
import WS1.System.Trend;

public class LogPressTrendObserver implements Observer{
    Log log;

    public LogPressTrendObserver(Log l) {
        log = l;
        System.out.println("LogPressTrendObserver was created");
    }

    @Override
    public void update(Object d){
        log.displayPressureTrend((Trend)d);
    }
}
