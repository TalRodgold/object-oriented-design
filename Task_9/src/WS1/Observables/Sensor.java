package WS1.Observables;

public abstract class Sensor extends Observable{
    private int interval;
    private int lastReading;
    private String type;

    public Sensor(String s, int i){
        type = s;
        interval = i;
        SensorAlarmListener sensor = new SensorAlarmListener(this);
        AlarmClock.theInstance().register(interval, sensor);
        System.out.println(type.toLowerCase() +" registered to clock");
    }

    void check(){
        int read = read();
        if(lastReading != read){
            lastReading = read;
            notifyObservers(lastReading);
        }
    }
    public abstract int read();


}
