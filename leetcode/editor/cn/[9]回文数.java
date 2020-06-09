//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        return this.isPalindrome1(x);
    }

    public boolean isPalindrome1(int x) {
        /**
         * 方案一：
         *      将整数作为一个字符串处理
         *      优点：思路清晰，实现起来比较容易
         *      缺点：空间复杂度较高，需要存储大量的临时字符串
         * 提交结果：
         * 解答成功:
         * 			执行耗时:22 ms,击败了6.41% 的Java用户
         * 			内存消耗:39.4 MB,击败了5.14% 的Java用户
         */
        String intStr = String.valueOf(x);
        char[] chars = intStr.toCharArray();
        String newStr = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            newStr = newStr + String.valueOf(chars[i]);
        }
        return intStr.equals(newStr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
