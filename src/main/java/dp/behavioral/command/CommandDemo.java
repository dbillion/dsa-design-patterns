package dp.behavioral.command;

import java.util.*;

/** Command — undoable text editor. */
public final class CommandDemo {
    public static final class Editor {
        private final StringBuilder sb = new StringBuilder();
        private final Deque<Runnable> undoStack = new ArrayDeque<>();
        public void execute(String s) { int len = s.length(); sb.append(s); undoStack.push(() -> sb.delete(sb.length() - len, sb.length())); }
        public void undo() { if (!undoStack.isEmpty()) undoStack.pop().run(); }
        public String text() { return sb.toString(); }
    }

    public static void main(String[] args) {
        var e = new Editor(); e.execute("hello"); e.execute(" world"); e.undo();
        System.out.println(e.text());
    }
}
