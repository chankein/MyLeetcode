import java.util.Arrays;
/*
1. 两数之和:在数组中找到 2 个数之和等于给定值的数字，结果返回 2 个数字在数组中的下标。
*/
public class ArrayTopic {
    public static int[] TwoSum(int [] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int first_num = nums[i];
            for (int j = 0; j < nums.length; j++) {
                int second_num = nums[j];
                if (first_num + second_num == target){
                    System.out.println(first_num);
                    System.out.println(second_num);
                    return new int[]{first_num, second_num};
                }
            }
        }
        return null;
    }
    //有序版，下标为1,2,3...用双指针解法
    public static int[] TwoSumForSortedList(int [] nums, int target) {
        int index_this = 0;
        int index_max = nums.length - 1;
        while (index_this < index_max){
            int two_sum = nums[index_this] + nums[index_max];
            if (two_sum == target){
                return new int[]{index_this + 1,index_max + 1};
            } else if( two_sum < target ){
                ++index_this;
            } else {
                --index_max;
            }
        }
        return null;
    }

/*
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
你可以假设 nums1 和 nums2 不会同时为空。
*/
/*
    public static double findMidian(int [] nums1, int [] nums2) {
        if (nums1.length <= nums2.length){
            return findOrderedMidian(nums1, nums2);
        } else {
            return findOrderedMidian(nums2, nums1);
        }
    }

    public static double findOrderedMidian(int [] nums1, int [] nums2) {
        // nums1.length <= nums2.length
        // nums1 = [x_0,x_1,x_2,...,x_(n-1)]:[0,1,5,7];[7,9,10]
        // nums2 = [y_0,y_1,y_2,...,y_(m-1)]:[2,3,4,6];[1,2,3,4,5]
        //sep_min<=sep_max;
        //sep_min
        //size = n+m
        //if(nums[])
        int nums1_size = nums1.length;
        int nums2_size = nums2.length;
        //数组为空
        if (nums1_size==0) {
            if (nums2_size % 2 == 1){
                return nums2[nums2_size / 2];
            } else {
                return (nums2[nums2_size /2 - 1] + nums2[nums2_size / 2])/2.0;
            }
        } else {
            int k = (nums1_size + nums2_size) / 2;
            
            if ((nums1.length + nums2.length) % 2 == 0){
                //偶数时
                return (getKth(nums1,  nums2, k) + getKth(nums1,  nums2, k + 1)) / 2.0;
            } else {
                //奇数时
                return getKth(nums1,  nums2, k);
            }
        }
        
    }
    //[0,2,4]
    //[1,3,5,7]

    //找第K小元素
    public static double getKth(int[] nums1, int[] nums2,int nums1_left_border,int nums2_left_border, int k,){
        if (nums1.length == 0) {
            System.out.println("log1:");
            System.out.println(nums2[k - 1]);
            System.out.println("====");
            return nums2[k - 1];
        } else if (nums1[k / 2] < nums2[k / 2]) {
            System.out.println("log2:");
            System.out.println(nums1.length + 1);
            
            nums1 = Arrays.copyOfRange(nums1,k/2,nums1.length+1);
            System.out.println("nums1:");
            System.out.println(Arrays.toString(nums1));
            System.out.println("nums1 size:");
            System.out.println(nums1.length);
            System.out.println("k - k/2");
            System.out.println(k - k/2);
            System.out.println("====");
            
            return getKth(nums1,  nums2, k/2);
        } else {
            System.out.println("log3:");
            nums2 = Arrays.copyOfRange(nums2,k/2,nums2.length+1);
            System.out.println(k - k/2);
            System.out.println("====");
            return getKth(nums1,  nums2, k/2);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;  
    }
    
    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1 
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
*/

/*
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。
提示：

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*/
    public static int maxArea(int[] height) {
        int areaSize = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            int this_areaSize = (right-left)*Math.min(height[left],height[right]);
            if (this_areaSize > areaSize){
                    areaSize = this_areaSize;
            }
            if (height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return areaSize;
    }

    public static void main(String[] args) {
        //int nums[] = new int[]{2, 5, 7, 8};
        //TwoSum(nums, 10);
        //System.out.println(TwoSumForSortedList(nums, 10)[0]);
        //System.out.println(TwoSumForSortedList(nums, 10)[1]);
        int nums1[] = new int[]{2, 5, 7, 8};
        int nums2[] = new int[]{6, 9, 10, 11};
        //double result = findOrderedMidian(nums1, nums2);
        //System.out.println(result);

        int height[]= new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }


}

