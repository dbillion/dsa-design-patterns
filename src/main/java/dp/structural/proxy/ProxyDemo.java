package dp.structural.proxy;

/** Proxy — virtual proxy caching expensive image load. */
public final class ProxyDemo {
    public interface Image { String render(); }
    public static final class RealImage implements Image {
        private final String file; RealImage(String f) { this.file = f; }
        public String render() { return "rendered " + file; }
    }
    public static final class ProxyImage implements Image {
        private final String file; private Image real; // lazy
        public ProxyImage(String f) { this.file = f; }
        public String render() {
            if (real == null) real = new RealImage(file);
            return real.render();
        }
    }

    public static void main(String[] args) {
        Image img = new ProxyImage("pic.png");
        System.out.println(img.render());
    }
}
