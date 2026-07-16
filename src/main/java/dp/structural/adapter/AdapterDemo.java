package dp.structural.adapter;

import java.util.*;

/** Adapter — legacy Fahrenheit sensor to Celsius interface. */
public final class AdapterDemo {
    public interface CelsiusSensor { double readC(); }
    public static final class FahrenheitSensor { public double readF() { return 98.6; } }

    public static final class Adapter implements CelsiusSensor {
        private final FahrenheitSensor s;
        public Adapter(FahrenheitSensor s) { this.s = s; }
        public double readC() { return (s.readF() - 32) * 5 / 9; }
    }

    public static void main(String[] args) {
        CelsiusSensor c = new Adapter(new FahrenheitSensor());
        System.out.println("Celsius=" + c.readC());
    }
}
