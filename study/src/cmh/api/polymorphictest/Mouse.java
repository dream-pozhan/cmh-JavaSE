package cmh.api.polymorphictest;

public class Mouse implements USB {
    private String name;

    public Mouse() {
    }

    public Mouse(String name) {
        this.name = name;
    }

    @Override
    public void connect() {
        System.out.println(name+"�ɹ����ӵ���~~");
    }

    @Override
    public void unconnect() {
        System.out.println(name+"�ɹ��ӵ����аγ���~~");
    }
    /*
    * ���й���
    * */
    public void DoubleClick(){
        System.out.println("˫������С���ģ�һ��������");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
