package leetcode.problems;

import java.util.Map;

//https://leetcode.com/problems/roman-to-integer/
public class P13_RomanToInteger {
  private final static Map<Character, Integer> values = Map.of(
    'I', 1,
    'V', 5,
    'X', 10,
    'L', 50,
    'C', 100,
    'D', 500,
    'M', 1000
  );

  public int romanToInt(String s) {
    int res = 0;

    char[] chars = s.toCharArray();

    for (int index = chars.length - 1; index >= 0; index--) {
      char character = chars[index];
      int value = values.get(character);

      if (index - 1 >= 0) {
        char previousCharacter = chars[index - 1];
        int previousValue = values.get(previousCharacter);

        if (previousValue < value) {
          value -= previousValue;
          index--;
        }
      }

      res += value;
    }

    return res;
  }
}
