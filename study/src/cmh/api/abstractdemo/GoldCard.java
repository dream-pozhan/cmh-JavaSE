package cmh.api.abstractdemo;

public class GoldCard extends Card{

    @Override
    public void pay(double payMoney) {
        System.out.println("您消费的金额为:"+payMoney);
        System.out.println("您的余额为："+getMoney());
        double resultMoney = payMoney*0.8;
        System.out.println("您实际需要支付的金额为："+resultMoney);
        System.out.println("您现在的余额为:"+(getMoney()-resultMoney));
        setMoney((getMoney()-resultMoney));
    }
}
