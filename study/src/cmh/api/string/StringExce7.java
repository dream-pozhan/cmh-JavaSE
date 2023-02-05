package cmh.api.string;

import java.util.Scanner;

public class StringExce7 {
    public static void main(String[] args) {
        //定义正确的登录名和密码
        String okLoginName = "admin";
        String okPassword = "itheima";
        //定义一个循环，循环三次，让用户登录
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <3 ; i++) {
            System.out.println("请您输入登录名称：");
            String name = sc.next();
            System.out.println("请您输入密码：");
            String password = sc.next();

            //判断账户密码是否正确
            if (okLoginName.equals(name)){
                if (okPassword.equals(password)){
                    System.out.println("登陆成功！");
                    break;
                }else{
                    System.out.println("密码错误,您还有"+(3-i)+"次机会！");
                }
            }else{
                System.out.println("账户不存在！，您还有"+(3-i)+"次机会！");
            }
        }
    }

}
