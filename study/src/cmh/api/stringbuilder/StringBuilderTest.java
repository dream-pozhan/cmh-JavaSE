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
            //开始拼接内容
            StringBuilder stringBuilder = new StringBuilder("[");
            for (int i = 0; i < arr.length; i++) {
                stringBuilder.append(arr[i]).append(i == arr.length-1?"":",");
            }
            stringBuilder.append("]");//"]"不能放入三元运算符中，会出现问题，例如当数组为arr2={}时，字符串拼接后输出为[；
            return stringBuilder.toString();
        }else{
            return null;
        }
    }
}
