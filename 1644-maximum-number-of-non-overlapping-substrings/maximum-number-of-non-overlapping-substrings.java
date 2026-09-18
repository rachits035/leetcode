class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int[][] arr = new int[26][2];

        // Initialize first and last occurrence as -1
        for (int[] ar : arr) {
            Arrays.fill(ar, -1);
        }

        // Find first and last occurrence of every character
        for (int i = 0; i < s.length(); i++) {

            int index = s.charAt(i) - 'a';

            if (arr[index][0] == -1) {
                arr[index][0] = i;
            }

            arr[index][1] = i;
        }

        List<int[]> rangeList = new ArrayList<>();

        // Create and validate ranges
        for (int i = 0; i < 26; i++) {

            // Character doesn't exist
            if (arr[i][0] == -1) {
                continue;
            }

            int start = arr[i][0];
            int end = arr[i][1];

            boolean valid = true;

            // Check all characters inside this range
            for (int j = start; j <= end; j++) {

                int index = s.charAt(j) - 'a';

                // This character appeared before our start
                if (arr[index][0] < start) {
                    valid = false;
                    break;
                }

                // This character occurs after our current end
                if (arr[index][1] > end) {
                    end = arr[index][1];
                }
            }

            if (valid) {
                rangeList.add(new int[]{start, end});
            }
        }

        // Sort according to ending index
        rangeList.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> ans = new ArrayList<>();

        int lasttookVal = -1;

        // Greedy selection
        for (int[] range : rangeList) {

            if (range[0] > lasttookVal) {

                ans.add(s.substring(range[0], range[1] + 1));

                lasttookVal = range[1];
            }
        }

        return ans;
    }
}