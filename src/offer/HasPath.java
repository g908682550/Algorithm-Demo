package offer;

import org.junit.Test;

import java.util.PriorityQueue;

public class HasPath {

    @Test
    public void test(){
//        char[] matrix={'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] matrix={'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str={'a','b','c','c','e','d'};
//        char[] str={'b','c','c','e','d'};
        System.out.println(solution(matrix, 3, 4, str));
        String s1="abcd";
        String s2="ab";
        System.out.println(s1.contains(s2));
    }

    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] visited;
    char[][] rec;
    int R,C;

    public boolean solution(char[] matrix, int rows, int cols, char[] str){
        if(rows==0) return false;
        this.R=rows;
        this.C=cols;
        rec=new char[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                rec[i][j]=matrix[i*C+j];
            }
        }
        String s=new String(str);
        visited=new boolean[R][C];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(find(i,j,s,rec[i][j]+"")) return true;
            }
        }
        return false;
    }

    public boolean find(int i,int j,String s,String curr){
        if(!valid(s,curr)) return false;
        else{
            if(s.length()==curr.length()) return true;
            visited[i][j]=true;
            for(int k=0;k<4;k++){
                int newx=i+dir[k][0],newy=j+dir[k][1];
                if(isTrue(newx,newy)&&!visited[newx][newy]){
                    if(find(newx,newy,s,curr+rec[newx][newy])) return true;
                }
            }
            visited[i][j]=false;
            return false;
        }
    }

    public boolean isTrue(int i,int j){
        return i>=0&&i<R&&j>=0&&j<C;
    }
    public boolean valid(String raw,String curr){
        for(int i=0;i<curr.length();i++){
            if(curr.charAt(i)!=raw.charAt(i)) return false;
        }
        return true;
    }

}
