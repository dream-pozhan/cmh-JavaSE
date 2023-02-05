package cmh.api.shopcart;
import java.util.Scanner;

public class ShopCatTest {
    public static void main(String[] args) {
        //������Ʒ�࣬�����Ժ󴴽���Ʒ����
        //���幺�ﳵ������һ����������ʾ
        Goods[] shopCar = new Goods[100];//[null.null.null...]
        //������ܹ�
        while (true) {
            System.out.println("����ѡ������������в�����");
            System.out.println("�����Ʒ�����ﳵ��add");
            System.out.println("��ѯ��Ʒ�����ﳵ��quary");
            System.out.println("�޸���Ʒ����������update");
            System.out.println("������Ʒ�Ĺ����pay");
            Scanner sc = new Scanner(System.in);
            System.out.println("�����������");
            String command = sc.next();
            switch (command){
                case "add" :
                    //�����Ʒ�����ﳵ
                    addGoods(shopCar,sc);
                    break;
                case "quary" :
                    //��ѯ��Ʒ�����ﳵ
                    quaryGoods(shopCar);
                    break;
                case "update" :
                    //�޸���Ʒ��������
                    updateGoods(shopCar,sc);
                    break;
                case "pay" :
                    //������Ʒ�Ĺ�����
                    pay(shopCar);
                    break;
                default:
                    System.out.println("û�иù��ܣ����������룡");
            }
        }
    }
/*
* �����Ʒ��ӵ����ﳵ�Ĺ���
* */
    public static void addGoods(Goods[] shopCar,Scanner sc) {
        System.out.println("�������빺����Ʒ�ı�ţ����ظ�����");
        int id = sc.nextInt();
        System.out.println("�������빺����Ʒ�����ƣ�");
        String name = sc.next();
        System.out.println("�������빺����Ʒ��������");
        int buyNumber = sc.nextInt();
        System.out.println("�������빺����Ʒ�ļ۸�");
        double price = sc.nextDouble();

        //�ѹ��������Ʒ����Ϣ��װ��һ����Ʒ����
        Goods g = new Goods();
        g.id = id;
        g.name = name;
        g.price = price;
        g.buyNumber = buyNumber;

        //��Ʒ������빺�ﳵ����
        for (int i = 0; i < shopCar.length; i++) {
            if (shopCar[i] == null){
                shopCar[i] = g;
                break;//��������Ϊ��Ʒ�Ѿ��ɹ����룬����Ҫ��Ѱ��λ��
            }
        }
        System.out.println("������Ʒ��"+g.name+"��ӵ����ﳵ��ɣ�");
    }

    public static void updateGoods(Goods[] shopCar,Scanner sc) {
        while (true) {
            System.out.println("������Ҫ�޸ĵ���Ʒid��");
            int id = sc.nextInt();
            Goods g = getGoodsById(shopCar,id);
            if (g == null){
                //û���ҵ�����Ʒ
            }else {
                System.out.println("�������룺"+g.name+"���¹���������");
                int buyNumber = sc.nextInt();
                g.buyNumber = buyNumber;
                System.out.println("�޸����!");
                quaryGoods(shopCar);
                break;
            }
        }
    }
    public static Goods getGoodsById(Goods[] shopCar,int id){
        //shopCar = [g1,g2,g3,...]
        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if(g != null){
                //�ж������Ʒ�����id�Ƿ�ΪΪ����Ҫ�ҵ�
                if (g.id == id)
                    return g;
            }else{
                return null;//�������д��ڵ���Ʒ��û���ҵ�
            }
        }
        return null;//����100����Ʒ��û���ҵ�
        }
/*
* ��ѯ���ﳵ�е���Ʒ������Ϣ����չʾ����
* */
    public static void quaryGoods(Goods[] shopCar) {
        System.out.println("==============��ѯ���ﳵ��Ϣ����=============");
        System.out.println("���\t\t����\t\t\t�۸�\t\t\t��������");
        //shopCar=[g1,g2,g3,null,null,...]
        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if(g != null){
                System.out.println(g.id+"\t\t"+g.name+"\t\t\t"+g.price+"\t\t\t"+g.buyNumber);
            }else{
                //��������
                break;
            }

        }
    }

    public static void pay(Goods[] shopCar) {
        quaryGoods(shopCar);
        //����һ����ͱ����ۼӽ��
        double money = 0;
        //�������ﳵ�����е���Ʒ�����ۼ�����*����
        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if(g != null){
                money = money+(g.buyNumber*g.price);
            }else{
                break;
            }
        }
        System.out.println("ȫ����Ʒ���ۼƽ��Ϊ��"+money);
    }
}
