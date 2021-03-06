/*
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
*/

//如果不用多次查找，可以用一个int sum不断累加，一旦sum<0，从下一个数开始重新累加sum


//如果需要反复查询最有效
//找array或者matrix的sub最长、最短、最大、最小，都应该用hashmap把值存起来，才可以做到时间复杂度最小
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums==null || nums.length==0) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if (map.containsKey(sum-k)) {
                int index = map.get(sum-k);
                maxLen = Math.max(maxLen, i-index); //这里就是i-index，不用再+1，因为index的值本来就比实际值小1
            }
        }
        return maxLen==Integer.MIN_VALUE? 0 : maxLen;
    }
}
