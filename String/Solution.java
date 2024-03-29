import java.util.*;

/*
13. 罗马数字转整数
罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个罗马数字，将其转换成整数。 
*/
class Solution {
    private int getValue(char ch) {
            switch(ch) {
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
                default: return 0;
            }
    }
    public int romanToInt(String s) {
        int result = 0;
        int string_size=s.length();
        Map<Character,Integer> hashmapdict = Map.of('I',1, 'V',5 ,'X',10, 'L',50, 'C',100, 'D',500, 'M',1000);
        for (int i=0;i<string_size;i++){
            char ch = s.charAt(i);
            int tran_num = getValue(ch);
            if(i+1 < string_size && tran_num<getValue(s.charAt(i+1))){
                result -= tran_num;
                    continue;
            }
            result += tran_num;
        }
        return result;
    }

/*
28. 实现 strStr()
实现 strStr() 函数。

给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。

说明：

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
*/
    //暴力版
    public int strStr(String haystack, String needle) {
        boolean hasFound = false;
        int needle_size = needle.length();
        if(needle_size==0){
            return 0;
        }
        int result = -1;
        int total_size = haystack.length();
        for (int i=0;i<total_size - needle_size + 1;i++){
            int j = 0;
            for (j=0;j < needle_size;j++){
                if(haystack.charAt(i + j) == needle.charAt(j)){
                }else{
                    break;
                }
            }
            if(j==needle_size){
                return i;
            }
        }
        return result;
    }

    /*KMP版
    haystack为被搜索的字符串，被搜索的字符串指针为i
    needle需要搜索的字符串，指针为j
    理解KMP有两点:
    1,什么是PMT,(Partial Match Table),是一个needle各字符的索引和一个回退值,当haystack[i]!=needle[j]时，j回退到哪个index再比较
    2,PMT值怎么来的，是最大相同前后缀的长度，比如说[abcdabcfch]那么他的子字符串[abcdabc]来说，[0:3],[4:7]已经匹配相同,PMT值为3(即i指针只需和j=3的位置比较)
    3,PMT的计算，以[abcdabcfch]为例：
        初始i=0,j=1；
        比较needle[i]和needle[j],相等时,next[j]=next[i]+1;不相等时,再比较needle[j]和needle[inext[j-1]]，一直循环，
        原理是不断假设下一个最大相同后缀加一相同，如果不相同，再从下一个最大相同后缀的位置比较
    4,快速构建Next数组:比较needle[i],比较needle[i],
    */

    //构建Next数组
     private int[] GetNext(String needle){
        int needle_size = needle.length();
        int[] next =new int[needle_size];
        next[1]=0;
        for (int i = 1, j = 0; i < needle_size; i++){
            while(j>0 && needle.charAt(i)!=needle.charAt(j)){
                j=next[i-1];
            }
            if(j==0 || needle.charAt(i)==needle.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
    public int strStr(String haystack, String needle) {
        int needle_size = needle.length();
        if(needle_size==0){
            return 0;
        }
        int[] next = GetNext(needle);
        int result = -1;
        int total_size = haystack.length();
        for (int i = 0, j = 0;i < total_size;i++){
            while (j>0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j-1];
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j==needle_size){
                return i-j+1;
            }
        }
        return result;
    }


/*
383. 赎金信
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

如果可以，返回 true ；否则返回 false 。

magazine 中的每个字符只能在 ransomNote 中使用一次。
*/
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counter = new int[26];
        for (int i=0;i< magazine.length(); i++){
            counter[magazine.charAt(i)-'a'] += 1;
        }
        for (int i=0;i< ransomNote.length(); i++){
            counter[ransomNote.charAt(i)-'a'] -= 1;
            if(counter[ransomNote.charAt(i)-'a']<0){
                return false;
            }
        } 
        return true;
    }
/*
67. 二进制求和
给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。
*/
    public String addBinary(String a, String b) {
        int x = a.length(); 
        int y = b.length();
        StringBuffer result = new StringBuffer();
        int carry = 0;
        char n = '1';
        for (int i = x-1, j = y-1;i>-1 || j>-1;i--,j--){
            int sum = carry;
            carry = 0;
            sum += (i > -1? a.charAt(i) - '0' : 0);
            sum += (j > -1? b.charAt(j) - '0' : 0);
            result.append(sum%2);
            carry=(sum > 1?1:0);
        }
        if(carry>0){
            result.append('1');
        } 
        return result.reverse().toString();
    }


/**
3. 无重复字符的最长子串
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。


示例 1:

输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
    public static int lengthOfLongestSubstring(String s) {
        int max_sum = 0;
        int s_size = s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        if (s_size < 2){
            return s_size;
        }
        for (int left = 0,right =0 ;right < s_size;right++){
            if(map.containsKey(s.charAt(right))){
                left=Math.max(left, map.get(s.charAt(right))+1);
            }
            map.put(s.charAt(right),right);
            max_sum = Math.max(max_sum, right -left+1);
        }
        return max_sum;
    }
}
public static void main(String[] args) {
    //Solution.romanToInt('XXVII');
    Solution.lengthOfLongestSubstring("abba");
}