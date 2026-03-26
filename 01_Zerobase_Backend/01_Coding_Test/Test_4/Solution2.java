package Test_4;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                node = node.children.computeIfAbsent(ch, k -> new TrieNode());
                node.count++;
            }
        }

        int countPrefix(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    return 0;
                }
                node = node.children.get(ch);
            }

            return node.count;
        }
    }

    public static int[] solution(String[] words, String[] queries) {
        Trie forwardTrie = new Trie();
        Trie backwardTrie = new Trie();

        for (String word : words) {
            forwardTrie.insert(word);
            String reversedWord = new StringBuilder(word).reverse().toString();
            backwardTrie.insert(reversedWord);
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (query.startsWith("*")) {
                // 접미사 검색 -> 뒤집어서 역방향 Trie로
                String suffix = new StringBuilder(query.substring(1)).reverse().toString();
                result[i] = backwardTrie.countPrefix(suffix);
            } else if (query.endsWith("*")) {
                // 접두사 검색
                String prefix = query.substring(0, query.length() - 1);
                result[i] = forwardTrie.countPrefix(prefix);
            } else {
                result[i] = 0;
            }

        }
        return result;
    }
    public static void main(String[] args) {
        String[] words = {"hello", "hell", "good", "goose", "children", "card", "teachable"};
        String[] queries = {"hell*", "goo*", "*able", "qua*"};

        int[] result = solution(words, queries);
        System.out.println(Arrays.toString(result)); // [2, 2, 1, 0]
    }
}
