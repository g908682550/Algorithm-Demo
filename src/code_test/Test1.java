package code_test;
import java.util.*;
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] nums=new int[n][2];
        for(int i=0;i<n;i++){
            nums[i][0]=scanner.nextInt();
            nums[i][1]=scanner.nextInt();
        }
        Arrays.sort(nums,(a,b)->(a[0]+a[1])-(b[0]+b[1]));
        int start=nums[0][0];
        for(int i=0;i<n;i++){
            int dif=(nums[i][1]-nums[i][0])/2+1;
            if(start>(nums[i][1]-dif)){
                System.out.println(-1);
                return;
            }
            if(start<nums[i][0]) start=nums[i][0];
            start=start+dif;
        }
        System.out.println(1);
    }
}
