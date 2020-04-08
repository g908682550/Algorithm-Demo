package offer;

public class MovingCount13 {
    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] flag;
    int result=0;
    int m,n,k;
    public int solution(int m, int n, int k) {
        this.m=m;this.n=n;this.k=k;
        flag=new boolean[m][n];
        dfs(0,0);
        return result;
    }
    public void dfs(int x,int y){
        flag[x][y]=true;
        result++;
        for(int i=0;i<4;i++){
            int nextX=x+dir[i][0],nextY=y+dir[i][1];
            if(canVisited(nextX,nextY)&&!flag[nextX][nextY]) dfs(nextX,nextY);
        }
    }
    public boolean canVisited(int i,int j){
        if(i<0||i>=m||j<0||j>=n) return false;
        int sum1=0,sum2=0;
        while(i>0){
            sum1+=i%10;
            i/=10;
        }
        while(j>0){
            sum2+=j%10;
            j/=10;
        }
        return sum1+sum2<=k;
    }
}
