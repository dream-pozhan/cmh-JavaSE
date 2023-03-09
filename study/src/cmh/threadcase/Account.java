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
        //获取取钱用户名称
        String name = Thread.currentThread().getName();
         //实例方法锁this
        lock.lock();
        if (money <= this.money){
            System.out.println(name+"取钱成功,金额为："+money);
            this.money -= money;
            System.out.println(name+"取钱后剩余："+this.money);
        }else{
            System.out.println("余额不足");
        }
        lock.unlock();
    }

}
