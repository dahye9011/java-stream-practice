package problem.hard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem64 {

    /**
     * 주어진 정수 리스트에서 피보나치 수열에 해당하는 수들의 합을 계산합니다.
     * 피보나치 수열은 0, 1, 1, 2, 3, 5, 8, 13, ... 과 같이 이전 두 수의 합으로 이루어진 수열입니다.
     *
     * @param numbers 정수 리스트
     * @return 피보나치 수열에 속하는 수들의 합
     */
    public static int sumOfFibonacciNumbers(List<Integer> numbers) {
        int max = numbers.stream()
                .max(Integer::compareTo)
                .orElse(0);

        Set<Integer> fibs = generateFibonacci(max);

        return numbers.stream()
                .filter(fibs::contains)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static Set<Integer> generateFibonacci(int max) {
        Set<Integer> fibs = new HashSet<>();
        // a = 지금 보고 있는 피보나치 수, b = 그 다음 피보나치 수
        int a = 0, b = 1;

        while (a <= max) {
            fibs.add(a);
            int next = a + b; // 앞의 수 + 그 앞의 수 = 다음 수
            a = b;
            b = next;
        }

        return fibs;
    }
}
