package cmh.excecise.ui;

import cmh.excecise.storage.UserInformationStorage;

import java.util.Scanner;

public class RegisterPage {
    static Scanner scanner = new Scanner(System.in);

    public RegisterPage() {
        init();
    }

    public void init() {
        System.out.println("����������˻����룺");
        String registerNumber = scanner.next();
        System.out.println("����������˻�����");
        String registerPassword = scanner.next();
        UserInformationStorage.addAccount(registerNumber, registerPassword);
        System.out.println("ע��ɹ�!");


    }

}
