package cmh.api.arraylist;

import java.util.ArrayList;

public class ArrayListTest1 {
    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Ф��˵ľ���",9.7,"�ޱ�˹"));
        movies.add(new Movie("������",9.6,"�Ź���"));
        movies.add(new Movie("����̫��",10.0,"������"));
        System.out.println(movies);

        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            System.out.println("Ƭ����"+movie.getName());
            System.out.println("���֣�"+movie.getScore());
            System.out.println("��Ա��"+movie.getActor());
            System.out.println("-----------------------");
        }
    }
}
