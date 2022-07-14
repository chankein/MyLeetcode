
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


    public static void main(String[] args) {
        int nums[] = new int[]{2, 5, 7, 8};
        TwoSum(nums, 10);
        System.out.println(TwoSumForSortedList(nums, 10)[0]);
        System.out.println(TwoSumForSortedList(nums, 10)[1]);
    }


}



