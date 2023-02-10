package cmh.regex;

import java.util.Scanner;

public class RegexDemo {
    public static void main(String[] args) {
        //checkNumber();\
        checkEmail();
    }
    public static void checkEmail(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请您输入邮箱信息:");
            String emailNumber = scanner.next();
            if (emailNumber.matches("\\w{1,30}@[0-9a-zA-z]{2,10}(\\.[a-zA-Z0-9]{2,20}){1,2}")){
                System.out.println("校验通过，注册成功~~");
            }else{
                System.out.println("校验失败，注册失败~~");
            }
        }
    }
    public static void checkNumber(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请您输入电话号码：");
            String phoneNumber = sc.next();
            if (phoneNumber.matches("1[3-9]\\d{9}")) {
                System.out.println("号码校验通过，注册成功~~");
                break;
            } else {
                System.out.println("号码校验不通过，注册失败~~");
            }
        }
    }

}
