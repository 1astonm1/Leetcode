/**
 * @Author Astonm
 * @Date 2021/6/19
 * @Description:
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 例如
 *    2 -> 4 -> 3
 *    5 -> 6 -> 4
 *    -----------
 *    7 -> 0 -> 8
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 例
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 位数不同也需要计算
 *
 * 思路：
 *  按照顺序遍历数组，由于是逆序，把每个位置上的数字相加即可。注意进位符。sum = num1 + num2 + carry
 *  当某个list位数用尽时，取0和另一个list相加。
 *
 **/

import ListNode.ListNode;



public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] input1 = {9,9,9,9,9,9,9};
        int[] input2 = {9,9,9,9};

        ListNode l1 = ListNode.arrayToListNode(input1);
        ListNode l2 = ListNode.arrayToListNode(input2);
        ListNode res = addTwoNumbers(l1, l2);
        System.out.println(ListNode.parseString(res));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        ListNode point = head;
        int carry = 0;

        while(l1 != null || l2 != null){
            int val1 = (l1 != null)? l1.val : 0;    // 如果位数用尽就取0
            int val2 = (l2 != null)? l2.val : 0;
            int sum = val1 + val2 + carry;  // 把两个数字和进位符相加
            ListNode node = new ListNode(sum%10);   // 只取个位数放在当前位置上
            carry = sum/10;  //将进位写给carry
            point.next = node;
            point = point.next;  // 调整指针位置
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }

        if (carry != 0){   // 这里要注意！！！ 当所有都结束时，检查是否有进位。
            ListNode node = new ListNode(carry);
            point.next = node;
        }
        return head.next;
    }
}
