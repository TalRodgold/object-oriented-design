package WS1.Observables;

public class AlarmClockRecord {
    private int interval;
    private int timeLeft;
    private AlarmListener alarmListener;

    public AlarmClockRecord(AlarmListener a, int i){
        interval = i;
        timeLeft = i;
        alarmListener = a;
    }

    public void setTimeLeft(Object t) {
        timeLeft = (int)t;
    }

    public int getInterval() {
        return interval;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public AlarmListener getAlarmListener() {
        return alarmListener;
    }
    public void decrementRemainingTime(int t) {
        timeLeft -= t;
    }

}
