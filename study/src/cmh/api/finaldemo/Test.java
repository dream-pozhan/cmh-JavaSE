package cmh.api.finaldemo;


public class Test {
    //���ξ�̬��Ա����
    public static final String string = "giao";
    //����ʵ����Ա����(�����壬��������)
    private final String name = "�����";
    public static void main(String[] args) {
        //���final���α���������
        //������Ϊ:�ֲ������ͳ�Ա��������̬��Ա������ʵ����Ա��������
        //���ξֲ�����,ֻ�ܱ���ֵһ��
        final double pai = 3.14;
        //pai = 3.15;�ڶ��θ�ֵ��������
        //string = "����";���ܵڶ��θ�ֵ��

        Test test = new Test();
        System.out.println(test.name);//���Ϊ�����
        //test.name = "����Ԫ˧";name�޷����еڶ��θ�ֵ����Ϊname��final�����ˣ�ֻ�ܸ�ֵһ�Σ���

        //final���εı���Ϊ��������ʱ�������洢�ĵ�ַ���ܱ䣬���ǵ�ַָ��Ķ������ݿ��Ա�
         final Teacher teacher = new Teacher("�ϿΣ�");
        System.out.println(teacher.getHobby());
        //teacher= null;teacher new ������ʱ�������һ����ַ����ַ���ܱ��ı���
        teacher.setHobby("������ҵ");//��ַָ������ݿ��Է����ı�
        System.out.println(teacher.getHobby());

    }
}

class Teacher{
    private String hobby;

    public Teacher(String hobby) {
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}

