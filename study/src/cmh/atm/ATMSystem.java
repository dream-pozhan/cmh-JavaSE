package cmh.atm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        //1,�����˻���
        //2,����һ�����������������Ժ�洢ȫ�����û����󣬽�����ص�ҵ�����
        ArrayList<Account> accounts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        //3.չʾϵͳ��ҳ
        while (true) {
            System.out.println("**********����ATMϵͳ**********");
            System.out.println("1���˻���¼");
            System.out.println("2���˻�����");
            System.out.println("����ѡ�������");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    //�û���¼����
                    login(accounts,sc);
                    break;
                case 2:
                    //�û���������
                    register(accounts,sc);
                    break;
                default:
                    System.out.println("������Ĳ����������~~");
            }
        }

    }

    /**
     * ��¼����
     * @param accounts �����˻�����ļ���
     * @param sc ɨ����
     */
    private static void login(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("**********�û���¼����*********");
        //1���ж��Ƿ�����˻�����������ڣ���Ҫ��ע�ᣬ���ܵ�¼
        if (accounts.size() == 0){
            System.out.println("�Բ��𣬵�ǰϵͳ�����κ��˻������ȿ�����");
            return;//�����Է��
        }
        //2,��ʽ�����¼����
        while (true) {
            System.out.println("���������¼���ţ�");
            String cardId = sc.next();
            //3���жϿ����Ƿ���ڣ����ݿ���ȥ�˻��������ѯ�˻�����
            Account accountnow = getAccountByCardId(cardId,accounts);
            if (accountnow != null){
                while (true) {
                    //���Ŵ���
                    //4,���û��������룬��֤����
                    System.out.println("���������¼���룺");
                    String password = sc.next();
                    //�ж��˻�����������Ƿ������������һ��
                    if (accountnow.getPassword().equals(password)){
                        //��½�ɹ���
                        System.out.println("��ϲ����"+accountnow.getUserName()+"����/Ůʿ����ϵͳ�����Ŀ����ǣ�"+accountnow.getCardId());
                        //��ѯ��ת�ˣ�ȡ��
                        //չʾ��½��Ĳ���ҳ
                        showUserCommand(sc,accountnow,accounts);
                        return;//������ǰ����
                    }else {
                        System.out.println("�Բ������������������~~");
                    }
                }
            }else {
                System.out.println("�Բ���ϵͳ�в����ڸ��˻�����~~");
            }
        }
    }

    /**
     * չʾ��¼��Ĳ���ҳ
     */
    private static void showUserCommand(Scanner sc, Account acc, ArrayList<Account> accounts) {
        while (true) {
            System.out.println("**********�û�����ҳ*********");
            System.out.println("1,��ѯ�˻�");
            System.out.println("2,���");
            System.out.println("3,ȡ��");
            System.out.println("4,ת��");
            System.out.println("5,�޸�����");
            System.out.println("6,�˳�");
            System.out.println("7,ע���˻�");
            System.out.println("��ѡ��");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    //��ѯ�˻�(չʾ��ǰ�˻���Ϣ)
                    showAccount(acc);
                    break;
                case 2:
                    //���
                    deposiMoney(sc,acc);
                    break;
                case 3:
                    //ȡ��
                    drawMoney(acc,sc);
                    break;
                case 4:
                    //ת��
                    transferMoney(acc,sc,accounts);
                    break;
                case 5:
                    //�޸�����
                    updatePassword(sc,acc);
                    return;
                case 6:
                    //�˳�
                    System.out.println("�˳��ɹ�����ӭ�´ι���~~");
                    return;//������ǰ����
                case 7:
                    //ע���˻�
                    if (deleteAccount(sc,acc,accounts)){
                        return;
                    }else {
                        break;
                    }

                default:
                    System.out.println("������Ĳ��������ȷ~~");
            }
        }

    }

    /**
     * ��������
     * @param sc
     * @param accountnow
     * @param accounts
     */
    private static boolean deleteAccount(Scanner sc, Account accountnow, ArrayList<Account> accounts) {
        System.out.println("**********�û���������*********");
        System.out.println("�����Ҫ�����˻���y/n");
        String resoult = sc.next();
        switch (resoult){
            case "y":
                if (accountnow.getMoney()>0){
                    System.out.println("�����˻��л������޷�����~~");
                }else{
                    accounts.remove(accountnow);
                    System.out.println("�����ɹ�~~");
                    return true;
                }
            default:
                System.out.println("�˻���������~~");
        }
        return false;
    }

    /**
     * �޸��������
     * @param sc ɨ����
     * @param accountnow ��ǰ�˻�����
     */
    private static void updatePassword(Scanner sc, Account accountnow) {
        System.out.println("**********�û��޸��������*********");
        while (true) {
            System.out.println("�������������");
            String password = sc.next();
            //У�������Ƿ���ȷ
            if (accountnow.getPassword().equals(password)){
                while (true) {
                    System.out.println("�����������룺");
                    String okpassworrd = sc.next();
                    System.out.println("���ٴ����������룺");
                    String oKpassword = sc.next();
                    if (okpassworrd.equals(oKpassword)){
                        System.out.println("�����޸ĳɹ�~~");
                        accountnow.setPassword(oKpassword);
                        return;
                    }else {
                        System.out.println("�������벻һ�£�����������~~");
                    }
                }
            }else {
                System.out.println("�����������������~~");
            }
        }
    }

    /**
     * ת�˲���
     * @param accountnow ��ǰ��¼���˻�
     * @param sc ɨ����
     * @param accounts �����˻��ļ���
     */
    private static void transferMoney(Account accountnow, Scanner sc, ArrayList<Account> accounts) {
        System.out.println("**********�û�ת�˲���*********");
        //�ж��Ƿ��㹻�����˻�
        if (accounts.size() < 2){
            System.out.println("�Բ���ϵͳ���˻������������޷�����ת�ˣ���ȥ����~~");
            return;
        }
        //�ж��˻��շ���Ǯ
        if (accountnow.getMoney() == 0){
            System.out.println("���Լ���û��Ǯ�ˣ��ͱ�ת����~~");

        }
        //������ʼת��
        while (true) {
            System.out.println("��������Է����ţ�");
            String cardId = sc.next();

            //�жϿ��Ų������Լ��Ŀ���
            if (accountnow.getCardId().equals(cardId)){
                System.out.println("�Բ��������ܸ��Լ�����ת�ˣ�");
                continue;
            }

            //�жϿ����Ƿ���ڣ����ݶԷ�����ȥ���˻�����
            Account account = getAccountByCardId(cardId,accounts);
            if (account == null){
                System.out.println("�Բ���������Ŀ��Ų����ڣ�");
            }else{
                //�Է��˻����ڣ���֤����
                String userName = account.getUserName();
                String tip = "*"+userName.substring(1);
                System.out.println("��������["+tip+"]������");
                String preName = sc.next();

                //��֤�����Ƿ�������ȷ
                if (userName.startsWith(preName)){
                    while (true) {
                        //��֤�ɹ�����ʼת��
                        System.out.println("��������ת�˽�");
                        double money = sc.nextDouble();
                        //�жϽ�Ǯ�Ƿ��㹻
                        if (money > accountnow.getMoney()){
                            System.out.println("�Բ�������������ת"+accountnow.getMoney()+"Ԫ~~");
                        }else {
                            //ת�˳ɹ�
                            accountnow.setMoney(accountnow.getMoney() - money);
                            account.setMoney(account.getMoney()+money);
                            System.out.println("ת�˳ɹ�������˻����Ϊ��"+accountnow.getMoney());
                            return;
                        }
                    }
                }else{
                    System.out.println("�Բ������������Ϣ����~~");
                }


            }
        }

    }

    /**
     * ȡǮ����
     * @param accountNow ��ǰ��¼�˻�
     * @param sc ɨ����
     */
    private static void drawMoney(Account accountNow, Scanner sc) {
        System.out.println("**********�û�ȡǮ����*********");
        //1���ж��Ƿ�100Ԫ
        if (accountNow.getMoney()<100){
            System.out.println("�Բ��𣬵�ǰ�˻�����100Ԫ������ȡǮ��");
            return;
        }
        //2,��ʾ����ȡ����
        System.out.println("��������ȡ���");
        double money = sc.nextDouble();

        //3,�жϽ���Ƿ�����Ҫ��
        if (money > accountNow.getQuotaMoney()){
            System.out.println("�Բ���������ȡ�����ÿ��ȡ���޶ÿ������ȡ��"+accountNow.getQuotaMoney());
        }else {
           //û�г����޶�
            //4���ж��Ƿ񳬹��˻������
            if(money > accountNow.getMoney()){
                System.out.println("���㣬����ǰ��������ǣ�"+accountNow.getMoney());
            }else{
                //����ȡǮ��
                System.out.println("��ϲ����ȡǮ"+money+"�ɹ�");
                //�������
                accountNow.setMoney(accountNow.getMoney()-money);
                //ȡǮ������չʾ�����˻���Ϣ
                showAccount(accountNow);

            }
        }
    }

    /**
     * ��Ǯ
     * @param sc ɨ����
     * @param accountnow ��ǰ�˻�����
     */
    private static void deposiMoney(Scanner sc, Account accountnow) {
        System.out.println("**********�û���Ǯ����*********");
        System.out.println("����������");
        double  money = sc.nextDouble();

        //�����˻���ԭ����Ǯ+�����Ǯ
        accountnow.setMoney(accountnow.getMoney()+money);
        System.out.println("��ϲ������Ǯ�ɹ����˻���Ϣ���£�");
        showAccount(accountnow);
    }


    /**
     * չʾ�˻���Ϣ
     * @param accountnow
     */
    private static void showAccount(Account accountnow) {
        System.out.println("**********��ǰ�˻���Ϣ����*********");
        System.out.println("���ţ�"+accountnow.getCardId());
        System.out.println("������"+accountnow.getUserName());
        System.out.println("��"+accountnow.getMoney());
        System.out.println("�޶"+accountnow.getQuotaMoney());
    }

    /**
     * �û��������ܵ�ʵ��
     * @param accounts ���ܵ��˻��ļ���
     */
    private static void register(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("**********�û���������*********");
        //1,����һ���˻��������ں��ڷ�װ�˻���Ϣ
        Account account = new Account();
        //2,¼�뵱ǰ������˻���Ϣ��ע�뵽�˻�������ȥ
        System.out.println("���������˻��û�����");
        String userName = sc.next();
        account.setUserName(userName);

        while (true) {
            System.out.println("�������˻����룺");
            String password = sc.next();
            System.out.println("��ȷ���˻����룺");
            String okpassword = sc.next();
            if (okpassword.equals(password)){
                //������֤ͨ����ע�������
                account.setPassword(okpassword);
                //�����ͨ����ֹͣ��ѭ��
                break;
            }else{
                System.out.println("�Բ�����������������벻һ�£�����������~~~~");
            }
        }
        System.out.println("�������뵱��ȡ���޶");
        double quoteMoney = sc.nextDouble();
        account.setQuotaMoney(quoteMoney);

        //Ϊ�˻����һ����λ�Ҳ��ظ��Ŀ���(������һ������)
        String cardId = getRandomCardId(accounts);
        account.setCardId(cardId);

        //3,���˻�������ӵ��˻�������ȥ
        accounts.add(account);
        System.out.println("��ϲ��"+userName+"����/Ůʿ,�������ɹ������Ŀ����ǣ�"+cardId+"���������Ʊ��ܿ��ţ�");
    }

    /**
     * �˻�����8λ�����������������Ų�ͬ
     * @return
     */
    private static String getRandomCardId(ArrayList<Account> accounts) {
        //1,������8λ����
        Random r = new Random();
        while (true) {
            String cardId = "";
            for (int i = 0; i < 8; i++) {
                cardId += r.nextInt(10);
            }

            //2���жϴ��˻������Ƿ��������˻������ظ�
            //�����������ȥ��ѯ�˻�����
            Account acc = getAccountByCardId(cardId, accounts);
            if (acc == null) {
                //˵�����Ų��ظ���������Ϊ��ע����˻�����
                return cardId;
            }
        }
    }


    /**
     * ���ݿ��Ų�ѯ��һ���˻��������
     * @param cardId  ����
     * @param accounts  ȫ���˻��ļ���
     * @return �˻�����/null
     */

    private static Account getAccountByCardId(String cardId, ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (acc.getCardId().equals(cardId)){
                return acc;
            }
        }
        return null;
    }


}
