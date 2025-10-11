class Solution {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        Map<Integer,Integer> map = new HashMap<>();
        for (int p : power) {
            map.put(p, map.getOrDefault(p,0)+1);
        }
        long[] memo = new long[power.length];
        Arrays.fill(memo, -1);

        return helper(0, power, map, memo);
    }

    public long helper(int ind, int[] arr, Map<Integer,Integer> mp, long[] memo) {
        if (ind >= arr.length) return 0;
        if (memo[ind] != -1) return memo[ind];

        int val = arr[ind];
        int num = mp.get(val);

        int next = upperBound(arr, val + 2, ind + num); 
        long take = (long) val * num + helper(next, arr, mp, memo);
        long leave = helper(ind + num, arr, mp, memo);

        memo[ind] = Math.max(take, leave);
        return memo[ind];
    }

    public int upperBound(int[] arr, int val, int start) {
        int end = arr.length - 1;
        int ans = arr.length;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] > val) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
