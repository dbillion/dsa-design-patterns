package dp.creational.builder;

import java.util.*;

/** Builder — fluent, immutable record target. */
public final class BuilderDemo {
    public record Email(String to, String subject, String body, List<String> cc) {
        public static class Builder {
            private String to, subject, body; private final List<String> cc = new ArrayList<>();
            public Builder to(String v) { this.to = v; return this; }
            public Builder subject(String v) { this.subject = v; return this; }
            public Builder body(String v) { this.body = v; return this; }
            public Builder cc(String v) { this.cc.add(v); return this; }
            public Email build() { return new Email(to, subject, body, List.copyOf(cc)); }
        }
    }

    public static void main(String[] args) {
        var e = new Email.Builder().to("a@x.com").subject("Hi").body("Hello").cc("b@x.com").build();
        System.out.println(e);
    }
}
