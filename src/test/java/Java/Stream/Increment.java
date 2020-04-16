package Java.Stream;

import java.util.function.Function;

public class Increment implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer l) {
        return l + 1;
    }

}
