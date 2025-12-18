package problem.hard;

import java.util.List;

public class Problem67 {

    /**
     * 주어진 문자열 리스트에서 모든 문자열이 공유하는 가장 긴 접두사를 찾습니다.
     * 공통 접두사가 없는 경우 빈 문자열을 반환합니다.
     *
     * @param strings 문자열 리스트
     * @return 가장 긴 공통 접두사, 없으면 빈 문자열
     */
    public static String findLongestCommonPrefix(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return "";
        }

        // 가장 짧은 문자열 기준
        String shortest = strings.stream()
                .min(String::compareTo)
                .orElse("");

        for (int i = 1; i <= shortest.length(); i++) {
            String prefix = shortest.substring(0, i);

            boolean allMatch = strings.stream()
                    .allMatch(s -> s.startsWith(prefix));

            if (!allMatch) {
                return shortest.substring(0, i - 1);
            }
        }

        return shortest;
    }
}
