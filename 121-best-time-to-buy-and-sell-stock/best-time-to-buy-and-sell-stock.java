class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [] min=new int[n];
        int m=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(prices[i]<m){
                m=prices[i];
                
            }
            min[i]=m;
        }
        int ans=0;
        // System.out.println(Arrays.toString(min));
        for(int i=0;i<n;i++){
            int cur=prices[i]-min[i];
            ans=Math.max(ans,cur);

        }
        return ans;
        
    }
}