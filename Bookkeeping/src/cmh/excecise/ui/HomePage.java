package cmh.excecise.ui;

import java.util.Scanner;

import static cmh.excecise.ui.LoginPage.login;
import static cmh.excecise.ui.LoginPage.register;

public class HomePage {
    static Scanner scanner = new Scanner(System.in);
    public static void homePage() {
        while (true) {
            System.out.println("请选择登录或者注册：1：登录 2：注册");
            int choice = scanner.nextInt();
            if (choice == 1) {
                login();
            } else if (choice == 2) {
                register();
            } else {
                System.out.println("输入指令有误，请重新输入：1,登录 2，注册");
            }
        }
    }
}
