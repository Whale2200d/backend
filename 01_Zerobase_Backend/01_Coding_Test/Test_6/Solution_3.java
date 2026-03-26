import java.util.*;

public class Solution_3 {
    public static int solution(String[] ingredients, String[] items) {
        // Count required ingredients
        Map<String, Integer> need = new HashMap<>();
        for (String ing : ingredients) {
            need.put(ing, need.getOrDefault(ing, 0) + 1);
        }
        int required = need.size();

        // Sliding window
        Map<String, Integer> window = new HashMap<>();
        int formed = 0;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < items.length) {
            String ing = items[right];
            if (need.containsKey(ing)) {
                window.put(ing, window.getOrDefault(ing, 0) + 1);
                if (window.get(ing).intValue() == need.get(ing).intValue()) {
                    formed++;
                }
            }
            // Try to contract when all ingredients are included
            while (left <= right && formed == required) {
                // Update minimum window length
                minLen = Math.min(minLen, right - left + 1);
                String leftIng = items[left];
                if (need.containsKey(leftIng)) {
                    window.put(leftIng, window.get(leftIng) - 1);
                    if (window.get(leftIng).intValue() < need.get(leftIng).intValue()) {
                        formed--;
                    }
                }
                left++;
            }
            right++;
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public static void main(String[] args) {
        String[] ingredients = {"생닭", "인삼", "소주", "대추"};
        String[] items = {
                "물", "인삼", "커피", "생닭",
                "소주", "사탕", "생닭", "대추", "쌀"
        };
        int result = solution(ingredients, items);
        System.out.println(result);  // Expected output: 7
    }
}
