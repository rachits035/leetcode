import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        List<Set<Integer>> temp = new ArrayList<>();
        for (int i = 0; i < languages.length; i++) {
            temp.add(new HashSet<>());
        }
        for (int i = 0; i < languages.length; i++) {
            for (int j = 0; j < languages[i].length; j++) {
                temp.get(i).add(languages[i][j]);
            }
        }

        
        Set<Integer> needTeach = new HashSet<>();
        for (int i = 0; i < friendships.length; i++) {
            int first = friendships[i][0] - 1;
            int second = friendships[i][1] - 1;
            Set<Integer> s1 = temp.get(first);
            Set<Integer> s2 = temp.get(second);

            boolean pre = Intersection(s1, s2);
            if (!pre) { 
              
                needTeach.add(first);
                needTeach.add(second);
            }
        }

        if (needTeach.isEmpty()) return 0;

        int[] count = new int[n + 1];  
        for (int person : needTeach) {
            for (int lang : temp.get(person)) {
                count[lang]++;
            }
        }

        int maxAlreadyKnow = 0;
        for (int lang = 1; lang <= n; lang++) {
            maxAlreadyKnow = Math.max(maxAlreadyKnow, count[lang]);
        }

        return needTeach.size() - maxAlreadyKnow;
    }

    public boolean Intersection(Set<Integer> s1, Set<Integer> s2) {
        for (int i : s1) {
            if (s2.contains(i)) {
                return true;
            }
        }
        return false;
    }
}
