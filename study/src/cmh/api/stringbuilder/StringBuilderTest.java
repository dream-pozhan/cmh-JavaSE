package cmh.api.stringbuilder;

public class StringBuilderTest {
    public static void main(String[] args) {
        int[] arr = null;
        System.out.println(toString(arr));
        int[] arr1 = {11,22,36,52};
        System.out.println(toString(arr1));
    }
    public static String toString(int[] arr){
        if (arr != null){
            //��ʼƴ������
            StringBuilder stringBuilder = new StringBuilder("[");
            for (int i = 0; i < arr.length; i++) {
                stringBuilder.append(arr[i]).append(i == arr.length-1?"":",");
            }
            stringBuilder.append("]");//"]"���ܷ�����Ԫ������У���������⣬���統����Ϊarr2={}ʱ���ַ���ƴ�Ӻ����Ϊ[��
            return stringBuilder.toString();
        }else{
            return null;
        }
    }
}
