package cn.tianwenjie.lcof67;

public class Solution {
  public int strToInt(String str) {
    char[] charArray = str.toCharArray();
    int len = charArray.length;

    int start = 0;
    // 去除开头的空格
    while (start < len && charArray[start] == ' ') {
      start++;
    }
    if (start == len) {
      return 0;
    }

    // 符号标记
    int sign = 1;
    char firstChar = charArray[start];
    if (firstChar == '+') {
      start++;
    } else if (firstChar == '-') {
      start++;
      sign = -1;
    }

    int result = 0;
    while (start < len) {
      char c = charArray[start];
      if (c < '0' || c > '9') {
        break;
      }
      if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10)) {
        return Integer.MAX_VALUE;
      }
      if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && (c - '0') > -(Integer.MIN_VALUE % 10))) {
        return Integer.MIN_VALUE;
      }

      result = result * 10 + sign * (c - '0');
      start++;
    }

    return result;
  }
}
