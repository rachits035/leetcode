class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4)
            return false;

        int p = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                p = i;
            } else {
                break;
            }
        }

        if (p == 0)
            return false;

        int q = -1;

        for (int j = p + 1; j < n; j++) {
            if (nums[j] < nums[j - 1]) {
                q = j;
            } else {
                break;
            }
        }

        if (q == -1)
            return false;

        for (int j = q + 1; j < n; j++) {
            if (nums[j] <= nums[j - 1]) {
                return false;
            }
        }

        if (q == n - 1)
            return false;

        return true;
    }
}
