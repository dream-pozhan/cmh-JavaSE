package cmh.api.studydemo;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("�������·ݣ�1-12��:");
        int month = sc.nextInt();
        System.out.println("������������λ:");
        String type = sc.next();
        System.out.println("�������Ʊԭ��:");
        double money = sc.nextDouble();
        double rs = calc(month,type,money);
        System.out.println("�Żݺ�ļ۸��ǣ�"+rs);
    }

    public static double calc(int month,String type,double money){
        if(month >=5 && month <=10){
            switch (type){
                case "���ò�" :
                    money= money*0.85;
                    break;
                case "ͷ�Ȳ�" :
                    money = money*0.9;
                    break;
                default:
                    System.out.println("��ѡ�����λ�������������룡");
                    return -1;
            }
            return money;
        }else if (month == 11 || month == 12 ||month >=1 && month <= 4 ){
            switch (type){
                case "���ò�" :
                    money = money*0.65;
                    break;
                case "ͷ�Ȳ�" :
                    money = money*0.7;
                    break;
                default:
                    System.out.println("��ѡ�����λ�������������룡");
                    return -1;
            }
            return money;
        }else {
            System.out.println("��������·��������������룡");
            return -1;
        }
    }
}
