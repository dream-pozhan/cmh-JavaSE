package cmh.atm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        //1,定义账户类
        //2,定义一个集合容器，负责以后存储全部的用户对象，进行相关的业务操作
        ArrayList<Account> accounts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        //3.展示系统首页
        while (true) {
            System.out.println("**********黑马ATM系统**********");
            System.out.println("1、账户登录");
            System.out.println("2、账户开户");
            System.out.println("请您选择操作：");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    //用户登录操作
                    login(accounts,sc);
                    break;
                case 2:
                    //用户开户操作
                    register(accounts,sc);
                    break;
                default:
                    System.out.println("您输入的操作命令不存在~~");
            }
        }

    }

    /**
     * 登录功能
     * @param accounts 所有账户对象的集合
     * @param sc 扫描器
     */
    private static void login(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("**********用户登录操作*********");
        //1，判断是否存在账户，如果不存在，需要先注册，才能登录
        if (accounts.size() == 0){
            System.out.println("对不起，当前系统中无任何账户，请先开户！");
            return;//卫语言风格
        }
        //2,正式进入登录操作
        while (true) {
            System.out.println("请您输入登录卡号：");
            String cardId = sc.next();
            //3，判断卡号是否存在，根据卡号去账户集合里查询账户对象
            Account accountnow = getAccountByCardId(cardId,accounts);
            if (accountnow != null){
                while (true) {
                    //卡号存在
                    //4,让用户输入密码，认证密码
                    System.out.println("请您输入登录密码：");
                    String password = sc.next();
                    //判断账户对象的密码是否与输入的密码一致
                    if (accountnow.getPassword().equals(password)){
                        //登陆成功了
                        System.out.println("恭喜您，"+accountnow.getUserName()+"先生/女士进入系统，您的卡号是："+accountnow.getCardId());
                        //查询，转账，取款
                        //展示登陆后的操作页
                        showUserCommand(sc,accountnow,accounts);
                        return;//结束当前方法
                    }else {
                        System.out.println("对不起，您输入的密码有误~~");
                    }
                }
            }else {
                System.out.println("对不起，系统中不存在该账户卡号~~");
            }
        }
    }

    /**
     * 展示登录后的操作页
     */
    private static void showUserCommand(Scanner sc, Account acc, ArrayList<Account> accounts) {
        while (true) {
            System.out.println("**********用户操作页*********");
            System.out.println("1,查询账户");
            System.out.println("2,存款");
            System.out.println("3,取款");
            System.out.println("4,转账");
            System.out.println("5,修改密码");
            System.out.println("6,退出");
            System.out.println("7,注销账户");
            System.out.println("请选择：");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    //查询账户(展示当前账户信息)
                    showAccount(acc);
                    break;
                case 2:
                    //存款
                    deposiMoney(sc,acc);
                    break;
                case 3:
                    //取款
                    drawMoney(acc,sc);
                    break;
                case 4:
                    //转账
                    transferMoney(acc,sc,accounts);
                    break;
                case 5:
                    //修改密码
                    updatePassword(sc,acc);
                    return;
                case 6:
                    //退出
                    System.out.println("退出成功，欢迎下次光临~~");
                    return;//结束当前方法
                case 7:
                    //注销账户
                    if (deleteAccount(sc,acc,accounts)){
                        return;
                    }else {
                        break;
                    }

                default:
                    System.out.println("您输入的操作命令不正确~~");
            }
        }

    }

    /**
     * 销户操作
     * @param sc
     * @param accountnow
     * @param accounts
     */
    private static boolean deleteAccount(Scanner sc, Account accountnow, ArrayList<Account> accounts) {
        System.out.println("**********用户销户操作*********");
        System.out.println("您真的要消除账户？y/n");
        String resoult = sc.next();
        switch (resoult){
            case "y":
                if (accountnow.getMoney()>0){
                    System.out.println("您的账户中还有余额，无法销户~~");
                }else{
                    accounts.remove(accountnow);
                    System.out.println("销户成功~~");
                    return true;
                }
            default:
                System.out.println("账户继续保留~~");
        }
        return false;
    }

    /**
     * 修改密码操作
     * @param sc 扫描器
     * @param accountnow 当前账户对象
     */
    private static void updatePassword(Scanner sc, Account accountnow) {
        System.out.println("**********用户修改密码操作*********");
        while (true) {
            System.out.println("请您输入旧密码");
            String password = sc.next();
            //校验密码是否正确
            if (accountnow.getPassword().equals(password)){
                while (true) {
                    System.out.println("请输入新密码：");
                    String okpassworrd = sc.next();
                    System.out.println("请再次输入新密码：");
                    String oKpassword = sc.next();
                    if (okpassworrd.equals(oKpassword)){
                        System.out.println("密码修改成功~~");
                        accountnow.setPassword(oKpassword);
                        return;
                    }else {
                        System.out.println("两次密码不一致，请重新输入~~");
                    }
                }
            }else {
                System.out.println("密码错误，请重新输入~~");
            }
        }
    }

    /**
     * 转账操作
     * @param accountnow 当前登录的账户
     * @param sc 扫描器
     * @param accounts 所有账户的集合
     */
    private static void transferMoney(Account accountnow, Scanner sc, ArrayList<Account> accounts) {
        System.out.println("**********用户转账操作*********");
        //判断是否足够两个账户
        if (accounts.size() < 2){
            System.out.println("对不起，系统中账户不足两个，无法进行转账，请去开户~~");
            return;
        }
        //判断账户收否有钱
        if (accountnow.getMoney() == 0){
            System.out.println("您自己都没有钱了，就别转账了~~");

        }
        //真正开始转账
        while (true) {
            System.out.println("请您输入对方卡号：");
            String cardId = sc.next();

            //判断卡号不能是自己的卡号
            if (accountnow.getCardId().equals(cardId)){
                System.out.println("对不起，您不能给自己进行转账！");
                continue;
            }

            //判断卡号是否存在，根据对方卡号去查账户对象
            Account account = getAccountByCardId(cardId,accounts);
            if (account == null){
                System.out.println("对不起，您输入的卡号不存在！");
            }else{
                //对方账户存在，认证姓氏
                String userName = account.getUserName();
                String tip = "*"+userName.substring(1);
                System.out.println("请您输入["+tip+"]的姓氏");
                String preName = sc.next();

                //认证姓氏是否输入正确
                if (userName.startsWith(preName)){
                    while (true) {
                        //认证成功，开始转账
                        System.out.println("请您输入转账金额：");
                        double money = sc.nextDouble();
                        //判断金钱是否足够
                        if (money > accountnow.getMoney()){
                            System.out.println("对不起，余额不够！最多可转"+accountnow.getMoney()+"元~~");
                        }else {
                            //转账成功
                            accountnow.setMoney(accountnow.getMoney() - money);
                            account.setMoney(account.getMoney()+money);
                            System.out.println("转账成功，你的账户余额为："+accountnow.getMoney());
                            return;
                        }
                    }
                }else{
                    System.out.println("对不起，您输入的信息有误~~");
                }


            }
        }

    }

    /**
     * 取钱功能
     * @param accountNow 当前登录账户
     * @param sc 扫描器
     */
    private static void drawMoney(Account accountNow, Scanner sc) {
        System.out.println("**********用户取钱操作*********");
        //1，判断是否够100元
        if (accountNow.getMoney()<100){
            System.out.println("对不起，当前账户不够100元，不能取钱！");
            return;
        }
        //2,提示输入取款金额
        System.out.println("请您输入取款金额：");
        double money = sc.nextDouble();

        //3,判断金额是否满足要求
        if (money > accountNow.getQuotaMoney()){
            System.out.println("对不起，您当次取款金额超过每次取款限额，每次最多可取："+accountNow.getQuotaMoney());
        }else {
           //没有超过限额
            //4，判断是否超过账户总余额
            if(money > accountNow.getMoney()){
                System.out.println("余额不足，您当前的总余额是："+accountNow.getMoney());
            }else{
                //可以取钱了
                System.out.println("恭喜您，取钱"+money+"成功");
                //更新余额
                accountNow.setMoney(accountNow.getMoney()-money);
                //取钱结束，展示个人账户信息
                showAccount(accountNow);

            }
        }
    }

    /**
     * 存钱
     * @param sc 扫描器
     * @param accountnow 当前账户对象
     */
    private static void deposiMoney(Scanner sc, Account accountnow) {
        System.out.println("**********用户存钱操作*********");
        System.out.println("请输入存入金额：");
        double  money = sc.nextDouble();

        //更新账户余额：原来的钱+存入的钱
        accountnow.setMoney(accountnow.getMoney()+money);
        System.out.println("恭喜您，存钱成功，账户信息如下：");
        showAccount(accountnow);
    }


    /**
     * 展示账户信息
     * @param accountnow
     */
    private static void showAccount(Account accountnow) {
        System.out.println("**********当前账户信息如下*********");
        System.out.println("卡号："+accountnow.getCardId());
        System.out.println("户主："+accountnow.getUserName());
        System.out.println("余额："+accountnow.getMoney());
        System.out.println("限额："+accountnow.getQuotaMoney());
    }

    /**
     * 用户开户功能的实现
     * @param accounts 接受的账户的集合
     */
    private static void register(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("**********用户开户操作*********");
        //1,创建一个账户对象，用于后期封装账户信息
        Account account = new Account();
        //2,录入当前的这个账户信息，注入到账户对象中去
        System.out.println("请您输入账户用户名：");
        String userName = sc.next();
        account.setUserName(userName);

        while (true) {
            System.out.println("请输入账户密码：");
            String password = sc.next();
            System.out.println("请确认账户密码：");
            String okpassword = sc.next();
            if (okpassword.equals(password)){
                //密码验证通过，注入给对象
                account.setPassword(okpassword);
                //演这个通过，停止死循环
                break;
            }else{
                System.out.println("对不起，您两次输入的密码不一致，请重新输入~~~~");
            }
        }
        System.out.println("请您输入当次取款限额：");
        double quoteMoney = sc.nextDouble();
        account.setQuotaMoney(quoteMoney);

        //为账户随机一个八位且不重复的卡号(独立成一个方法)
        String cardId = getRandomCardId(accounts);
        account.setCardId(cardId);

        //3,把账户对象添加到账户集合中去
        accounts.add(account);
        System.out.println("恭喜您"+userName+"先生/女士,您开户成功，您的卡号是："+cardId+"，请您妥善保管卡号！");
    }

    /**
     * 账户生成8位数卡号且与其他卡号不同
     * @return
     */
    private static String getRandomCardId(ArrayList<Account> accounts) {
        //1,先生成8位卡号
        Random r = new Random();
        while (true) {
            String cardId = "";
            for (int i = 0; i < 8; i++) {
                cardId += r.nextInt(10);
            }

            //2，判断此账户卡号是否与其他账户卡号重复
            //根据这个卡号去查询账户对象
            Account acc = getAccountByCardId(cardId, accounts);
            if (acc == null) {
                //说明卡号不重复，可以作为新注册的账户卡号
                return cardId;
            }
        }
    }


    /**
     * 根据卡号查询出一个账户对象出来
     * @param cardId  卡号
     * @param accounts  全部账户的集合
     * @return 账户对象/null
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
