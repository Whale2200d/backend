package Test_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution3 {
    /**
     * 숫자만으로 이루어진 문자열 s에서 유효한 IP 주소를 모두 복원하여
     * 오름차순 정렬된 String[]로 반환
     */
    public static String[] restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    // 현재까지 만든 세그먼트 리스트와 문자열 시작 인덱스를 들고 재귀 탐색
    private static void backtrack(String s, int start, List<String> segments, List<String> result) {
        // 4개의 세그먼트를 모두 채웠으면
        if (segments.size() == 4) {
            // 문자열 전체를 사용했을 때만 결과에 추가
            if (start == s.length()) {
                result.add(String.join(".", segments));
            }
            return;
        }

        // 남은 세그먼트 개수와 남은 문자열 길이로 가지치기
        int remSegments = 4 - segments.size();
        int remChars = s.length() - start;
        if (remChars < remSegments || remChars > remSegments * 3) {
            return;
        }

        // 각 세그먼트 길이를 1~3자로 시도
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;

            String part = s.substring(start, start + len);

            if (isValidSegment(part)) {
                segments.add(part);
                backtrack(s, start + len, segments, result);
                segments.remove(segments.size() - 1);
            }
        }
    }

    // 유효한 IP 세그먼트 판단: "0"이거나, 앞이 0이 없고 0~255 범위
    private static boolean isValidSegment(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) {
            return false;
        }
        int value = Integer.parseInt(segment);
        return value <= 255;
    }

    public static void main(String[] args) {
        String s = "11011";
        String[] ips = restoreIpAddresses(s);
        System.out.println(Arrays.toString(ips));
        // 출력: ["1.1.0.11", "1.10.1.1", "11.0.1.1"]
    }
}
