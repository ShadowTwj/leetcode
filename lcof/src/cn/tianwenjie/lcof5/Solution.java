package cn.tianwenjie.lcof5;

/**
 * StringBuild实现
 */
//public class Solution {
//  public String replaceSpace(String s) {
//    StringBuilder sb = new StringBuilder();
//    for (Character c : s.toCharArray()) {
//      if (c == ' ')) {
//        sb.append("%20");
//      } else {
//        sb.append(c);
//      }
//    }
//    return sb.toString();
//  }
//
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    System.out.println(solution.replaceSpace("We are happy."));
//  }
//}


/**
 * 数组实现
 */
public class Solution {
  public String replaceSpace(String s) {
    int count = 0;
    for (Character c : s.toCharArray()) {
      if (c == ' ') {
        count++;
      }
    }
    char[] result = new char[s.length() + count * 2];
    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ' ') {
        result[j++] = '%';
        result[j++] = '2';
        result[j++] = '0';
      } else {
        result[j++] = c;
      }
    }

    return new String(result);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.replaceSpace("We are happy."));
  }
}
