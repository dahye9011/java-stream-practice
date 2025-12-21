package problem.hard;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem71 {

    /**
     * 주어진 문자열 리스트에서 가능한 모든 문자열 조합을 찾습니다.
     * 각 조합은 리스트의 문자열을 연결하여 생성되며, 중복은 제거합니다.
     *
     * @param strings 문자열 리스트
     * @return 모든 가능한 문자열 조합의 집합
     */
    public static Set<String> findAllStringCombinations(List<String> strings) {
        int n = strings.size();

        return IntStream.range(1, 1 << n)
                .mapToObj(mask ->
                        IntStream.range(0, n)
                                .filter(i -> (mask & (1 << i)) != 0)
                                .mapToObj(strings::get)
                                .collect(Collectors.joining())
                        )
                .collect(Collectors.toSet());
    }
}
