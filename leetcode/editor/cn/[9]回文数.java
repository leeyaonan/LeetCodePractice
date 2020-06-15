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
//        return this.isPalindrome1(x);
        return this.isPalindrome2(x);
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

    public boolean isPalindrome2(int x) {
        /**
         * 方案二：
         *      只比较数字的一半，当数字位数为奇数（n）时，只要比较后n%2位翻转与前n%2位一致不一致即可
         *      eg：121，只需要比较1和1，12321只需要比较21翻转是否=12
         *
         *      并且考虑一些边界条件：
         *      1. 所有的负数肯定不是回文数
         *      2. 除0以外最后一位为0的肯定不是回文数（因为除了0没有第一位为0的整数）
         * 提交结果：
         * 解答成功:
         * 			执行耗时:10 ms,击败了66.25% 的Java用户
         * 			内存消耗:39 MB,击败了5.14% 的Java用户
         */
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // revertNumber记录原始数字一半（向下取整）的的反转后的数字
        int revertNumber = 0;

        while (x > revertNumber) {
            revertNumber = revertNumber * 10 + x % 10;
            x /= 10;
        }

        // 偶数的revertNum =
        return x == revertNumber || x == revertNumber / 10;

        /*
        eg1：
            x = 121
            step1: revertNumber = 0,x = 121
            step2: x > revertNumber -> revertNumber = 0 * 10 + 121 % 10 = 1, x = 121 / 10 = 12
            step3: x > revertNumber -> revertNumber = 1 * 10 + 12 % 10 = 12, x = 12 / 10 = 1
            step4: x < revertNumber -> revertNumber = 12, x = 1
            step5: x == revertNumber / 10 = 1 -> true

        eg2：
            x = 1221
            step1: revertNumber = 0,x = 1221
            step2: x > revertNumber -> revertNumber = 0 * 10 + 1221 % 10 = 1, x = 1221 / 10 = 122
            step3: x > revertNumber -> revertNumber = 1 * 10 + 122 % 10 = 12, x = 122 / 10 = 12
            step4: x == revertNumber -> revertNumber = 12, x = 12
            step5: x == revertNumber = 12 -> true
         */
    }
}
//leetcode submit region end(Prohibit modification and deletion)
