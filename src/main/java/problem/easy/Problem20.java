package problem.easy;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem20 {

    /**
     * 스트림을 사용하여 정수 배열에서 LinkedHashMap을 생성합니다.
     * 배열의 각 요소를 key로 하고, 해당 요소를 제곱한 값을 value로 하는 LinkedHashMap을 반환합니다.
     *
     * @param numbers 정수 배열
     * @return 생성된 LinkedHashMap
     */
    public static Map<Integer, Integer> createLinkedHashMapFromStream(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed() // IntStream → Stream<Integer>
                .collect(Collectors.toMap(
                        n -> n,
                        n -> (n * n),
                        (v1, v2) -> v1,
                        LinkedHashMap::new
                ));
    }
}
