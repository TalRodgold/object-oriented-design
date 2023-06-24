package WS1.Observables;

import java.util.ArrayList;

public class AlarmClock
{
    public final int CLOCK_INTERVAL_MILLIS = 100;
    protected static AlarmClock instance = null;
    private ArrayList<AlarmClockRecord> itsAlarmClockRecords = new ArrayList();

    protected AlarmClock() {}
    public static AlarmClock theInstance()
    {
        if(null==instance)
            instance = new AlarmClock();
        return instance;
    }

    protected void tic(){
        for (AlarmClockRecord r: itsAlarmClockRecords) {
            if (r.getTimeLeft() - CLOCK_INTERVAL_MILLIS <= 0){
                r.getAlarmListener().wakeup();
                r.setTimeLeft(r.getInterval());
            }
            else
                r.decrementRemainingTime(CLOCK_INTERVAL_MILLIS);
        }    }

    public void register(int interval, AlarmListener pal) {
        itsAlarmClockRecords.add(new AlarmClockRecord(pal, interval));
    }
}

