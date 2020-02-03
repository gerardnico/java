package Java.Enum;

/**
 * Created by gerard on 07-01-2016.
 */
public class DemoEnum {

    public static void main(String[] args) {

        System.out.printf("Each enum has its own instance of the Size class");
        Size.SMALL.instanceMethod();
        Size.MEDIUM.instanceMethod();
        Size.LARGE.instanceMethod();

        System.out.printf("Static method can also be used");
        Size.staticMethod();

        System.out.println("The enum comes from the same class");
        System.out.println(Size.LARGE.getClass());
        System.out.println(Size.LARGE.getClass().equals(Size.class));

        Size size = Size.SMALL;
        if (size== Size.SMALL) {
            System.out.println("The equality sign comparison works because they are the same object");
        }

    }
}
