package WS1.Nimbus1;

import WS1.Observables.Sensor;

import java.util.Random;

public class Nimbus1PressureSensor extends Sensor {
    private Random randObj;

    public Nimbus1PressureSensor(String s, int i){
        super(s,i);
        randObj = RandomSupplier.getRnd();
    }

    @Override
    public int read(){
        return 950 + randObj.nextInt(100);
    }
}
