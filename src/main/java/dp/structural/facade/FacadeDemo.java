package dp.structural.facade;

import java.util.*;

/** Facade — home theater one-call interface over subsystems. */
public final class FacadeDemo {
    public static final class Dvd { String on() { return "DVD on"; } }
    public static final class Amp { String on() { return "Amp on"; } }
    public static final class Lights { String dim() { return "Lights dim"; } }
    public static final class HomeTheater {
        private final Dvd dvd = new Dvd(); private final Amp amp = new Amp(); private final Lights lights = new Lights();
        public List<String> watch() { return List.of(lights.dim(), amp.on(), dvd.on()); }
    }

    public static void main(String[] args) {
        System.out.println(new HomeTheater().watch());
    }
}
