package Java.Generic.Column;

/**
 * Where T is the type of the column
 * @param <T>
 */
public class Column<T>  {

    // T stands for "Type"
    private String value;
    private Integer precision;
    private final Class<T> type;

    public Column(Class<T> type) {
        this.type = type;
    }

    public void setPrecision(Integer value) {
        this.precision = value;
    }

    public Class<T> getMyType() {
        return this.type;
    }

}
