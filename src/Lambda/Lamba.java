package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lamba {
    public static void main(String[] args) {
        String[] array1 = {"Месси", "Ракитич", "Месси"};
        String[] array2 = {"Мюллер", "Клозе", "Кроос", "Кроос", "Хедира", "Шюррле", "Шюррле"};
        String[] array3 = {"Суарес","Иньеста/аг.", "Месси пен.", "Неймар ст.", "Неймар пен.", "Роберто"};

        List<String[]> arrays = new ArrayList<>();
        arrays.add(array1);
        arrays.add(array2);
        arrays.add(array3);

        arrays.sort((o1, o2) -> o2.length - o1.length);
        arrays.forEach(o -> System.out.println(Arrays.toString(o)));

        Div13 example1 = (o) -> {if(o%13 == 0) return true;
            else return false;
        };
        System.out.println(example1.div13(-26));

        LongestString example2 = (o1, o2) -> {if(o1.length() >= o2.length()) return o1;
            else return o2;
        };
        System.out.println(example2.longestString("Окслэйд-Чемберлейн", "Папастатопулос"));

        Discriminant example3 = (o1, o2, o3) -> o1 * o1 - 4 * o2 * o3;
        System.out.println(example3.diskriminant(5, 2, 2));

        Discriminant example4 = (o1, o2, o3) -> o1 * Math.pow(o2, o3);
        System.out.println(example4.diskriminant(5, 2, 2));

        Calculator example5 = (o1, o2, o3) -> (o1 + o2)*(o3.equals("+")?1:0) + (o1 - o2)*(o3.equals("-")?1:0) +
                                              (o1 * o2)*(o3.equals("*")?1:0) + (o1 / o2)*(o3.equals("/")?1:0) +
                                              Math.pow(o1, o2)*(o3.equals("^")?1:0) + (o1 % o2)*(o3.equals("%")?1:0);
        System.out.println(example5.calculate(25,0.5,"^"));

    }
}