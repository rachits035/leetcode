class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int [] ans=new int[spells.length];
        int k=0;
        for(int i=0;i<spells.length;i++){
            int start=0;
            int end=potions.length-1;
            int ind=-1;
            while(start<=end){
                int mid=(start+end)/2;
                if((long)spells[i]*(long)potions[mid]>=success){
                    ind=mid;
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
            if(ind==-1){
                ans[k++]=0;
            }
            else{
                ans[k++]=potions.length-ind;
            }
            

        }
        
        return ans;
        
    }
}