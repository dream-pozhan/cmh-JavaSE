package cmh.api.abstractdemo;

public class GoldCard extends Card{

    @Override
    public void pay(double payMoney) {
        System.out.println("�����ѵĽ��Ϊ:"+payMoney);
        System.out.println("�������Ϊ��"+getMoney());
        double resultMoney = payMoney*0.8;
        System.out.println("��ʵ����Ҫ֧���Ľ��Ϊ��"+resultMoney);
        System.out.println("�����ڵ����Ϊ:"+(getMoney()-resultMoney));
        setMoney((getMoney()-resultMoney));
    }
}
