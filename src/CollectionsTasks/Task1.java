package CollectionsTasks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Task1 {
    public ArrayList<Integer> inp(ArrayList<Integer> list){
        for (int i = 0; i < 1000000; i++)
            list.add(new Random().nextInt());
        return list;
    }
    public LinkedList<Integer> inp(LinkedList<Integer> list){
        for (int i = 0; i < 1000000; i++)
            list.add(new Random().nextInt());
        return list;
    }
    public void chose(ArrayList<Integer> list){
        int a;
        for (int i = 0; i < 100000; i++)
            a = list.get(Math.abs(new Random().nextInt(list.size() - 1)));
    }
    public void chose(LinkedList<Integer> list){
        int a;
        for (int i = 0; i < 100000; i++)
            a = list.get(Math.abs(new Random().nextInt(list.size() - 1)));
    }

    public static void main(String[] args) {
        Task1 run = new Task1();
        ArrayList<Integer> lst1 = new ArrayList();
        LinkedList<Integer> lst2 = new LinkedList();
        long start1 = System.currentTimeMillis();
        lst2 = run.inp(lst2);
        long finish1 = System.currentTimeMillis();
        System.out.println(finish1 - start1);
        long start2 = System.currentTimeMillis();
        run.chose(lst2);
        long finish2 = System.currentTimeMillis();
        System.out.println(finish2 - start2);
    }
}