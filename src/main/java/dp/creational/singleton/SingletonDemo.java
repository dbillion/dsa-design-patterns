package dp.creational.singleton;

/** Singleton — enum-based (Josh Bloch style, serialization & reflection safe). */
public final class SingletonDemo {
    public enum Singleton { INSTANCE; }

    public static void main(String[] args) {
        var a = Singleton.INSTANCE;
        var b = Singleton.INSTANCE;
        System.out.println("same instance? " + (a == b));
    }
}
