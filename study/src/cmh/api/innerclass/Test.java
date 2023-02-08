package cmh.api.innerclass;

public class Test {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer("°®Ìı¿Î").new Inner();
        //Outer outer = new Outer();
        //outer.setHobby("ÓÎÓ¾");
        inner.setAge(26);
        inner.setName("ÕÅÈı");
        inner.show();
        inner.test();
    }
}
