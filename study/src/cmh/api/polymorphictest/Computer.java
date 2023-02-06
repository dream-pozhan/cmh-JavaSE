package cmh.api.polymorphictest;

public class Computer {
    private String name;
    public Computer(){
    }
    public Computer(String name){
        this.name = name;
    }
    /*
    * �ṩ���԰�װUSB�Ľӿ�
    * */
    public void start(){
        System.out.println("���Կ�����~~");
    }
    public void InstallUSB(USB usb){
        //��̬ USB��������꣬Ҳ�����Ǽ���
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
