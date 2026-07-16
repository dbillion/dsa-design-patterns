package dp.behavioral.template;

/** Template Method — brew hot beverage. */
public final class TemplateDemo {
    public abstract static class Beverage {
        public final String make() { return boil() + " -> " + brew() + " -> " + pour(); }
        protected abstract String brew();
        protected String boil() { return "boil water"; }
        protected String pour() { return "pour cup"; }
    }
    public static final class Tea extends Beverage { protected String brew() { return "steep tea"; } }
    public static final class Coffee extends Beverage { protected String brew() { return "brew coffee"; } }

    public static void main(String[] args) {
        System.out.println(new Tea().make());
        System.out.println(new Coffee().make());
    }
}
