package cmh.excecise.ui;

import java.util.Scanner;

public class HomePage {
    static Scanner scanner = new Scanner(System.in);

    public HomePage() {
        init();
    }

    public void init() {
        while (true) {
            new TextHint("��ѡ���¼����ע�᣺1����¼ 2��ע��");
            int choice = scanner.nextInt();
            if (choice == 1) {
                new LoginPage();
            } else if (choice == 2) {
                new RegisterPage();
            } else {
                new TextHint("����ָ���������������룺1,��¼ 2��ע��");
            }
        }

    }


}
