package leetcode.problems;

//https://leetcode.com/problems/maximum-sum-circular-subarray/
public class P918_MaximumSumCircularSubarray {

  public int maxSubarraySumCircular(int[] nums) {
    int maxSum = nums[0];

    for (int j = 0; j < nums.length; j++) {
      int sum = nums[j];

      if (sum > maxSum) {
        maxSum = sum;
      }

      for (int i = j + 1; i != j - 1; i++) {
        if (i == nums.length - 1) {
          if (j > 0) {
            i = 0;
          } else if (j == 0) {
            break;
          }
        }

        sum += nums[i];

        if (sum > maxSum) {
          maxSum = sum;
        }
      }
    }

    return maxSum;
  }
}
