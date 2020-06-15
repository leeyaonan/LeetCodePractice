//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。 
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。 
//
// 示例 1: 
//
// 输入: "III"
//输出: 3 
//
// 示例 2: 
//
// 输入: "IV"
//输出: 4 
//
// 示例 3: 
//
// 输入: "IX"
//输出: 9 
//
// 示例 4: 
//
// 输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
// 
//
// 示例 5: 
//
// 输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
// Related Topics 数学 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int romanToInt(String s) {
        return this.romanToInt1(s);
    }

    public static final String I = "I";
    public static final String V = "V";
    public static final String X = "X";
    public static final String L = "L";
    public static final String C = "C";
    public static final String D = "D";
    public static final String M = "M";
    public static final HashMap<String, Integer> ROMANS_2_INT = new HashMap<>(){{
        put(I, 1);
        put(V, 5);
        put(X, 10);
        put(L, 50);
        put(C, 100);
        put(D, 500);
        put(M, 1000);
    }};

    public int romanToInt1(String s) {
        /**
         * 方案一：
         *      从右向左顺序读取数字，游标记录当前位置的数字游标
         *      当当前数字右边没有数字，或者右边数字小于等于当前数字时，就加上该数
         *      当当前数字右边数字大于当前数字时，就减去该数字
         * 执行结果：
         * 解答成功:
         * 			执行耗时:9 ms,击败了26.16% 的Java用户
         * 			内存消耗:40.2 MB,击败了5.56% 的Java用户
         */
        char[] chars = s.toCharArray();
        int result = 0;

        int current = chars.length - 1;
        int right = chars.length;

        while(current >= 0) {
            // current是右边第一位数字,直接相加
            if (right > chars.length - 1) {
                result += ROMANS_2_INT.get(String.valueOf(chars[current]));
                right = current--;
            } else {
                if (ROMANS_2_INT.get(String.valueOf(chars[current])) >= ROMANS_2_INT.get(String.valueOf(chars[right]))) {
                    result += ROMANS_2_INT.get(String.valueOf(chars[current]));
                    right = current--;
                }
                else {
                    result -= ROMANS_2_INT.get(String.valueOf(chars[current]));
                    right = current--;
                }
            }
        }

        return result;
    }

    public int getIntByRoman(String roman) {
        if (!ROMANS_2_INT.containsKey(roman)) {
            return 0;
        }
        return ROMANS_2_INT.get(roman);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
