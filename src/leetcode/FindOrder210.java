package leetcode;

import org.junit.Test;

import java.util.*;

public class FindOrder210 {

    @Test
    public void test(){
        int[][] nums={{1,0},{2,0},{3,1},{3,2}};
        solution(4,nums);
    }

    /**
     * 建图后处理好入度出度关系
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] solution(int numCourses, int[][] prerequisites){
        HashSet<Integer>[] graph=new HashSet[numCourses];
        int[] indeg=new int[numCourses];
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<numCourses;i++) graph[i]=new HashSet<Integer>();
        for(int[] nums:prerequisites){
            int a=nums[0],b=nums[1];
            graph[b].add(a);
            indeg[a]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0)
                queue.add(i);
        }
        while(!queue.isEmpty()){
            int curr=queue.poll();
            result.add(curr);
            for(int num:graph[curr]){
                indeg[num]--;
                if(indeg[num]==0) queue.add(num);
            }
        }
        if(result.size()<numCourses) return new int[]{};
        int[] temp=new int[numCourses];
        for(int i=0;i<numCourses;i++) temp[i]=result.get(i);
        return temp;
    }

}
