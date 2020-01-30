package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SolveQueens51 {

    int n;//摆放的皇后总数
    int[] flag;//摆放方式，下标表示第几行，值代表第几列
    List<List<String>> result=new ArrayList<>();
    boolean[] col;//记录当前列是否被占用
    boolean[] dia1;//记录当前的左下到左上的对角线是否被占用
    boolean[] dia2;//记录当前的左上到右下的对角线是否被占用

    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        flag=new int[n];
        col=new boolean[n];
        dia1=new boolean[2*n-1];
        dia2=new boolean[2*n-1];
        putQueen(flag,0);
        return result;
    }

    /**
     * 递归与回溯方法
     * @param flag
     * @param index
     */
    public void putQueen(int[] flag,int index){
        if(index==n){
            result.add(build(flag));
            return;
        }
        for(int i=0;i<n;i++){
            if(!col[i]&&!dia1[index+i]&&!dia2[index-i+n-1]){//列，对角线均未被占用才可进行
                col[i]=true;
                dia1[index+i]=true;
                dia2[index-i+n-1]=true;
                flag[index]=i;
                putQueen(flag,index+1);
                col[i]=false;
                dia1[index+i]=false;
                dia2[index-i+n-1]=false;
            }
        }
        return;
    }

    /**
     * 构建方法
     * @param flag
     * @return
     */
    public List<String> build(int[] flag){
        StringBuilder s=new StringBuilder();
        List<String> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int j=flag[i];
            s.delete(0,s.length());
            for(int k=0;k<j;k++) s.append(".");
            s.append("Q");
            for(int k=j+1;k<n;k++) s.append(".");
            list.add(s.toString());
        }
        return list;
    }
}
