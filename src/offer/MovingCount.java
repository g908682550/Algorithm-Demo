package offer;

public class MovingCount {

    int[][] dir={{0,1},{0,-1},{-1,0},{1,0}};
    boolean[][] canvisited;
    boolean[][] visited;
    int R,C,threshold;

    /**
     * floodFill算法
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int solution(int threshold, int rows, int cols){
        this.R=rows;
        this.C=cols;
        this.threshold=threshold;
        int result=0;
        visited=new boolean[R][C];
        canvisited=new boolean[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(canVisited(i,j)) canvisited[i][j]=true;
            }
        }
        return helper(0,0);
    }

    public int helper(int i,int j){
        if(!canvisited[i][j]) return 0;
        int res=1;
        visited[i][j]=true;
        for(int k=0;k<4;k++){
            int newx=i+dir[k][0];
            int newy=j+dir[k][1];
            if(canVisited(newx,newy)&&!visited[newx][newy]) res+=helper(newx,newy);
        }
        return res;
    }

    public boolean canVisited(int i,int j){
        if(i<0||i>=R||j<0||j>=C) return false;
        int sum1=0,sum2=0;
        while(i>0){
            sum1+=i%10;
            i/=10;
        }
        while(j>0){
            sum2+=j%10;
            j/=10;
        }
        return sum1+sum2<=threshold;
    }

}
