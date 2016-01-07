package Config;

/**
 * Created by gerard on 07-01-2016.
 */
public class Length implements ConfigParameter {

    Integer length;

    public Length(Integer length) {
        this.length = length;
    }

    static Length of(Integer length) {
        return new Length(length);
    }

    @Override
    public String toString() {
        return String.valueOf(length);
    }
}
