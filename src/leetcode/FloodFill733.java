package leetcode;

public class FloodFill733 {

    boolean[][] flag;
    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    int oldColor,newColor,m,n;

    /**
     * dfs
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        m=image.length;
        if(m==0) return image;
        n=image[0].length;
        if(n==0) return image;
        this.newColor=newColor;
        this.oldColor=image[sr][sc];
        flag=new boolean[m][n];
        helper(image,sr,sc);
        return image;
    }


    public void helper(int[][] image,int i,int j){
        if(image[i][j]!=oldColor) return;
        else{
            image[i][j]=newColor;
            flag[i][j]=true;
            for(int k=0;k<4;k++){
                int newX=i+dir[k][0],newY=j+dir[k][1];
                if(isTrue(newX,newY)&&!flag[newX][newY]) helper(image,newX,newY);
            }
        }
    }

    public boolean isTrue(int x,int y){
        return x>=0&&x<m&&y>=0&&y<n;
    }

}
