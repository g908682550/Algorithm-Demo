package code_test;

import java.util.*;

/**
 * 给一个长度为n(1<n<100000)的只包含'0','1'的字符串，其中'00'字符串可以变为'10','10'字符串可以变为'01',求当前字符串代表的二进制数能获得的最大值。
 */
public class HuaWei2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        for(int i=0;i<T;i++){
            int n=scanner.nextInt();
            scanner.nextLine();
            String curr=scanner.nextLine();
            if(n==1) {
                System.out.println(curr);
                continue;
            }
            String result=count(curr);
            System.out.println(result);
        }
    }

    public static String count(String curr){
        Queue<String> queue=new PriorityQueue<>((curr1,curr2)->{
            for(int i=0;i<curr1.length();i++){
                if(curr1.charAt(i)==curr2.charAt(i)) continue;
                else return curr2.charAt(i)=='1'?1:-1;
            }
            return 0;
        });
        Queue<String> next=new LinkedList<>();
        next.add(curr);
        queue.add(curr);
        while(!next.isEmpty()){
            String a=next.poll();
            Set<String> set=next(a);
            next.addAll(set);
            queue.addAll(set);
        }
        return queue.peek();
    }

    public static Set<String> next(String curr){
        char a=curr.charAt(0),b=curr.charAt(1);
        Set<String> set=new HashSet<>();
        int len=curr.length();
        if(len==2){
            if(a=='0'&&b=='0') set.add("10");
            return set;
        }else{
            for(int i=2;i<len;i++){
                a=curr.charAt(i-2);
                b=curr.charAt(i-1);
                char c=curr.charAt(i);
                if(a=='0'&&b=='0')
                    set.add(curr.substring(0,i-2)+"10"+curr.substring(i,len));
                if(b=='0'&&c=='0')
                    set.add(curr.substring(0,i-1)+"10"+curr.substring(i+1,len));
                if(a=='0'&&b=='1'&&c=='0')
                    set.add(curr.substring(0,i-2)+"101"+curr.substring(i+1,len));
            }
        }
        return set;
    }
}

