package dp.structural.composite;

import java.util.*;

/** Composite — file system of files and directories. */
public final class CompositeDemo {
    public sealed interface Node permits File, Directory {
        int size();
    }
    public record File(String name, int size) implements Node {}
    public static final class Directory implements Node {
        private final String name; private final List<Node> children = new ArrayList<>();
        public Directory(String n) { this.name = n; }
        public void add(Node n) { children.add(n); }
        public int size() { return children.stream().mapToInt(Node::size).sum(); }
    }

    public static void main(String[] args) {
        var d = new Directory("root");
        d.add(new File("a.txt", 10));
        var sub = new Directory("sub"); sub.add(new File("b.txt", 5));
        d.add(sub);
        System.out.println("total size=" + d.size());
    }
}
