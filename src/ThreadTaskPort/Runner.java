package ThreadTaskPort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> results = new ArrayList<>();
        Port port = new Port(3, 200, 100, results);
            for (int i = 0; i < 4; i++) {
                Status status = null;
                int a = Math.abs(new Random().nextInt());
                if (a % 3 == 0)
                    status = Status.LOADING;
                if (a % 3 == 1)
                    status = Status.UNLOADING;
                if (a % 3 == 2)
                    status = Status.BOTH;
                new Thread(new Ship(status, i, Math.abs(new Random().nextInt()) % 31, 30, port)).start();
            }
        TimeUnit.SECONDS.sleep(15);
        Collections.sort(results);
        System.out.println();
        for (String temp: results)
            System.out.println(temp);
//        b B = new b();
//        for (int i = 0; i < 10; i++) {
//            String p = Integer.toString(i);
//            new Thread(new y(B, i)).start();
//        }
//        TimeUnit.SECONDS.sleep(2);
    }
}

//class y implements Runnable{
//    b T;
//    int l;
//
//    public y(b t, int L) {
//        T = t;
//        l = L;
//    }
//
//    @Override
//    public void run() {
//        T.method(Integer.toString(l));
//    }
//}

