class Solution {
    public String intToRoman(int num) {
        StringBuilder str=new StringBuilder();
        int [] arr={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String [] code={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i=0;i< arr.length;i++){
            while(num>=arr[i]){
                str.append(code[i]);
                num=num-arr[i];
            }
        }
       
        return str.toString();
        
    }
}