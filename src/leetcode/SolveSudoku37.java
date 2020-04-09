package leetcode;

public class SolveSudoku37 {
    boolean[][] row=new boolean[9][10];
    boolean[][] col=new boolean[9][10];
    boolean[][] grid=new boolean[9][10];
    public void solution(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int num=board[i][j]-48;
                    row[i][num]=true;
                    col[j][num]=true;
                    grid[(i/3)*3+j/3][num]=true;
                }
            }
        }
        dfs(board,0,0);
    }
    public boolean dfs(char[][] board,int i,int j){
        while(board[i][j]!='.'){
            if(j++==8){
                i++;
                j=0;
            }
            if(i==9) return true;
        }
        for(int k=1;k<=9;k++){
            if(row[i][k]||col[j][k]||grid[(i/3)*3+j/3][k]) continue;
            char c=(char)(k+48);
            row[i][k]=true;
            col[j][k]=true;
            grid[(i/3)*3+j/3][k]=true;
            board[i][j]=c;
            if(dfs(board,i,j)) return true;
            row[i][k]=false;
            col[j][k]=false;
            grid[(i/3)*3+j/3][k]=false;
            board[i][j]='.';

        }
        return false;
    }

}
