package ThreadTaskParking;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Parking parking = new Parking(4, 4);
        for (int i = 0; i < 10; i++) {
            new Thread(new Car(new Random().nextInt(1000, 10000), parking)).start();
            TimeUnit.SECONDS.sleep(1);
        }
        TimeUnit.SECONDS.sleep(60);
    }
}

