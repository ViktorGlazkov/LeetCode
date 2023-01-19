package leetcode.problems;

//https://leetcode.com/problems/two-sum/
public class P1_TwoSum {
  public int[] twoSum(int[] nums, int target) {
    int[] res = new int[2];

    for (int i = 0; i < nums.length - 1; i++) {
      int first = nums[i];

      for (int y = i + 1; y < nums.length; y ++) {
        int second = nums[y];

        if (first + second == target) {
          res[0] = i;
          res[1] = y;
          break;
        }
      }

      if (res[1] != 0) {
        break;
      }
    }

    return res;
  }
}
