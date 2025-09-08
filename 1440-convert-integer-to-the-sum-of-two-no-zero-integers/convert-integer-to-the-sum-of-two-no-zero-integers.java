class Solution {
    public int[] getNoZeroIntegers(int n) {
        int [] ans=new int[2];
        for(int i=1;i<n;i++){
            if(isgood(i)&&isgood(n-i)){
                ans[0]=i;
                ans[1]=n-i;
            }

        }
        return ans;
        
    }
    boolean isgood(int a){
        while(a>0){
            int rem=a%10;
            if(rem==0){
                return false;
            }
            a/=10;
        }
        return true;


    }
}