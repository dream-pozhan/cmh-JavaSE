package cmh.api.math;

public class MathDemo {
    public static void main(String[] args) {
        //取绝对值，返回正数
        System.out.println(Math.abs(10));//10
        System.out.println(Math.abs(-10.3));//10.3
        //向上取整：5
        System.out.println(Math.ceil(6.000001));//7
        //向下取整：4
        System.out.println(Math.floor(4.99999));//4
        //求指数次方
        System.out.println(Math.pow(2,3));//8
        //四舍五入
        System.out.println(Math.round(4.4999999));//4
        System.out.println(Math.round(4.5000001));//5
        //0-9的随机数（拓展）
        System.out.println(Math.random());
        int data = (int)(Math.random()*7+3);
        System.out.println(data);
    }
}
