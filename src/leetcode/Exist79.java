package leetcode;

public class Exist79 {

    int m,n;//记录行和列
    boolean[][] flag;//记录访问过的元素，防止重复访问
    int[][] step={{0,-1},{0,1},{1,0},{-1,0}};//x,y元素向上下左右移动


    public boolean solution(char[][] board,String word){
        //对相关属性进行初始化
        this.m=board.length;
        if(m==0) return false;
        this.n=board[0].length;
        this.flag=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(searchWord(board,word,0,i,j)) return true;
            }
        }
        return false;
    }

    public boolean searchWord(char[][] board,String word,int index,int start_x,int start_y){
        if(index==word.length()-1) return word.charAt(index)==board[start_x][start_y];//达到最后一个元素
        if(board[start_x][start_y]==word.charAt(index)){
            flag[start_x][start_y]=true;//记录一下当前元素已被访问过
            for(int i=0;i<4;i++){
                int newstart_x=start_x+step[i][0];
                int newstart_y=start_y+step[i][1];
                //满足下一步仍合法以及未访问过且找到了元素。返回true
                if(isTrue(newstart_x,newstart_y)&&!flag[newstart_x][newstart_y]&&searchWord(board,word,index+1,newstart_x,newstart_y)) return true;

            }
            flag[start_x][start_y]=false;//取消当前元素访问记录，回溯
        }
        return false;
    }

    //判断当前x与y是否合法
    public boolean isTrue(int x,int y){
        return x>=0&&x<m&&y>=0&&y<n;
    }

}
