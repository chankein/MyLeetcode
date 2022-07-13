
/*
1. 两数之和:在数组中找到 2 个数之和等于给定值的数字，结果返回 2 个数字在数组中的下标。
*/
public class ArrayTopic {
    public static int[] TwoSum(int [] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int this_key = nums[i];
            for (int j = 0; j < nums.length; j++) {
                int this_value = nums[j];
                if (this_key + this_value == target){
                    System.out.println(this_key);
                    System.out.println(this_value);
                    return new int[]{this_key, this_value};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{2, 5, 7, 8};
        TwoSum(nums, 10);
    }

}



