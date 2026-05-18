import java.util.*;

class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1) {
            return 0;
        }

        // value -> all indices having that value
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int curr = q.poll();

                // reached end
                if (curr == n - 1) {
                    return steps;
                }

                // left
                if (curr - 1 >= 0 && !visited[curr - 1]) {

                    visited[curr - 1] = true;
                    q.offer(curr - 1);
                }

                // right
                if (curr + 1 < n && !visited[curr + 1]) {

                    visited[curr + 1] = true;
                    q.offer(curr + 1);
                }

                // same value jumps
                if (map.containsKey(arr[curr])) {

                    for (int next : map.get(arr[curr])) {

                        if (!visited[next]) {

                            visited[next] = true;
                            q.offer(next);
                        }
                    }

                    // VERY IMPORTANT
                    map.remove(arr[curr]);
                }
            }

            steps++;
        }

        return -1;
    }
}