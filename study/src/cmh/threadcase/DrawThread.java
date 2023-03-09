package cmh.threadcase;

public class DrawThread extends Thread{
    //���ܴ�����˻�����
    private Account account;
    private double drawMoney;
    public DrawThread(Account account,String name,double drawMoney){
        super(name);
        this.account = account;
        this.drawMoney = drawMoney;
    }

    @Override
    public void run() {
        account.drawMoney(drawMoney);
    }
}
