package code_test;

import java.util.*;

public class HuaWei3 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[][] grid=new int[9][9];
        for(int i=0;i<9;i++){
            String[] split = scanner.nextLine().substring(1, 18).split(",");
            for(int j=0;j<9;j++) grid[i][j]=Integer.parseInt(split[j]);
        }
        Set<Integer>[] ASet=new HashSet[9];
        Set<Integer>[] BSet=new HashSet[9];
        Set<Integer>[] CSet=new HashSet[9];
        for(int i=0;i<9;i++) {
            ASet[i]=new HashSet<>();
            BSet[i]=new HashSet<>();
            CSet[i]=new HashSet<>();
        }
        for(int i=0;i<9;i++){
            for(int num:grid[i]) ASet[i].add(num);
        }
        for(int j=0;j<9;j++){
            for(int i=0;i<9;i++) BSet[j].add(grid[i][j]);
        }
        int count=0;
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                for(int x=i;x<i+3;x++){
                    for(int y=j;y<j+3;y++){
                        CSet[count].add(grid[x][y]);
                    }
                }
                count++;
            }
        }
        count=0;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                for(int x=i;x<i+3;x++){
                    set.clear();
                    for(int y=j;y<j+3;y++){
                        if(grid[x][y]!=0) continue;
                        set.addAll(ASet[x]);
                        set.addAll(BSet[y]);
                        set.addAll(CSet[count]);
                        for(int k=1;k<=9;k++){
                            if(!set.contains(k)) {
                                grid[x][y]=k;
                                break;
                            }
                        }
                    }
                }
                count++;
            }
        }
        for(int i=0;i<9;i++){
            System.out.print("{");
            for(int j=0;j<9;j++){
                if(j!=8) System.out.print(grid[i][j]+",");
                else System.out.print(grid[i][j]);
            }
            System.out.print("}");
            System.out.println();
        }
    }
}
