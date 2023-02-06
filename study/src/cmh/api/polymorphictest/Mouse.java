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
        System.out.println(name+"成功连接电脑~~");
    }

    @Override
    public void unconnect() {
        System.out.println(name+"成功从电脑中拔出来~~");
    }
    /*
    * 独有功能
    * */
    public void DoubleClick(){
        System.out.println("双击点亮小红心，一键三连！");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
