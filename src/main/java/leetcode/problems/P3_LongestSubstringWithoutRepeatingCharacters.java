package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class P3_LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    char[] characters = s.toCharArray();

    int maxLength = 0;

    for (int i = 0; i < characters.length - 1; i++) {
      Set<Character> chars = new HashSet<>();
      chars.add(characters[i]);

      int size = 1;

      for (int y = i + 1; y < characters.length; y++) {
        chars.add(characters[y]);
        ++size;

        if (size > chars.size() || y == characters.length - 1) {
          if (chars.size() > maxLength) {
            maxLength = chars.size();
          }

          break;
        }
      }
    }

    return maxLength;
  }
}
