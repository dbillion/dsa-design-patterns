package dp.behavioral.state;

/** State — vending machine. */
public final class StateDemo {
    public sealed interface State permits Idle, HasCoin {
        State insert(); String label();
    }
    public record Idle() implements State { public State insert() { return new HasCoin(); } public String label() { return "idle"; } }
    public record HasCoin() implements State { public State insert() { return this; } public String label() { return "hasCoin"; } }

    public static void main(String[] args) {
        State s = new Idle(); s = s.insert();
        System.out.println(s.label());
    }
}
