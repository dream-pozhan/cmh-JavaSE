package cmh.api.polymorphictest;

public class KeyBoard implements USB{
    private String name;
    public KeyBoard() {
    }
    public KeyBoard(String name) {
        this.name = name;
    }

    @Override
    public void connect() {
        System.out.println(name+"�ɹ����ӵ���");
    }

    @Override
    public void disconnect() {
        System.out.println(name+"�ɹ��ӵ����аγ�");
    }
    /*
    * ���й���
    * */
    public void KeyDown(){
        System.out.println(name+"�û��ˣ����ˣ��ϵܣ�666~~~ûë��~~~");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
