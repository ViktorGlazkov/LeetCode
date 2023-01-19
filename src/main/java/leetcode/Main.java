package leetcode;

public class Main {

  public static void main(String[] args) {
    P918_MaximumSumCircularSubarray solution = new P918_MaximumSumCircularSubarray();

    int[] ar = {-2,4,4,4,6}; //18

    int res = solution.maxSubarraySumCircular(ar);

    System.out.println(res);
  }
}
