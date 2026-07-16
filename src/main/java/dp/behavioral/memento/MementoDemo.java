package dp.behavioral.memento;

/** Memento — save/restore editor state. */
public final class MementoDemo {
    public record State(String text) {}
    public static final class Editor {
        private String text = "";
        public void set(String t) { text = t; }
        public State save() { return new State(text); }
        public void restore(State s) { text = s.text(); }
        public String text() { return text; }
    }

    public static void main(String[] args) {
        var e = new Editor(); e.set("v1"); var snap = e.save(); e.set("v2");
        e.restore(snap); System.out.println(e.text());
    }
}
