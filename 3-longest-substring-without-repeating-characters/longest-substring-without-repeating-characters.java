class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int ans=0;
        Set<Character> ch=new HashSet<>();
        while(j<s.length()){
            if(!ch.contains(s.charAt(j))){
                ch.add(s.charAt(j));
                ans=Math.max(ans,j-i+1);
                j++;
            }else{
                ch.remove(s.charAt(i));
                i++;

            }

        }
        return ans;

    }
}