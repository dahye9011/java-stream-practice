package problem.hard;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem70 {

    /**
     * 주어진 정수 리스트에서 각 숫자의 소수 여부를 판별하고, 리스트 내 최대 소수를 찾습니다.
     * 결과는 각 숫자의 소수 여부와 리스트 내 최대 소수를 포함하는 Map으로 반환합니다.
     *
     * @param numbers 정수 리스트
     * @return 각 숫자의 소수 여부와 최대 소수를 포함하는 Map
     */
    public static Map<Object, Object> identifyPrimesAndFindMax(List<Integer> numbers) {
        final String PRIME = "Prime";
        final String NOT_PRIME = "Not Prime";

        Map<Object, Object> result = numbers.stream()
                .collect(Collectors.toMap(
                        n -> n,
                        n -> {
                            if (n < 2) {
                                return NOT_PRIME;
                            }

                            for (int i = 2; i * i <= n; i++) {
                                if (n % i == 0) {
                                    return NOT_PRIME;
                                }
                            }

                            return PRIME;
                        }
                ));

        int maxPrime = numbers.stream()
                .filter(n -> {
                    if (n < 2) {
                        return false;
                    }

                    for (int i = 2; i * i <= n; i++) {
                        if (n % i == 0) {
                            return false;
                        }
                    }

                    return true;
                })
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        result.put("Max Prime", maxPrime);

        return result;
    }
}
