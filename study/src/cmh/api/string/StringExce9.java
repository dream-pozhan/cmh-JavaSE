package cmh.api.string;

import java.util.Scanner;

public class StringExce9 {
    public static void main(String[] args) {
        //����¼��һ���ֻ���
        Scanner sc = new Scanner(System.in);
        System.out.println("�������������ֻ��ţ�");
        String tel = sc.next();

        //��ȡ�ֻ�����ǰ��λ�ͺ���λ
        String before = tel.substring(0,3);
        String after = tel.substring(7);

        String telephone = before+"****"+after;

        System.out.println(telephone);
    }
}
