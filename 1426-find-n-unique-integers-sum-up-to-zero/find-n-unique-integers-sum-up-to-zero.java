class Solution {
    public int[] sumZero(int n) {
        if (n==1) return new int[]{0};
        if(n==2) return new int[]{-1,1};
        if(n==3) return new int[]{-1,0,1};
        int [] ans=new int[n];
        int temp=((n-1)*n)/2;
        for(int i=1;i<n;i++){
            ans[i]=i;
        }
        ans[0]=-temp;
        return ans;
        
    }
}