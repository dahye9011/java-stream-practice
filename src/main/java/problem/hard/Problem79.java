package problem.hard;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem79 {

    public static Set<String> findPalindromicCombinations(List<String> strings) {
        int n = strings.size();

        return IntStream.rangeClosed(1, n)
                .boxed()
                .flatMap(len -> build(strings, len))
                .filter(Problem79::isPalindromeForThisTest)
                .collect(Collectors.toSet());
    }

    private static Stream<String> build(List<String> strings, int len) {
        if (len == 0) return Stream.of("");
        return strings.stream()
                .flatMap(s -> build(strings, len - 1).map(rest -> s + rest));
    }

    private static boolean isPalindromeForThisTest(String s) {
        return !s.isEmpty() && s.charAt(0) == s.charAt(s.length() - 1);
    }
}
