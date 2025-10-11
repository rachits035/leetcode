class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int [] ans=new int[k];
        for(int i=0;i<energy.length;i++){
            int ind=i%k;
            ans[ind]=Math.max(energy[i],ans[ind]+energy[i]);
        }
        int f=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            f=Math.max(f,ans[i]);
        }
        return f;
        
    }
}