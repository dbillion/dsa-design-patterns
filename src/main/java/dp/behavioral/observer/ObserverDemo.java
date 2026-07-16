package dp.behavioral.observer;

import java.util.*;
import java.util.function.*;

/** Observer — publisher/subscriber. */
public final class ObserverDemo {
    public static final class Subject {
        private final List<Consumer<String>> subs = new ArrayList<>();
        public void subscribe(Consumer<String> c) { subs.add(c); }
        public void publish(String msg) { subs.forEach(s -> s.accept(msg)); }
    }

    public static void main(String[] args) {
        var s = new Subject();
        s.subscribe(m -> System.out.println("sub1: " + m));
        s.publish("hello");
    }
}
