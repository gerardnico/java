package Java.Stream;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class MyFunction {

    @Test
    public void name() {

        // Java contains a set of functional interfaces designed for commonly occuring use cases,
        // The Function interface represents a function (method) that takes a single parameter and returns a single value.
        MyFunctionalInterface lambda = () -> {System.out.println("Executing...");};


        Function<Integer, Integer> increment = new Increment();
        Integer result = increment.apply(4);
        System.out.println("result = " + result);

        Function<Integer, Integer> incrementLambda = (i) -> i + 1;
        result = incrementLambda.apply(4);
        System.out.println("result = " + result);

        IntConsumer lambdaInt = (e) -> {System.out.println("Executing..."+e);};
        IntStream.range(0,9).forEach(lambdaInt);


    }
}


