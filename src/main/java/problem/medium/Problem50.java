package problem.medium;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem50 {

    /**
     * 주어진 정수 리스트에서 합이 10을 초과하는 최초의 연속된 부분 리스트를 반환합니다.
     * 예를 들어, [1, 2, 3, 5, 4]의 경우 [3, 5, 4]가 해당합니다.
     *
     * @param numbers 정수 리스트
     * @return 합이 10을 초과하는 최초의 연속된 부분 리스트
     */
    public static List<Integer> findFirstSublistWithSumOverTen(List<Integer> numbers) {
        Stream<List<Integer>> allSublists = IntStream.range(0, numbers.size())
                .boxed()
                // start 인덱스 스트림
                .flatMap(start ->
                        // end 인덱스 스트림
                        IntStream.range(start, numbers.size())
                                .mapToObj(end -> numbers.subList(start, end + 1))
                );

        return allSublists
                .filter(sublist -> sublist.stream().mapToInt(Integer::intValue).sum() > 10)
                .min(Comparator
                        .<List<Integer>>comparingInt(List::size)
                        .thenComparingInt(sublist -> numbers.indexOf(sublist.get(0))))
                .orElse(List.of());
    }
}
