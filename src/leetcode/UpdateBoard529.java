package leetcode;

public class UpdateBoard529 {

    char[][] board;
    int[][] dir={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    int m,n;

    public char[][] solution(char[][] board,int[] click){
        this.board=board;
        this.m=board.length;
        this.n=board[0].length;
        int x=click[0],y=click[1];
        if(board[x][y]>='1'&&board[x][y]<='8') return board;
        if(board[x][y]=='M'){
            board[x][y]='X';
            return board;
        }
        if(board[x][y]=='E') {
            dfs(x,y);
        }
        return board;
    }

    public void dfs(int i,int j){
        char c=count(i,j);
        if(c>='1'){
            board[i][j]=c;
            return;
        }
        board[i][j]='B';
        for(int k=0;k<8;k++){
            int nextX=i+dir[k][0],nextY=j+dir[k][1];
            if(isTrue(nextX,nextY)&&board[nextX][nextY]=='E') dfs(nextX,nextY);
        }
    }

    public char count(int i,int j){
        int res=0;
        for(int k=0;k<8;k++){
            int nextX=i+dir[k][0],nextY=j+dir[k][1];
            if(isTrue(nextX,nextY)&&board[nextX][nextY]=='M') res++;
        }
        return (char)(res+48);
    }

    public boolean isTrue(int i,int j){
        return i>=0&&i<m&&j>=0&j<n;
    }

}
