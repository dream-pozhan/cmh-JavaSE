package cmh.api.string;

import java.util.Scanner;

public class StringExce7 {
    public static void main(String[] args) {
        //������ȷ�ĵ�¼��������
        String okLoginName = "admin";
        String okPassword = "itheima";
        //����һ��ѭ����ѭ�����Σ����û���¼
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <3 ; i++) {
            System.out.println("���������¼���ƣ�");
            String name = sc.next();
            System.out.println("�����������룺");
            String password = sc.next();

            //�ж��˻������Ƿ���ȷ
            if (okLoginName.equals(name)){
                if (okPassword.equals(password)){
                    System.out.println("��½�ɹ���");
                    break;
                }else{
                    System.out.println("�������,������"+(3-i)+"�λ��ᣡ");
                }
            }else{
                System.out.println("�˻������ڣ���������"+(3-i)+"�λ��ᣡ");
            }
        }
    }

}
