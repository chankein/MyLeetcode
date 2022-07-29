class Solution {
/**
7. 整数反转
给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。
 

示例 1：

输入：x = 123
输出：321
示例 2：

输入：x = -123
输出：-321
示例 3：

输入：x = 120
输出：21
示例 4：

输入：x = 0
输出：0
*/
    public int reverse(int x) {
        int res =0;
        while (x!=0){
            int tmp = x % 10;
            if(res<-214748364 || res>214748364 ){
                return 0;
            }
            res = res*10 + tmp;
            x = x/10;
        }
        return res;
    }
/*
9. 回文数
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

例如，121 是回文，而 123 不是。
 

示例 1：

输入：x = 121
输出：true
示例 2：

输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3：

输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。
 
*/
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        String x_str = Integer.toString(x);
        int s_length = x_str.length();
        for (int i=0; i<s_length/2;i++){
            if(x_str.charAt(i)!=x_str.charAt(s_length-i-1)){
                return false;
            }
        }
        return true;
    }

/**
168. Excel表列名称
给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。

例如：

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 
*/
    public String convertToTitle(int columnNumber) {
    int res = columnNumber;
    StringBuffer an = new StringBuffer();
    while (res > 0){
        int a0 = (res - 1) % 26 + 1;
        an.append((char)(a0 - 1 + 'A'));
        res = (res-a0)/26;
    }
    an.reverse();
    return an.toString();
    }

/**
171. Excel 表列序号
给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。

例如：

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

示例 1:

输入: columnTitle = "A"
输出: 1
示例 2:

输入: columnTitle = "AB"
输出: 28
示例 3:

输入: columnTitle = "ZY"
输出: 701
 
 */
    public int titleToNumber(String columnTitle) {
        int this_size = columnTitle.length();
        int an = 0;
        for (int i=this_size;i>0;i--){
            int this_num = columnTitle.charAt(i-1)-'A'+1;
            an += this_num*Math.pow(26,this_size-i);
        }
        return an;
    }
}