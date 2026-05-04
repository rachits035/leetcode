class Solution {
    public boolean rotateString(String s, String goal) {
         for(int i=0;i<s.length();i++){
            String a=s.substring(0,s.length()-1);
            String b=s.substring(s.length()-1,s.length());
            b=b.concat(a);
            if(b.equals(goal)){
                return true;
            }
            s=b;

        }
        return false;
        
    }
}