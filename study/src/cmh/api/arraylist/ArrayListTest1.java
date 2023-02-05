package cmh.api.arraylist;

import java.util.ArrayList;

public class ArrayListTest1 {
    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("肖申克的救赎",9.7,"罗宾斯"));
        movies.add(new Movie("霸王别姬",9.6,"张国荣"));
        movies.add(new Movie("姬霓太美",10.0,"蔡徐坤"));
        System.out.println(movies);

        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            System.out.println("片名："+movie.getName());
            System.out.println("评分："+movie.getScore());
            System.out.println("演员："+movie.getActor());
            System.out.println("-----------------------");
        }
    }
}
