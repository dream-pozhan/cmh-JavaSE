package cmh.excecise.ui;

import java.util.Scanner;

public class HomePage {
    static Scanner scanner = new Scanner(System.in);

    public HomePage() {
        init();
    }

    public void init() {
        while (true) {
            new TextHint("请选择登录或者注册：1：登录 2：注册");
            int choice = scanner.nextInt();
            if (choice == 1) {
                new LoginPage();
            } else if (choice == 2) {
                new RegisterPage();
            } else {
                new TextHint("输入指令有误，请重新输入：1,登录 2，注册");
            }
        }

    }


}
