package cmh.api.string;

import java.util.Scanner;

public class StringExce9 {
    public static void main(String[] args) {
        //键盘录入一个手机号
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入您的手机号：");
        String tel = sc.next();

        //截取手机号码前三位和后四位
        String before = tel.substring(0,3);
        String after = tel.substring(7);

        String telephone = before+"****"+after;

        System.out.println(telephone);
    }
}
