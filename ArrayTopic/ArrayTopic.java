import java.util.*;
/*
1,两数之和
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

*/
public class ArrayTopic {
    public static int[] TwoSum(int [] nums, int target) {
        Map<Integer,Integer> hashmap = new HashMap<Integer,Integer>();

        int left = 0;
        int right = nums.length - 1;
        for  (int i = 0; i < nums.length; ++i){
            if(hashmap.containsKey(target-nums[i])){
                return new int[]{i,hashmap.get(target-nums[i])};
            }
            hashmap.put(nums[i],i);
        }
        
        return new int[0];
    }

/*
4. 寻找两个正序数组的中位数
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。
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
11. 盛最多水的容器
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

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

/*
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。
 */
     public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<String> added_result = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            int x = nums[i];
            int left = i + 1;
            int right = nums.length -1;
            
            if (x > 0 && x == nums[left]){continue;}
            while (left < right ){
                if(x + nums[left] + nums[right] == 0){
                String founded_result = Integer.toString(x) + '_' + Integer.toString(nums[left]);
                if (!added_result.contains(founded_result)){
                        List<Integer> element = new ArrayList<>();
                        element.add(x);
                        element.add(nums[left]);
                        element.add(nums[right]);
                        result.add(element);
                        added_result.add(founded_result);
                        ++left;
                    } else{
                    ++left;
                    continue;
                    }
                
                } else if (x + nums[left] + nums[right] > 0){
                    --right;
                } else{
                    ++left;
                }
            }
        }
        return result;
    }

/*
16. 最接近的三数之和
给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。

返回这三个数的和。

假定每组输入只存在恰好一个解。
 */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest_num = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length -1;
            while (left < right){
                int this_result = nums[i] + nums[left] + nums[right];
                if(this_result == target){
                    return target;
                } 
                if(this_result > target){
                    right--;
                } else{
                    left++;
                }
                if(Math.abs(this_result-target)<Math.abs(closest_num-target)){
                    closest_num=this_result;
                }
            }
        }
        return closest_num;
    }
/*
1480. 一维数组的动态和
给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。

请返回 nums 的动态和。
*/
    public int[] runningSum(int[] nums) {
        int nums_size = nums.length;
        int[] result = new int[nums_size];
        int sum=0;
        for (int i=0;i<nums_size;i++){
            sum += nums[i];
            result[i]=sum;
        }
        return result;
    }

/*
26. 删除有序数组中的重复项
给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。

由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。

将最终结果插入 nums 的前 k 个位置后返回 k 。

不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

判题标准:

系统会用下面的代码来测试你的题解:

int[] nums = [...]; // 输入数组
int[] expectedNums = [...]; // 长度正确的期望答案

int k = removeDuplicates(nums); // 调用

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
如果所有断言都通过，那么您的题解将被 通过。
 */
    public int removeDuplicates(int[] nums) {
        if ((nums==null) || (nums.length==0)){
            return 0;
        }
        int count = 0;
        int i = 0;
        for (int j=1;j <nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
                count += 1;
            }
        }
        return count+1;
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
        //System.out.println(maxArea(height));

        int numsThreeSum[] = new int[] {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(numsThreeSum);
        System.out.println(result.toString());

        
    }


}

