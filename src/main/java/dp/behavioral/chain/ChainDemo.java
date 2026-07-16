package dp.behavioral.chain;

import java.util.*;

/** Chain of Responsibility — log level handlers. */
public final class ChainDemo {
    public sealed interface Handler permits Info, Warn, Error {
        Optional<String> handle(int level, String msg);
    }
    public record Info() implements Handler {
        public Optional<String> handle(int l, String m) { return l <= 1 ? Optional.of("INFO: " + m) : Optional.empty(); }
    }
    public record Warn() implements Handler {
        public Optional<String> handle(int l, String m) { return l <= 2 ? Optional.of("WARN: " + m) : Optional.empty(); }
    }
    public record Error() implements Handler {
        public Optional<String> handle(int l, String m) { return l <= 3 ? Optional.of("ERROR: " + m) : Optional.empty(); }
    }

    public static void main(String[] args) {
        var chain = List.<Handler>of(new Info(), new Warn(), new Error());
        int level = 3;
        var out = chain.stream().map(h -> h.handle(level, "boom")).filter(Optional::isPresent).map(Optional::get).findFirst();
        System.out.println(out.orElse("dropped"));
    }
}
