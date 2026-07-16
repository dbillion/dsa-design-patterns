package dp.creational.abstractfactory;

/** Abstract Factory — cross-platform UI (records + sealed). */
public final class AbstractFactoryDemo {
    public record Button(String label) {}
    public record Checkbox(String label) {}

    public sealed interface GUIFactory permits WinFactory, MacFactory {
        Button createButton(); Checkbox createCheckbox();
    }
    public static final class WinFactory implements GUIFactory {
        public Button createButton() { return new Button("WinBtn"); }
        public Checkbox createCheckbox() { return new Checkbox("WinChk"); }
    }
    public static final class MacFactory implements GUIFactory {
        public Button createButton() { return new Button("MacBtn"); }
        public Checkbox createCheckbox() { return new Checkbox("MacChk"); }
    }

    public static GUIFactory getFactory(String os) {
        return switch (os) {
            case "win" -> new WinFactory();
            case "mac" -> new MacFactory();
            default -> throw new IllegalArgumentException(os);
        };
    }

    public static void main(String[] args) {
        var f = getFactory("mac");
        System.out.println(f.createButton() + " / " + f.createCheckbox());
    }
}
