package cmh.threadcase;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String cardId;
    private double money;
    private final Lock lock = new ReentrantLock();

    public Account() {
    }

    public Account(String cardId,double money) {
        this.cardId = cardId;
        this.money = money;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }


    public void drawMoney(double money) {
        //��ȡȡǮ�û�����
        String name = Thread.currentThread().getName();
         //ʵ��������this
        lock.lock();
        if (money <= this.money){
            System.out.println(name+"ȡǮ�ɹ�,���Ϊ��"+money);
            this.money -= money;
            System.out.println(name+"ȡǮ��ʣ�ࣺ"+this.money);
        }else{
            System.out.println("����");
        }
        lock.unlock();
    }

}
