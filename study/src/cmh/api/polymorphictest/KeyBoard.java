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
        System.out.println(name+"成功连接电脑");
    }

    @Override
    public void disconnect() {
        System.out.println(name+"成功从电脑中拔出");
    }
    /*
    * 独有功能
    * */
    public void KeyDown(){
        System.out.println(name+"敲击了：来了，老弟，666~~~没毛病~~~");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
