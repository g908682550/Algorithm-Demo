package code_test;
import java.util.*;
import java.text.*;
public class OrderDistribute {
    static double[][] A;
    static int N;
    static double max=0.0;
    static List<Integer> result;
    static boolean[] visited;
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextInt();
        A=new double[N][N];
        visited=new boolean[N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                A[i][j]=scanner.nextDouble();
            }
        }
        helper(new ArrayList<>(),0.0,0);
        DecimalFormat df=new DecimalFormat("#.00");
        System.out.println(df.format(max));
        for(int i=0;i<N;i++){
            System.out.print(i+1+" ");
            System.out.println(result.get(i)+1);
        }
    }

    public static void helper(List<Integer> list,double sum,int index){
        if(index==N){
            if(sum>max){
                max=sum;
                result=new ArrayList<>(list);
            }
        }
        for(int i=0;i<N;i++){
            if(visited[i]==true){
                continue;
            }
            visited[i]=true;
            list.add(i);
            sum+=A[index][i];
            helper(list,sum,index+1);
            list.remove(list.size()-1);
            sum-=A[index][i];
            visited[i]=false;
        }
    }

}
