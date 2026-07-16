package dp.behavioral.iterator;

import java.util.*;

/** Iterator — custom range iterator. */
public final class IteratorDemo {
    public static final class Range implements Iterable<Integer> {
        private final int lo, hi;
        public Range(int lo, int hi) { this.lo = lo; this.hi = hi; }
        public Iterator<Integer> iterator() {
            return new Iterator<>() {
                private int cur = lo;
                public boolean hasNext() { return cur <= hi; }
                public Integer next() { return cur++; }
            };
        }
    }

    public static void main(String[] args) {
        var sum = 0; for (int i : new Range(1, 5)) sum += i;
        System.out.println("sum=" + sum);
    }
}
