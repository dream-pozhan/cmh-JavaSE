package cmh.api.polymorphictest;

public class Computer {
    private String name;
    public Computer(){
    }
    public Computer(String name){
        this.name = name;
    }
    /*
    * 提供电脑安装USB的接口
    * */
    public void start(){
        System.out.println("电脑开机了~~");
    }
    public void InstallUSB(USB usb){
        //多态 USB可能是鼠标，也可能是键盘
        usb.connect();
        usb.unconnect();
        if (usb instanceof KeyBoard){
            KeyBoard keyBoard = (KeyBoard) usb;
            keyBoard.KeyDown();
        }else if(usb instanceof Mouse){
            Mouse mouse = (Mouse) usb;
            mouse.DoubleClick();
        }

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
