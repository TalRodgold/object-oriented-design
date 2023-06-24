package WS1.Observers;

public class LogPressObserver implements Observer {
    Log log;
    public LogPressObserver(Log l){
        log = l;
        System.out.println("LogPressObserver was created");
    }

    @Override
    public void update(Object d) {
        log.displayPressure((int)d);
    }
}
