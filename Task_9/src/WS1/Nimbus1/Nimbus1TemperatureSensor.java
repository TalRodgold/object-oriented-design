package WS1.Nimbus1;

import WS1.Observables.Sensor;

import java.util.Random;

public class Nimbus1TemperatureSensor extends Sensor {
    private Random randObj;
    public Nimbus1TemperatureSensor(String s, int i){
        super(s,i);
        randObj = RandomSupplier.getRnd();
    }

    @Override
    public int read(){
        return randObj.nextInt(40);
    }
}
