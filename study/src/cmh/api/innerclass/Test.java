package cmh.api.innerclass;

public class Test {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer("������").new Inner();
        //Outer outer = new Outer();
        //outer.setHobby("��Ӿ");
        inner.setAge(26);
        inner.setName("����");
        inner.show();
        inner.test();
    }
}
