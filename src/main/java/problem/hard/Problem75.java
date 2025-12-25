package problem.hard;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem75 {

    /**
     * 주어진 문자열 리스트에서 각 문자열의 유니크한 문자 조합의 수를 계산합니다.
     * 예를 들어, "abb"의 경우 "a", "b", "ab"의 3가지 유니크한 조합이 존재합니다.
     *
     * @param strings 문자열 리스트
     * @return 각 문자열별 유니크한 문자 조합의 수를 나타내는 Map
     */
    public static Map<String, Long> countUniqueCharacterCombinations(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(
                        s -> s,
                        s -> {
                            long k = s.chars().distinct().count();
                            return (1L << k) - 1;
                        }
                ));
    }
}
