class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        //transverse of matrix
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //reverse the array row wise
        for(int [] ar:matrix){
            int i=0;
            int j=ar.length-1;
            while(i<j){
                int temp=ar[i];
                ar[i]=ar[j];
                ar[j]=temp;
                i++;
                j--;
            }
        }
        
       
        
    }
}