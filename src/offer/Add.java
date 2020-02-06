package offer;

public class Add {

    public int solution(int num1,int num2){
        while(num2!=0){
            int temp=num1^num2;//两数相加（无进位）
            num2=(num1&num2)<<1;//求进位
            num1=temp;
        }
        return num1;
    }

}
