package cmh.api.polymorphictest;

public class Test {
    public static void main(String[] args) {
        //创建电脑对象
        Computer computer = new Computer("联想");
        computer.start();
        //创建鼠标键盘对象
        USB usb = new KeyBoard("双飞燕");
        computer.InstallUSB(usb);
        USB usb1 = new Mouse("罗技");
        computer.InstallUSB(usb1);
    }
}
