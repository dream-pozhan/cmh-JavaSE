package cmh.api.interfaceJDK8demo;

public interface SportManInter {
    default void run(){
        //ʵ��������Ҫʹ��default���Σ�Ĭ��Ȩ��Ϊpublic���ӿڲ��ܴ�������ֻ����ʵ���ഴ���Ķ������
        System.out.println("�ܵúܿ�~~");
    }
    static void inadd(){
        //��̬����ֻ��ʹ�ýӿڽ��е���
        System.out.println("Javaѧϰ~~");
    }
    //˽�з���JDK1.9�ſ�ʼ��,ֻ���ڽӿ��ﱻ����
    /*
    * private void go(){
    *   System.out.println("�ߵÿ�~~");
    * }
    * */

}
class PingpongMan implements SportManInter{
    @Override
    public void run() {
        System.out.println("�������ܣ������ƹ����");
    }
}

class Test{
    public static void main(String[] args) {
        PingpongMan pingpongMan = new PingpongMan();
        pingpongMan.run();
        //pingpongMan.inadd();��ʱ�ᱨ��
        SportManInter.inadd();//��ʱ���ᱨ��
    }
}
