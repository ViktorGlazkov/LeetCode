package leetcode.problems;

import java.util.Map;

//https://leetcode.com/problems/integer-to-roman/
public class P12_IntegerToRoman {
  private final static Map<Integer, Character> digitsToRoman = Map.of(
    1, 'I',
    5, 'V',
    10, 'X',
    50, 'L',
    100, 'C',
    500, 'D',
    1000, 'M'
  );

  private final static int THOUSAND = 1000;
  private final static int HUNDRED = 100;
  private final static int DECIMAL = 10;
  private final static int DIGIT = 1;

  public String intToRoman(int num) {

    int thousands = getValue(num, THOUSAND);
    int hundred = getValue(num -= THOUSAND * thousands, HUNDRED);
    int decimal = getValue(num -= HUNDRED * hundred, DECIMAL);
    int digit = num - DECIMAL * decimal;

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getThousandsSubstring(thousands));
    stringBuilder.append(getSubstring(hundred, HUNDRED));
    stringBuilder.append(getSubstring(decimal, DECIMAL));
    stringBuilder.append(getSubstring(digit, DIGIT));

    return stringBuilder.toString();
  }

  private int getValue(int num, int parameter) {
    return num / parameter;
  }

  private String getThousandsSubstring(int value) {
    if (value == 0) {
      return "";
    }

    StringBuilder res = new StringBuilder();

    for (int i = 0; i < value; i++) {
      res.append(digitsToRoman.get(THOUSAND));
    }

    return res.toString();
  }

  private String getSubstring(int value, int parameter) {
    if (value == 0) {
      return "";
    }

    StringBuilder res = new StringBuilder();
    int median = 5 * parameter;
    int top = 10 * parameter;

    if (value == 1) {
      return getAppendedRes(parameter);
    } else if (value == 2) {
      return getAppendedRes(parameter, parameter);
    } else if (value == 3) {
      return getAppendedRes(parameter, parameter, parameter);
    } else if (value == 4) {
      return getAppendedRes(parameter, median);
    } else if (value == 5) {
      return getAppendedRes(median);
    } else if (value == 6) {
      return getAppendedRes(median, parameter);
    } else if (value == 7) {
      return getAppendedRes(median, parameter, parameter);
    } else if (value == 8) {
      return getAppendedRes(median, parameter, parameter, parameter);
    } else if (value == 9) {
      return getAppendedRes(parameter, top);
    }

    return res.toString();
  }

  private String getAppendedRes(int... values) {
    StringBuilder res = new StringBuilder();

    for (int value : values) {
      res.append(digitsToRoman.get(value));
    }

    return res.toString();
  }
}
