package cmh.excecise.ui;

import cmh.excecise.Start;
import cmh.excecise.model.Account;
import cmh.excecise.storage.UserInformationStorage;

import java.util.Scanner;

import static cmh.excecise.ui.OperatePage.operatePage;

public class RegisterPage {
    static Scanner scanner = new Scanner(System.in);

    public RegisterPage() {
        init();
    }

    public void init(){
        System.out.println("����������˻����룺");
        String registerNumber = scanner.next();
        System.out.println("����������˻�����");
        String registerPassword = scanner.next();
        UserInformationStorage.addAccount(registerNumber, registerPassword);
        System.out.println("ע��ɹ�!");


    }

}
