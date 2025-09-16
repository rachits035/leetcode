class Solution {
    public int maxFreqSum(String s) {
        Map<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        int max_Vovel=0;
        int Max_Consonent=0;
        for(char ch:mp.keySet()){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                if(mp.get(ch)>max_Vovel){
                    max_Vovel=mp.get(ch);
                }
            }else{
                if(mp.get(ch)>Max_Consonent){
                    Max_Consonent=mp.get(ch);
                }
            }
        }
        return Max_Consonent+max_Vovel;
    }
}