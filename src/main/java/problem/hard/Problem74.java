package problem.hard;

import java.util.*;
import java.util.stream.*;

public class Problem74 {

    public static List<Integer> findLongestSequentiallyIncreasingSublist(List<Integer> numbers) {
        int n = numbers.size();
        if (n == 0) {
            return List.of();
        }

        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        IntStream.range(0, n).forEach(i -> {
            int bestJ = IntStream.range(0, i)
                    .filter(j -> numbers.get(j) < numbers.get(i))
                    .boxed()
                    .max(Comparator.comparingInt(j -> dp[j]))
                    .orElse(-1);

            if (bestJ == -1) {
                dp[i] = 1;
                prev[i] = -1;
            } else {
                dp[i] = dp[bestJ] + 1;
                prev[i] = bestJ;
            }
        });

        int end = IntStream.range(0, n)
                .boxed()
                .max(Comparator.comparingInt(i -> dp[i]))
                .orElse(0);

        List<Integer> result = Stream.iterate(end, idx -> idx != -1, idx -> prev[idx])
                .map(numbers::get)
                .collect(Collectors.toCollection(ArrayList::new));

        Collections.reverse(result);
        return result;
    }
}
