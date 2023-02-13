package cmh.study;

import java.util.Arrays;

public class MethodDemo {
    public static void main(String[] args) {
        sum();//可以不传参数
        sum(10);//可以传一个参数
        sum(10,20,30,40);//可以传多个参数
        sum(new int[]{10,20,30,40});//可以传数组
    }
    public static void sum(int...numbers){
        //numbers为一个数组
        System.out.println("数组长度"+numbers.length);
        System.out.println("数组内的元素有"+ Arrays.toString(numbers));
    }
}
