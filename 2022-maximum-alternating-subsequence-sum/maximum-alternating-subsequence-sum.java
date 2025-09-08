import java.util.*;

class Solution {
    Long[][] memo;

    public long maxAlternatingSum(int[] nums) {
        memo = new Long[nums.length][2];
        return helper(0, nums, 0);
    }

    public long helper(int ind, int[] nums, int parity) {
        if (ind >= nums.length) return 0;

        if (memo[ind][parity] != null) return memo[ind][parity];

        long take, skip;

        if (parity == 0) {
            take = nums[ind] + helper(ind + 1, nums, 1);
        } else {  
            take = -nums[ind] + helper(ind + 1, nums, 0);
        }
        skip = helper(ind + 1, nums, parity);
        return memo[ind][parity] = Math.max(take, skip);
    }
}
