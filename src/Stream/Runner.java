package Stream;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
//       ArrayList<Integer> numbers = new ArrayList<>();
//        for (int i = 0; i < 20; i++)
//            numbers.add(new Random().nextInt(-10, 20));
//        System.out.println(numbers);
//        System.out.println(new CountOpposite().count(numbers));
//
//       ArrayList<String> surnames = new ArrayList<>();
//        surnames.add("Jefferson");
//        surnames.add("Messi");
//        surnames.add("Jumbo");
//        surnames.add("Patton");
//        surnames.add("Foch");
//        System.out.println(new Surnames().surname(surnames));
//
//        System.out.println(new WordsStatictics().words());

        new AandB().func(new Random().nextInt(0, 1000) % 10, new Random().nextInt(0, 1000) % 10);

    }
}
