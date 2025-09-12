class Solution {
    public String sortVowels(String s) {
        List<Character> temp=new ArrayList<>();
        char [] arr=s.toCharArray();
        Set<Character> s1=new HashSet<>();
        s1.add('a');
        s1.add('e');
        s1.add('i');
        s1.add('o');
        s1.add('u');
        s1.add('A');
        s1.add('E');
        s1.add('I');
        s1.add('O');
        s1.add('U');
        for(int i=0;i<s.length();i++){
            if(s1.contains(s.charAt(i))){
                temp.add(s.charAt(i));
            }
        }
        Collections.sort(temp);
        int x=0;
        System.out.println(temp);
        for(int i=0;i<s.length();i++){
            if(s1.contains(arr[i])){
                arr[i]=temp.get(x);
                x++;
            }
        }
        return new String(arr);
        
    }
}