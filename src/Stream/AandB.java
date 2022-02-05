package Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AandB {
    public void func(int A, int B){
        int a = A > B ? B : A;
        int b = A > B ? A : B;
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> finalTemp = temp;
        IntStream.rangeClosed(a, b).forEach(x -> finalTemp.add(x));
        temp = A > B ? finalTemp.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayList::new)) : temp.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("A " + A + " B " + B + "\n" + temp);
    }
}
