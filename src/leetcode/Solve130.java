package leetcode;

import org.junit.Test;

public class Solve130 {

    @Test
    public void test(){
        char[][] chars={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solution(chars);
    }

    int m,n;
    int[][] step={{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] flag;

    /**
     * 从边缘'O'开始遍历，所有能遍历到的O都标记为'#'，随后再进行一次整体遍历，标记到的为'#',未标记到的即为'X'
     * @param board
     */
    public void solution(char[][] board){
        m=board.length;
        if(m==0) return;
        n=board[0].length;
        flag=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>0&&i<m-1&&j>0&&j<n-1) continue;
                if(board[i][j]=='O'){
                    mark(board,i,j);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='#') board[i][j]='O';
                else board[i][j]='X';
            }
        }
        return;
    }

    public void mark(char[][] board,int x,int y){
        if(board[x][y]=='X'||board[x][y]=='#') return;
        if(board[x][y]=='O'){
            board[x][y]='#';
            flag[x][y]=true;
            for(int i=0;i<4;i++){
                int newX=x+step[i][0];
                int newY=y+step[i][1];
                if(isTrue(newX,newY)&&!flag[newX][newY]) mark(board,newX,newY);
            }
            flag[x][y]=false;
        }
        return;
    }

    public boolean isTrue(int x,int y){
        return x>=0&&x<m&&y>=0&&y<n;
    }

}
