class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String [] arr=text.split(" ");
        Set<Character> set=new HashSet<>();
        for(int i=0;i<brokenLetters.length();i++){
            set.add(brokenLetters.charAt(i));
        }
        int ans=arr.length;
        for(int i=0;i<arr.length;i++){
            String s=arr[i];
            for(int j=0;j<s.length();j++){
                if(set.contains(s.charAt(j))){
                    ans=ans-1;
                    break;
                }
            }
        }
        return ans;

        
    }
}