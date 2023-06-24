package WS1.Observables;

import WS1.Observers.Observer;
import WS1.System.Trend;

public class PressureTrendSensor extends Observable implements Observer {
    private int last_reading_1 = 0;
    private int last_reading_2 = 0;
    private int last_reading_3 = 0;
    private Trend lastState = Trend.STABLE;
    private Trend pressureState;

    public PressureTrendSensor(Sensor s) {
        s.addObserver(this);
        System.out.println("PressureTrendSensor observes pressure");
    }


    @Override
    public void update(Object d) {
        check(d);
    }


    public void check(Object d) {
        pressureState = calcTrend(d);

        if (lastState != pressureState) {
            notifyObservers(pressureState);
        }
        lastState = pressureState;
    }

    private Trend calcTrend(Object d) {
        last_reading_1 = last_reading_2;
        last_reading_2 = last_reading_3;
        last_reading_3 = (int)d;


        if (last_reading_1 > last_reading_2) {
            if (last_reading_2 > last_reading_3) {
                return Trend.FALLING;
            }
        } else if (last_reading_1 < last_reading_2) {
            if (last_reading_2 < last_reading_3) {
                return Trend.RISING;
            }
        }
        return Trend.STABLE;
    }


}
