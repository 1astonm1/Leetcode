import java.util.*;

/*
给定一个整数数组 nums[]和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

 示例1
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

 示例2
输入：nums = [3,2,4], target = 6
输出：[1,2]
* */

/*
* 思路：
* 暴力解： 两个循环嵌套遍历数组，第一个循环的指针指向的数字去数组遍历查找是否有相加等于target的目标数字。 解法需要遍历两次数组，复杂度为O(N2)
* 最优解： 利用HashMap来完成第二次寻找过程，可将匹配是否存在数字存储到HashMap的key中，在寻找时通过map.containsKey()来判断是否存在，
* 将寻找复杂度从O(N)降低到O(1)。HashMap中的key和value分别存储数字的值和在数组中的index。
*
* 注：类似这样寻找数字是否在数组中存在的问题，都可以通过HashMap来解决。将待寻找数字存储到HashMap的key中可以降低查找的时间复杂度。
* */

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 18;
        int [] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }


    public static int[] twoSum(int[] nums, int target){
        Map <Integer, Integer> map = new HashMap<>();   //存储数字的hashmap
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)){     // 如果之前存入的数字中有目标数字
                return new int[] { map.get(temp), i};   // 直接输出两个数字的index
            }
            else{
                map.put(nums[i], i);    // 如果之前数组中不存在，则将当前数字和index存储到hashmap中。
            }
        }
        throw new IllegalArgumentException("No two sum solution!");
    }
}

