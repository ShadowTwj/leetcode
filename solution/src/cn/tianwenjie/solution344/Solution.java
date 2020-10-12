package cn.tianwenjie.solution344;

public class Solution {
  public void reverseString(char[] s) {
    int n = s.length;
    for (int i = 0; i < n / 2; i++) {
      if (s[i] != s[n - 1 - i]) {
        char temp = s[i];
        s[i] = s[n - 1 - i];
        s[n - 1 - i] = temp;
      }
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    char[] s = new char[]{'h','e','l','l','o'};
    char[] ss = new char[]{'H','a','n','n','a','h'};
    solution.reverseString(s);
    solution.reverseString(ss);
    System.out.println(s);
    System.out.println(ss);
  }
}
