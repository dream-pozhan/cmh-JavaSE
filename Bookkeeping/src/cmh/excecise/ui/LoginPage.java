package cmh.excecise.ui;

import cmh.excecise.Start;
import cmh.excecise.model.Account;
import cmh.excecise.storage.UserInformationStorage;
import java.util.Scanner;

import static cmh.excecise.ui.OperatePage.operatePage;

public class LoginPage {
    static Scanner scanner = new Scanner(System.in);
    public static void register() {
        System.out.println("����������˻����룺");
        String registerNumber = scanner.next();
        System.out.println("����������˻�����");
        String registerPassword = scanner.next();
        UserInformationStorage.addAccount(registerNumber, registerPassword);
        System.out.println("ע��ɹ�!");
        login();
    }
    public static void login() {
        while (true) {
            System.out.println("�������˻����룺");
            String numberNow = scanner.next();
            System.out.println("�������˻����룺");
            String passwordNow = scanner.next();
            Account loginAccount = UserInformationStorage.getAccount(numberNow);
            if (loginAccount == null) {
                System.out.println("�˻����������벻��ȷ");
                break;
            }
            boolean loginSuccess = loginAccount.getPassword().equals(passwordNow);
            if (loginSuccess) {
                //����Start����currentAccount
                Start.currentAccount = loginAccount;
                System.out.println("��¼�ɹ�");
                operatePage();
            }

        }
    }
}
