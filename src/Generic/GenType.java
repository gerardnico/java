package Generic;

/**
 * Created by gerard on 06-01-2016.
 */
public class GenType<T> {

    // T stands for "Type"
    private T value;

    public GenType(T value) {
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
