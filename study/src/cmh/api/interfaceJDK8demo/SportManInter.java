package cmh.api.interfaceJDK8demo;

public interface SportManInter {
    default void run(){
        //实例方法需要使用default修饰，默认权限为public，接口不能创建对象，只能由实现类创建的对象调用
        System.out.println("跑得很快~~");
    }
    static void inadd(){
        //静态方法只能使用接口进行调用
        System.out.println("Java学习~~");
    }
    //私有方法JDK1.9才开始有,只能在接口里被访问
    /*
    * private void go(){
    *   System.out.println("走得快~~");
    * }
    * */

}
class PingpongMan implements SportManInter{
    @Override
    public void run() {
        System.out.println("不仅会跑，还会打乒乓球");
    }
}

class Test{
    public static void main(String[] args) {
        PingpongMan pingpongMan = new PingpongMan();
        pingpongMan.run();
        //pingpongMan.inadd();此时会报错
        SportManInter.inadd();//此时不会报错
    }
}
