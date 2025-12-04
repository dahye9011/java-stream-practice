package problem.easy;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Problem28 {

    /**
     * 주어진 문자열 리스트에서 가장 긴 문자열을 찾습니다.
     *
     * @param strings 문자열 리스트
     * @return 가장 긴 문자열 (리스트가 비어있으면 Optional.empty())
     */
    public static Optional<String> findLongestString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparingInt(String::length));
    }
}
