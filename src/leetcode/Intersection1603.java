package leetcode;

import org.junit.Test;

import java.util.*;
public class Intersection1603 {

    @Test
    public void test(){
        int[] start1={-10,48},end1={-43,46},start2={-16,59},end2={-1,85};
        System.out.println(Arrays.toString(solution(start1, end1, start2, end2)));
    }

    public double[] solution(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1=start1[0],x2=end1[0],y1=start1[1],y2=end1[1];
        int x3=start2[0],x4=end2[0],y3=start2[1],y4=end2[1];
        double k1=(x1==x2?-Double.MAX_VALUE:(double)(y2-y1)/(x2-x1));
        double k2=(x3==x4?-Double.MAX_VALUE:(double)(y4-y3)/(x4-x3));
        double b1,b2;
        if(k1==-Double.MAX_VALUE&&k2==-Double.MAX_VALUE){
            if(x1!=x3) return new double[]{};
            else{
                Set<Integer> set=new HashSet<>();
                if(y1<y2){
                    for(int i=y1;i<=y2;i++) set.add(i);
                }else{
                    for(int i=y2;i<=y1;i++) set.add(i);
                }
                if(y3<y4){
                    for(int i=y3;i<=y4;i++) if(set.contains(i)) return new double[]{x1,i};
                }else{
                    for(int i=y4;i<=y3;i++) if(set.contains(i)) return new double[]{x1,i};
                }
            }
        }else if(k1==-Double.MAX_VALUE||k2==-Double.MAX_VALUE){
            if(k1==-Double.MAX_VALUE){
                b2=y3-k2*x3;
                double target=x1*k2+b2;
                if((target>=y1&&target<=y2)||(target>=y2&&target<=y1)) return new double[]{x1,target};
            }else{
                b1=y1-k1*x1;
                double target=x3*k1+b1;
                if((target>=y3&&target<=y4)||(target>=y4&&target<=y3)) return new double[]{x3,target};
            }
        }
        b1=y1-k1*x1;
        b2=y3-k2*x3;
        if(k1!=k2){
            double x=(b1-b2)/(k2-k1);
            double y=x*k1+b1;
            if(((x>=x1&&x<=x2)||(x>=x2&&x<=x1))&&((x>=x3&&x<=x4)||(x>=x4&&x<=x3))) return new double[]{x,y};
        }else{
            if(b1!=b2) return new double[]{};
            else{
                Set<String> set=new HashSet<>();
                if(x1<x2){
                    for(int i=x1;i<=x2;i++) set.add(i+"&"+i*k1+b1);
                }else{
                    for(int i=x2;i<=x1;i++) set.add(i+"&"+i*k1+b1);
                }
                if(x3<x4){
                    for(int i=x3;i<=x4;i++) if(set.contains(i+"&"+i*k2+b2)) return new double[]{i,i*k2+b2};
                }else{
                    for(int i=x4;i<=x3;i++) if(set.contains(i+"&"+i*k2+b2)) return new double[]{i,i*k2+b2};
                }
            }
        }
        return new double[]{};
    }

}
