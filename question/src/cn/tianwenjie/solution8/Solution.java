package cn.tianwenjie.solution8;

public class Solution {
    public int myAtoi(String str) {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(solution.myAtoi("2147483646"));
        System.out.println(solution.myAtoi("-2147483649"));
        System.out.println(solution.myAtoi("-2147483647"));
    }
}
