package offer;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class reversePrint06 {

    public int[] solution(ListNode head){
        List<Integer> list=new ArrayList<>();
        while(head!=null) {
            list.add(0,head.val);
            head=head.next;
        }
        int[] result=new int[list.size()];
        for(int i=0;i<list.size();i++) result[i]=list.get(i);
        return result;
    }

}
