package dp.structural.flyweight;

import java.util.*;
import java.util.concurrent.*;

/** Flyweight — shared character glyphs. */
public final class FlyweightDemo {
    public record Glyph(char c) {}
    public static final class GlyphFactory {
        private final Map<Character, Glyph> cache = new ConcurrentHashMap<>();
        public Glyph get(char c) { return cache.computeIfAbsent(c, Glyph::new); }
    }
    public record Text(List<Glyph> glyphs) {
        public int distinctCount() { return (int) glyphs.stream().map(Glyph::c).distinct().count(); }
    }

    public static void main(String[] args) {
        var f = new GlyphFactory();
        var t = new Text(List.of(f.get('a'), f.get('b'), f.get('a')));
        System.out.println("glyphs=" + t.glyphs().size() + " distinct=" + t.distinctCount());
    }
}
