package problem.hard;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class Problem78 {

    /**
     * 주어진 정수 스트림에서 연속된 숫자가 나타나는 최대 길이를 찾습니다.
     * 예를 들어, [1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5]의 경우 최대 길이는 4입니다.
     *
     * @param numbers 정수 스트림
     * @return 연속된 숫자가 나타나는 최대 길이
     */
    public static int findMaxConsecutiveNumbersLength(Stream<Integer> numbers) {
        AtomicReference<Integer> prev = new AtomicReference<>(null);
        AtomicInteger current = new AtomicInteger(0);
        AtomicInteger max = new AtomicInteger(0);

        numbers.forEach(n -> {
            if (n.equals(prev.get())) {
                current.incrementAndGet();
            } else {
                current.set(1);
                prev.set(n);
            }
            max.set(Math.max(max.get(), current.get()));
        });

        return max.get();
    }
}
