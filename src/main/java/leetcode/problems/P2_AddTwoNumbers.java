package leetcode.problems;

import java.math.BigInteger;

import leetcode.context.ListNode;

//https://leetcode.com/problems/add-two-numbers/
public class P2_AddTwoNumbers {
  private final static BigInteger TEN = new BigInteger(10 + "");

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    BigInteger sumOfNode1 = getSumOfNode(l1);
    BigInteger sumOfNode2 = getSumOfNode(l2);

    BigInteger res = sumOfNode1.add(sumOfNode2);

    return bigIntegerToListNode(res);
  }

  private BigInteger getSumOfNode(ListNode listNode) {
    return getSumOfNode(listNode, new BigInteger(1 + ""));
  }

  private BigInteger getSumOfNode(ListNode listNode, BigInteger multiplier) {
    BigInteger currentValue = new BigInteger(listNode.val + "").multiply(multiplier);

    if (listNode.next == null) {
      return currentValue;
    }

    multiplier = multiplier.multiply(new BigInteger(10 + ""));
    return currentValue.add(getSumOfNode(listNode.next, multiplier));
  }

  private ListNode bigIntegerToListNode(BigInteger value) {
    if (value.compareTo(TEN) < 0) {
      return new ListNode((int) value.longValue());
    }

    int part = (int) value.remainder(TEN).longValue();
    BigInteger nextStepValue = value.divide(TEN);

    return new ListNode(part, bigIntegerToListNode(nextStepValue));
  }
}
