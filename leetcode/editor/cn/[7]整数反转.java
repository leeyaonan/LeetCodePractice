//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
//        return this.reverse1(x);

//        return this.reverse2(x);

        return this.reverse3(x);
    }

    public int reverse1(int x) {
        /**
         * 方案一：
         *      翻转字符串，并根据条件进行修改，然后解析为数字
         *
         * 提交结果：
         * 解答成功:
         * 			执行耗时:5 ms,击败了12.71% 的Java用户
         * 			内存消耗:38 MB,击败了5.33% 的Java用户
         * 总结：
         *      时间复杂度和空间复杂度都比较大，
         *      而且关于溢出的问题实际上采用了取巧的方式，并没有严格的判断溢出
         */
        String intStr = String.valueOf(x);
        char[] chars = intStr.toCharArray();
        String newStr = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            newStr = newStr + String.valueOf(chars[i]);
        }
        if (newStr.endsWith("-")) {
            newStr = "-" + newStr.substring(0, newStr.length() - 1);
        }
        Integer result;
        try {
            result = Integer.parseInt(newStr);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return result;

    }

    public int reverse2(int x) {
        /**
         * 方案二（参考）：
         *      把整数当作一个栈，进行出栈，末尾数字先出栈，再相加成为反转后的数字
         *      根据出栈的次数和相加时的临时变量大小进行判断是否溢出
         *      要在没有辅助堆栈 / 数组的帮助下 “弹出” 和 “推入” 数字，我们可以使用数学方法。
         *
         *      //pop operation:
         *      pop = x % 10;
         *      x /= 10;
         *
         *      //push operation:
         *      temp = rev * 10 + pop;
         *      rev = temp;
         *
         * 执行结果：
         * 解答成功:
         * 			执行耗时:1 ms,击败了100.00% 的Java用户
         * 			内存消耗:37.2 MB,击败了5.33% 的Java用户
         */
        int rev = 0;
        while(x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int reverse3(int x) {
        /**
         * 简化：
         * 解答成功:
         * 			执行耗时:1 ms,击败了100.00% 的Java用户
         * 			内存消耗:37.1 MB,击败了5.33% 的Java用户
         */
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
