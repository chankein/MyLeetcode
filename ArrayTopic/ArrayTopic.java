
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
    public static int findMidian(int [] nums1, int [] nums2) {
        if (nums1 <= nums2){
            return findorderedMidian(nums1, nums2);
        } else {
            return findorderedMidian(nums2, nums1);
        }
    }

    public static int findOrderedMidian(int [] nums1, int [] nums2) {
        // nums1.length <= nums2.length
        // nums1 = [x_0,x_1,x_2,...,x_(n-1)]:[0,1,5,7]
        // nums2 = [y_0,y_1,y_2,...,y_(m-1)]:[2,3,4,6]
        //sep_min<=sep_max;
        //sep_min
        //size = n+m
        //if(nums[])
        if (nums1.length==0) {
            if (nums2.length % 2 == 1){
                return nums2[nums2.length/2]
            } else {
                return (nums2[nums2.length/2 - 1] + nums2[nums2.length/2])/2.0
            }
        } else {
            int sep_nums1 = nums1.length/2;
            int sep_nums2 = nums2.length/2;
            if(nums1[sep_nums1] <= nums2[sep_nums2])
            if ((nums1.length + nums2.length) % 2 == 0){
                //偶数时
            } else {
                //奇数时
            }
            


            if (nums1[sep_nums1] < nums2[sep_nums2] && nums1[sep_nums1 + 1] > nums2[sep_nums2]){
                return nums1[sep_nums1];
            }
        }
        
    }



    public static void main(String[] args) {
        int nums[] = new int[]{2, 5, 7, 8};
        TwoSum(nums, 10);
        System.out.println(TwoSumForSortedList(nums, 10)[0]);
        System.out.println(TwoSumForSortedList(nums, 10)[1]);
    }


}



