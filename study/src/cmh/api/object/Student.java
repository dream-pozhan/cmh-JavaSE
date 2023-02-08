package cmh.api.object;

import java.util.Objects;

public class Student {
    private String name;
    int age;
    private String major;

    public Student() {
    }

    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    //重写equals

    @Override
    public boolean equals(Object o){
        if (o instanceof Student){
            Student student2 = (Student) o;
            /*if(this.name.equals(student2.name) && this.age == student2.age && this.major.equals(student2.major)){
                return true;
            }else{
                return false;
            }*/
            return this.name.equals(student2.name) && this.age == student2.age && this.major.equals(student2.major);
        }else{
            //o的类型不是学生，直接返回false
            return false;
        }
    }



    //重写toString
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                '}';
    }
}
