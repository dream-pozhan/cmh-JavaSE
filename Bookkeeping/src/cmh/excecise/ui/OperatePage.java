package cmh.excecise.ui;

import java.util.Scanner;

import static cmh.excecise.Start.*;

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
                    summarizeMonthIncomeAndExpense();
                    break;
                case 2:
                    remark();
                    break;
                case 3:
                    new HomePage();
                    break;
                default:
                    System.out.println("�����ָ���������������룡");

            }
        }

    }
}
