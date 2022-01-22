package CollectionsTasks;

import java.util.*;

public class Task2 {

    public <T> Map<T, Integer> func(T[] elem){
        Map<T, Integer> out = new HashMap<>();
        List <T> temp = Arrays.asList(elem);
        ArrayList<T> tem = new ArrayList<>();
        for (T t: temp) {tem.add(t);}
        while(!tem.isEmpty()){
            int size1 = tem.size(), size2;
            T el = tem.get(0);
            while (tem.indexOf(el) >= 0)
                tem.remove(el);
            size2 = tem.size();
            out.put(el, size1 - size2);
        }
        return out;
    }

    public static void main(String[] args) {
        Task2 run = new Task2();
        String[] arr = {"a", "b", "a"};
        System.out.println(Arrays.toString(run.func(arr).values().toArray()));
    }
}
