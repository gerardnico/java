package Java.Generic.Container;

/**
 * Created by gerard on 06-01-2016.
 * Generic permits to create a container for special type
 */
public class GenContainerType<T> {

    // T stands for "Type"
    private T value;

    public GenContainerType(T value) {
        this.value = value;
    }

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public T getValue() {
        return value;
    }

}
