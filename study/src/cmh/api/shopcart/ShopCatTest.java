package cmh.api.shopcart;
import java.util.Scanner;

public class ShopCatTest {
    public static void main(String[] args) {
        //创建商品类，用于以后创建商品对象
        //定义购物车对象，用一个数组对象表示
        Goods[] shopCar = new Goods[100];//[null.null.null...]
        //搭建操作架构
        while (true) {
            System.out.println("请您选择如下命令进行操作：");
            System.out.println("添加商品到购物车：add");
            System.out.println("查询商品到购物车：quary");
            System.out.println("修改商品购买数量：update");
            System.out.println("结算商品的购买金额：pay");
            Scanner sc = new Scanner(System.in);
            System.out.println("请您输入命令：");
            String command = sc.next();
            switch (command){
                case "add" :
                    //添加商品到购物车
                    addGoods(shopCar,sc);
                    break;
                case "quary" :
                    //查询商品到购物车
                    quaryGoods(shopCar);
                    break;
                case "update" :
                    //修改商品购买数量
                    updateGoods(shopCar,sc);
                    break;
                case "pay" :
                    //结算商品的购买金额
                    pay(shopCar);
                    break;
                default:
                    System.out.println("没有该功能，请重新输入！");
            }
        }
    }
/*
* 完成商品添加到购物车的功能
* */
    public static void addGoods(Goods[] shopCar,Scanner sc) {
        System.out.println("请您输入购买商品的编号（不重复）：");
        int id = sc.nextInt();
        System.out.println("请您输入购买商品的名称：");
        String name = sc.next();
        System.out.println("请您输入购买商品的数量：");
        int buyNumber = sc.nextInt();
        System.out.println("请您输入购买商品的价格：");
        double price = sc.nextDouble();

        //把购买这个商品的信息封装成一个商品对象
        Goods g = new Goods();
        g.id = id;
        g.name = name;
        g.price = price;
        g.buyNumber = buyNumber;

        //商品对象放入购物车数组
        for (int i = 0; i < shopCar.length; i++) {
            if (shopCar[i] == null){
                shopCar[i] = g;
                break;//结束，因为商品已经成功存入，不需要再寻找位置
            }
        }
        System.out.println("您的商品："+g.name+"添加到购物车完成！");
    }

    public static void updateGoods(Goods[] shopCar,Scanner sc) {
        while (true) {
            System.out.println("请输入要修改的商品id：");
            int id = sc.nextInt();
            Goods g = getGoodsById(shopCar,id);
            if (g == null){
                //没有找到该商品
            }else {
                System.out.println("请您输入："+g.name+"最新购买数量：");
                int buyNumber = sc.nextInt();
                g.buyNumber = buyNumber;
                System.out.println("修改完成!");
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
                //判断这个商品对象的id是否为为我们要找的
                if (g.id == id)
                    return g;
            }else{
                return null;//找完所有存在的商品都没有找到
            }
        }
        return null;//找完100个商品都没有找到
        }
/*
* 查询购物车中的商品对象信息，并展示出来
* */
    public static void quaryGoods(Goods[] shopCar) {
        System.out.println("==============查询购物车信息如下=============");
        System.out.println("编号\t\t名称\t\t\t价格\t\t\t购买数量");
        //shopCar=[g1,g2,g3,null,null,...]
        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if(g != null){
                System.out.println(g.id+"\t\t"+g.name+"\t\t\t"+g.price+"\t\t\t"+g.buyNumber);
            }else{
                //遍历结束
                break;
            }

        }
    }

    public static void pay(Goods[] shopCar) {
        quaryGoods(shopCar);
        //定义一个求和变量累加金额
        double money = 0;
        //遍历购物车数组中的商品对象，累加数量*单价
        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if(g != null){
                money = money+(g.buyNumber*g.price);
            }else{
                break;
            }
        }
        System.out.println("全部商品的累计金额为："+money);
    }
}
