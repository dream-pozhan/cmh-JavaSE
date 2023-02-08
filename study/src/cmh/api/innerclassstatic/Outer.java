package cmh.api.innerclassstatic;

public class Outer {
    //静态内部类
    public static class inner{
        private String name;
        private int age;

        public inner() {
        }

        public inner(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
        void run(){
            System.out.println("这是静态内部类~~");
        }
    }
}
