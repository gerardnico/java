package Config;

/**
 * Created by gerard on 06-01-2016.
 */
public enum Size implements ConfigParameter {
    SMALL,
    MEDIUM,
    LARGE;

    public void instanceMethod() {
        System.out.println("NormalMethod of " + this);
    }

    public static void staticMethod() {
        System.out.println("staticMethod");
    }


}