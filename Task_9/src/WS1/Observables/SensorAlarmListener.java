package WS1.Observables;

public class SensorAlarmListener implements AlarmListener {
    private Sensor sensor;
    public SensorAlarmListener(Sensor s){
        sensor = s;
    }
    @Override
    public void wakeup(){
        sensor.check();
    }
}
