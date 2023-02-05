package cmh.api.string;

import java.util.Random;

public class StringExce8 {
    public static void main(String[] args) {
        String dates = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        String code = "";
        Random r = new Random();
        for (int i = 0; i <5 ; i++) {
            int index = r.nextInt(dates.length());
            char c = dates.charAt(index);
            code+=c;
        }

        System.out.println(code);
    }
}
