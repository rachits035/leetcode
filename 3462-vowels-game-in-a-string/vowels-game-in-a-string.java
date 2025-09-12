class Solution {
    public boolean doesAliceWin(String s) {
        int countofvovels=0;
        int countofconsonents=0;
        Set<Character> s1=new HashSet<>();
        s1.add('a');s1.add('e');s1.add('i');
        s1.add('o');s1.add('u');s1.add('A');s1.add('E');s1.add('I');s1.add('O');s1.add('U');
        for(int i=0;i<s.length();i++){
            if(s1.contains(s.charAt(i))){
                countofvovels++;
            }else{
                countofconsonents++;
            }
        }
        if(countofvovels==s.length()){
            return true;
        }
        if(countofvovels==0){
            return false;
        }
        return true;
        
    }
}