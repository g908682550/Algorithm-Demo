package leetcode;

import org.junit.Test;

import java.util.*;

public class SortItems1203 {

    @Test
    public void test(){
        int[] group={0,0,2,1,0};
        List<List<Integer>> beforeItems=new ArrayList<>();
        for(int i=0;i<5;i++) beforeItems.add(new ArrayList<>());
        beforeItems.get(0).add(3);
        beforeItems.get(4).add(1);
        beforeItems.get(4).add(3);
        beforeItems.get(4).add(2);
        int[] res=solution(5,3,group,beforeItems);
        System.out.println(Arrays.toString(res));
    }

    public int[] solution(int n, int m, int[] group, List<List<Integer>> beforeItems){
        List<Integer>[] groupItem=new ArrayList[m+n];
        List<Integer>[] groupGraph=new ArrayList[m+n];
        List<Integer>[] itemGraph=new ArrayList[n];
        for(int i=0;i<m+n;i++){
            groupItem[i]=new ArrayList<>();
            groupGraph[i]=new ArrayList<>();
            if(i<n) itemGraph[i]=new ArrayList<>();
        }
        int curr=m;
        for(int i=0;i<n;i++){
            if(group[i]==-1){
                group[i]=curr;
                curr++;
            }
            groupItem[group[i]].add(i);
        }
        List<Integer> ids=new ArrayList<>();
        for(int i=0;i<m+n;i++) ids.add(i);
        int[] groupDes=new int[m+n];
        int[] itemDes=new int[n];
        for(int i=0;i<n;i++){
            int currGroupId=group[i];
            for(int item:beforeItems.get(i)){
                int beforeGroupId=group[item];
                if(currGroupId==beforeGroupId){
                    itemDes[i]++;
                    itemGraph[item].add(i);
                }else{
                    groupDes[currGroupId]++;
                    groupGraph[beforeGroupId].add(currGroupId);
                }
            }
        }
        int index=0;
        int[] res=new int[n];
        List<Integer> graphSorted=topSort(groupDes,groupGraph,ids);
        if(graphSorted==null) return new int[]{};
        for(int i=0;i<graphSorted.size();i++){
            List<Integer> currItemSorted=topSort(itemDes,itemGraph,groupItem[graphSorted.get(i)]);
            if(currItemSorted==null) return new int[]{};
            for(int num:currItemSorted){
                res[index++]=num;
            }
        }
        return res;
    }

    public List<Integer> topSort(int[] des,List<Integer>[] graph,List<Integer> items){
        List<Integer> res=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        for(int num:items){
            if(des[num]==0){
                queue.add(num);
            }
        }
        while(!queue.isEmpty()){
            int top=queue.poll();
            res.add(top);
            for(int v:graph[top]){
                if(--des[v]==0){
                    queue.add(v);
                }
            }
        }
        return res.size()==items.size()?res:null;
    }

}
