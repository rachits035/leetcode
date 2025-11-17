class Solution {
    static int [][] dir={{1,0},{0,1},{-1,0},{0,-1}}; 
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int c=image[sr][sc];
        helper(image,sr,sc,color,c);
        return image;
        
    }
    public void helper(int [][] image,int i,int j,int color,int c){
        if(i>=image.length||i<0||j>=image[0].length||j<0||image[i][j]!=c||image[i][j]==color){
            return;
        }
        image[i][j]=color;
        for(int x=0;x<dir.length;x++){
            int i_=i+dir[x][0];
            int j_=j+dir[x][1];
            helper(image,i_,j_,color,c);

        }


    }
}