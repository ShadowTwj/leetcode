package cn.tianwenjie;

/**
 * @author tianwj
 * @date 2021/3/26
 */
public class Test {

  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3, 3, 3, 3};
    System.out.println(GetNumberOfK(arr, 3));
  }

  public static int GetNumberOfK(int[] array, int k) {
    int n = query(array, k);
    if (n == -1) {
      return 0;
    }
    int result = 0;
    while (n < array.length && array[n] == k) {
      result++;
      n++;
    }
    return result;
  }

  private static int query(int[] arr, int n) {
    if (arr.length == 0 || n < arr[0] || n > arr[arr.length - 1]) {
      return -1;
    }

    int i = arr.length / 2;
    while (true) {
      if (arr[i] > n) {
        i = i / 2;
      } else if (arr[i] < n) {
        i = i + (arr.length - i) / 2;
      } else {
        while (i > 0 && arr[i - 1] == n) {
          i--;
        }
        return i;
      }
    }
  }
}
