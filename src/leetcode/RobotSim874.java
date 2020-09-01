package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RobotSim874 {

    @Test
    public void solution(){
        int[] commands={4,-1,3};
        int[][] obstacles={};
        int i = robotSim(commands, obstacles);
        System.out.println(i);
    }


    public int robotSim(int[] commands, int[][] obstacles) {
        int result=0,x=0,y=0;
        int[][] right_rotation={{0,1},{1,0},{0,-1},{-1,0}};
        int[][] left_rotation={{0,1},{-1,0},{0,-1},{1,0}};
        Set<String> set=new HashSet<>();
        for(int[] nums:obstacles){
            set.add(nums[0]+"&"+nums[1]);
        }
        int[] direction={0,1};
        for(int i=0;i<commands.length;i++){
            int num=commands[i];
            if(num==-1){
                for(int k=0;k<right_rotation.length;k++){
                    if(Arrays.equals(right_rotation[k], direction)){
                        direction=right_rotation[(k+1)%4];
                        break;
                    }
                }
            }else if(num==-2){
                for(int k=0;k<left_rotation.length;k++){
                    if(Arrays.equals(left_rotation[k], direction)){
                        direction=left_rotation[(k+1)%4];
                        break;
                    }
                }
            }else{
                while(num>0){
                    int nextX=x+direction[0],nextY=y+direction[1];
                    if(set.contains(nextX+"&"+nextY)) break;
                    x=nextX;
                    y=nextY;
                    result=Math.max(result,x*x+y*y);
                    num--;
                }
            }
        }

        return result;

    }

}
