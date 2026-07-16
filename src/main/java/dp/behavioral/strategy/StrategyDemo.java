package dp.behavioral.strategy;

import java.util.*;
import java.util.function.*;

/** Strategy — sort strategies as functions. */
public final class StrategyDemo {
    public static <T extends Comparable<T>> List<T> sort(List<T> in, Comparator<T> cmp) {
        var out = new ArrayList<>(in); out.sort(cmp); return out;
    }

    public static void main(String[] args) {
        var list = List.of(3, 1, 2);
        System.out.println(sort(list, Comparator.naturalOrder()));
        System.out.println(sort(list, Comparator.reverseOrder()));
    }
}
