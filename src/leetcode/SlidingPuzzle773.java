package leetcode;

import org.junit.Test;

import java.util.*;

public class SlidingPuzzle773 {

    @Test
    public void test(){
        int[][] board={{1,2,3},{4,5,0}};
        solution(board);
    }


    Map<List<Integer>,Integer> map=new HashMap<>();

    /**
     * 图的广度优先遍历
     * @param board
     * @return
     */
    public int solution(int[][] board){
        List<Integer> result=new ArrayList<>(Arrays.asList(1,2,3,4,5,0));
        int m=board.length,n=board[0].length;
        Queue<List<Integer>> queue=new LinkedList<>();
        List<Integer> first=new ArrayList<>();
        int[][] move={{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};//每个位置的0可以交换的位置
        for(int i=0;i<2;i++)
            for(int j=0;j<3;j++)
                first.add(board[i][j]);
        if(first.equals(result)) return 0;
        queue.offer(first);
        map.put(first,0);
        while(!queue.isEmpty()){
            List<Integer> curr=queue.poll();
            int record=-1;
            for(int i=0;i<curr.size();i++) if(curr.get(i)==0) record=i;
            Set<List<Integer>> nexts=new HashSet<>();//求下一个可能出现的状态
            int[] swap=move[record];
            for(int i=0;i<swap.length;i++){
                int num=swap[i];
                Collections.swap(curr,num,record);
                nexts.add(new ArrayList<>(curr));
                Collections.swap(curr,num,record);
            }
            //遍历所有可能的状态
            for(List<Integer> next:nexts){
                if(!map.containsKey(next)){//如果该状态之前出现过，不用重新入队
                    map.put(next,map.get(curr)+1);
                    queue.offer(next);
                    if(next.equals(result)) return map.get(next);
                }
            }
        }
        return -1;

    }

}
