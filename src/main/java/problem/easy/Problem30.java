package problem.easy;

import java.util.List;

public class Problem30 {

    /**
     * 주어진 정수 리스트에서 짝수의 개수를 계산합니다.
     *
     * @param numbers 정수 리스트
     * @return 짝수의 개수
     */
    public static long countEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();
    }
}
