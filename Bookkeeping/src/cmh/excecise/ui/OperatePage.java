package cmh.excecise.ui;

import java.util.Scanner;

import static cmh.excecise.Start.*;
import static cmh.excecise.ui.HomePage.homePage;

public class OperatePage {
    static Scanner scanner = new Scanner(System.in);
    public static void operatePage() {
        System.out.println("++++����ҳ��+++++");
        while (true) {
            System.out.println("��ѡ����Ĳ�����0-��¼ÿ��֧����ÿ������,1-ͳ����֧����������,2-��ע,3-�˳�");
            int command = scanner.nextInt();
            switch (command) {
                case 0:
                    signDailyIncomeAndExpense();
                    break;
                case 1:
                    addMonthIncomeAndExpense();
                    break;
                case 2:
                    remark();
                    break;
                case 3:
                    homePage();
                    break;
                default:
                    System.out.println("�����ָ���������������룡");

            }
        }

    }
}
