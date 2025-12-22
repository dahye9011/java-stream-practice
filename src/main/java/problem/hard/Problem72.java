package problem.hard;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem72 {

    /**
     * 주어진 정수 리스트에서 합이 짝수이면서 길이가 3 이상인 모든 서브리스트를 찾습니다.
     *
     * @param numbers 정수 리스트
     * @return 합이 짝수이고 길이가 3 이상인 모든 서브리스트의 집합
     */
    public static Set<List<Integer>> findSublistsMeetingCriteria(List<Integer> numbers) {
        int n = numbers.size();

        return IntStream.range(0, 1 << n)
                .filter(mask -> Integer.bitCount(mask) >= 3)
                .mapToObj(mask ->
                        IntStream.range(0, n)
                                .filter(i -> (mask & (1 << i)) != 0)
                                .mapToObj(numbers::get)
                                .toList()
                )
                .filter(list -> list.stream().mapToInt(Integer::intValue).sum() % 2 == 0)
                .collect(Collectors.toSet());
    }
}
