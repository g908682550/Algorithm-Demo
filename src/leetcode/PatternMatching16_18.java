package leetcode;

import org.junit.Test;

public class PatternMatching16_18 {

    @Test
    public void test(){
        String pattern="abba",value="dogcatcatdog";
        System.out.println(solution(pattern, value));
    }

    public boolean solution(String pattern, String value) {
        int count_a=0,count_b=0;
        for(char c:pattern.toCharArray()){
            if(c=='a') count_a++;
            else count_b++;
        }
        if(count_a<count_b){
            int temp=count_a;
            count_a=count_b;
            count_b=temp;
            StringBuilder builder=new StringBuilder();
            for(char c:pattern.toCharArray()) builder.append(c=='a'?'b':'a');
            pattern=builder.toString();
        }
        if(value.length()==0) return count_b==0;
        if(pattern.length()==0) return false;
        for(int len_a=0;len_a*count_a<=value.length();len_a++){
            int rest=value.length()-len_a*count_a;
            if((count_b==0&&rest==0)||(count_b>0&&rest%count_b==0)){
                int len_b=(count_b==0?0:rest/count_b),pos=0;
                boolean flag=true;
                String value_a="",value_b="";
                for(char c:pattern.toCharArray()){
                    if(c=='a'){
                        String sub=value.substring(pos,pos+len_a);
                        if(value_a.isEmpty()) value_a=sub;
                        else if(!value_a.equals(sub)){
                            flag=false;
                            break;
                        }
                        pos+=len_a;
                    }else{
                        String sub=value.substring(pos,pos+len_b);
                        if(value_b.isEmpty()) value_b=sub;
                        else if(!value_b.equals(sub)){
                            flag=false;
                            break;
                        }
                        pos+=len_b;
                    }
                }
                if(flag&&value_a!=value_b) return true;
            }
        }
        return false;
    }

}
