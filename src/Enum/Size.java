package Enum;

import Config.ConfigParameter;

/**
 * Created by gerard on 06-01-2016.
 */
public enum Size implements ConfigParameter {
    SMALL,
    MEDIUM,
    LARGE, size;

    public void instanceMethod() {
        System.out.println("NormalMethod of " + this);
    }

    public static void staticMethod() {
        System.out.println("staticMethod");
    }


}