package cmh.excecise.ui;

import java.util.Scanner;

import static cmh.excecise.ui.LoginPage.login;
import static cmh.excecise.ui.LoginPage.register;

public class HomePage {
    static Scanner scanner = new Scanner(System.in);
    public static void homePage() {
        while (true) {
            System.out.println("��ѡ���¼����ע�᣺1����¼ 2��ע��");
            int choice = scanner.nextInt();
            if (choice == 1) {
                login();
            } else if (choice == 2) {
                register();
            } else {
                System.out.println("����ָ���������������룺1,��¼ 2��ע��");
            }
        }
    }
}
