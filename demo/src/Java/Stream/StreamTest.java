package Stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {

    @Test
    public void getFirstStream() {
        Integer sequence = IntStream.range(0,10).findFirst().getAsInt();
        System.out.println(sequence);
    }

    @Test
    public void getSequenceStream() {
        List<Integer> sequence = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        System.out.println(sequence);
    }
}
