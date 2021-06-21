/**
 * @Author Astonm
 * @Date 2021/6/19
 * @Description: Leetcode中常用的ListNode对象，用于实现链表。
 **/
package ListNode;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
    /*
    * 将listnode转换成字符串方便查看结果
    * */
    public static String parseString (ListNode l1){
        String res = "";
        while (l1 != null){
            res += l1.val + " ";
            l1 = l1.next;
        }

        return res;
    }

    /*
    *  把数组转换成ListNode
    * */
    public static ListNode arrayToListNode(int[] nums){
        if (nums.length == 0){
            return new ListNode();
        }
        ListNode l1 = new ListNode();
        ListNode nodeTemp = new ListNode(nums[0]);
        l1.next = nodeTemp;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            nodeTemp.next = node;
            nodeTemp = node;
        }
        l1 = l1.next;
        return l1;
    }
}
