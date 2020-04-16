package Java.Stream;


public interface MyFunctionalInterface  {

    /**
     * The unique function
     */
    void execute();

    default void print(String text) {
        System.out.println(text);
    }


}
