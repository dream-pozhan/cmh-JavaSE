package cmh.api.polymorphictest;

public class Test {
    public static void main(String[] args) {
        //�������Զ���
        Computer computer = new Computer("����");
        computer.start();
        //���������̶���
        USB usb = new KeyBoard("˫����");
        computer.InstallUSB(usb);
        USB usb1 = new Mouse("�޼�");
        computer.InstallUSB(usb1);
    }
}
