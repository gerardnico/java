package Java.Generic.Literal;

/**
 * Every object factory should implement this interface
 * Example: {@link EmpInfoFactory}
 *
 * @param <T> - The class to build
 */
public interface GenericFactory<T> {

    T make();

}


