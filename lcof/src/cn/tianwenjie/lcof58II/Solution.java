package cn.tianwenjie.lcof58II;

/**
 * 切片实现
 */
//public class Solution {
//  public String reverseLeftWords(String s, int n) {
//    return s.substring(n) + s.substring(0, n);
//  }
//}


/**
 * 遍历实现
 */
public class Solution {
  public String reverseLeftWords(String s, int n) {
    StringBuilder sb = new StringBuilder();
    for (int i = n; i < n + s.length(); i++) {
      sb.append(s.charAt(i % s.length()));
    }
    return sb.toString();
  }
}
