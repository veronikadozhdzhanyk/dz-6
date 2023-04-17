import java.util.*;

public class Main {
    public static List<Character> findUniqueChars(String[] words) {
        List<String> validWords = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            boolean allEven = true;
            for (char c : chars) {
                if (countCharOccurrences(chars, c) % 2 != 0) {
                    allEven = false;
                    break;
                }
            }
            if (allEven) {
                validWords.add(word);
                if (validWords.size() == 2) {
                    break;
                }
            }
        }
        Set<Character> uniqueChars = new HashSet<>();
        int i = 0;
        while (i < validWords.size()) {
            String word = validWords.get(i);
            int j = 0;
            while (j < word.length()) {
                uniqueChars.add(word.charAt(j));
                j++;
            }
            i++;
        }
        return new ArrayList<>(uniqueChars);
    }

    private static int countCharOccurrences(char[] chars, char c) {
        int count = 0;
        for (char ch : chars) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = {"мама", "їж їжак желе", "папа"};
        List<Character> uniqueChars = findUniqueChars(words);
        System.out.println(uniqueChars);
    }
}