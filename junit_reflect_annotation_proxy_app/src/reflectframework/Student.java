package reflectframework;

public class Student {
    private String name;
    private String gender;
    private int age;
    private String schoolName;
    private String hobby;

    public Student() {
    }

    public Student(String name, String gender, int age, String schoolName, String hobby) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.schoolName = schoolName;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
