import ListNode.ListNode;
/**
 * @Author Astonm
 * @Date 2021/6/22
 * @Description: Leetcode 第21题 合并两个有序链表
 *  将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 *  l1 和 l2 均按 非递减顺序 排列
 *  1 -> 2 -> 4
 *  2 -> 3 -> 4
 *  ------------
 *  1 -> 2 -> 2 -> 3 -> 4 -> 4
 *
 *  示例
 *  输入：l1 = [], l2 = [0]
 *  输出：[0]
 *
 *  输入：l1 = [1,2,4], l2 = [1,3,4]
 *  输出：[1,1,2,3,4,4]
 *
 *  输入：l1 = [], l2 = []
 *  输出：[]
 *
 *  思路
 *  1、直接合并， 用指针分别指向两个链表的头结点，比较头结点大小，小的先放到res链表中，指针向后指一位，以此直到链表为空。
 *  2、递归，将mergeTwoLists写成递归函数， 如果 l1 或者 l2 一开始就是空链表 ，那么没有任何操作需要合并，所以我们只需要返回非空链表。
 *  否则，我们要判断 l1 和 l2 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点。如果两个链表有一个为空，递归结束。
 */
public class MergeTwoLists {
    public static void main(String[] args){
        int[] input1 = {1,3,4,6,6,9,10,11};
        int[] input2 = {1,2,3,5,6,7,7,8};

        ListNode l1 = ListNode.arrayToListNode(input1);
        ListNode l2 = ListNode.arrayToListNode(input2);

        ListNode res = mergeTwoLists(l1, l2);
        System.out.println(ListNode.parseString(res));

        ListNode res1 = mergeTwoLists1(l1, l2);
        System.out.println(ListNode.parseString(res1));

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        //如果l1或者l2中有空，直接输出
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        //创建结果list， 并将point指向头结点。
        ListNode res = new ListNode();
        ListNode point = res;
        // 迭代， 直到一个list为空。
        while(l1!=null && l2!=null){
            if (l1.val <= l2.val){
                point.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                point.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            point = point.next;
        }
        //为空后可能存在有链表还没处理完，直接接在最尾部即可。
        point.next = l1 == null ? l2 : l1;

        return res.next;
    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        //递归结束条件： 某个链表为空，后面直接接上另外一个链表即可。
        if (l1 == null){
            return l2;
        }
        else if (l2 == null){
            return l1;

        }
        // 比较l1, l2 两个节点，小的作为当前节点返回值，并递归调用mergeTwoLists1，让找出的下一个节点作为当前节点的next。
        else if (l1.val < l2.val){
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }

    }
}
