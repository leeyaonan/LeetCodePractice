//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] twoSum(int[] nums, int target) {

//        return this.twoSum1(nums, target);

        return this.twoSum2(nums, target);

    }

    public int[] twoSum1(int[] nums, int target) {
         /*
        * 方案一：穷举法
        *   遍历两次数组，以和为key，数组下标为value，放入hashmap，再根据target从中取出结果数组
        * 优点：对于静态nums，一旦初始化后，可以很快获取结果集，空间换时间
        * 缺点：对于动态变化的nums，时间复杂度和空间复杂度都很大
        *
        * 提交结果：
        *   info
			运行失败:
			Time Limit Exceeded
			stdout:
			null
        * */
        HashMap<Integer, int[]> hashMap = new HashMap<Integer, int[]>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                int[] indexs = new int[]{i, j};
                hashMap.put(sum, indexs);
            }
        }
        return hashMap.get(target);
    }

    public int[] twoSum2(int[] nums, int target) {
         /*
        * 方案二：
        *   边离数组，将元素与下标的映射关系存入hashmap，再次边离数组，根据target和元素的差值找对应另一个元素的下标
        *
        * 提交结果：
        *   info
			解答成功:
			执行耗时:3 ms,击败了80.38% 的Java用户
			内存消耗:40 MB,击败了5.06% 的Java用户
        * */
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int divide = target - nums[i];
            Integer j = hashMap.get(divide);
            if (null != j && i != j) {
                return new int[]{i, j};
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
