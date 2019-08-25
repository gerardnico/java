package Java.Generic.Column;

public class ColumnUtilities {

    static public <T> T getMax(Column<T> column) {
        T value;
        if (column.getMyType().equals(String.class)){
            value = (T) "3";
        } else {
            value = (T) ((Integer) 3);
        }
        return value;
    }

}