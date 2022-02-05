package ThreadTaskParking;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Parking {

    private final int PLACE_COUNT;
    private int free_place_count;

    Parking(int PLACE_COUNT, int free_place_count){
        this.PLACE_COUNT = PLACE_COUNT;
        this.free_place_count = free_place_count;
    }

    public void come(Car car) throws InterruptedException {
        System.out.println("Car " + car.getNUMBER() + " is waiting to come");
    }
    public synchronized boolean come_parking(Car car) throws InterruptedException {
        if(free_place_count == 0){
            wait(TimeUnit.SECONDS.toMillis(1));
            if(free_place_count == 0) {
                System.out.println("Car " + car.getNUMBER() + " left parking. No free places");
                return false;
            }
            else{
                free_place_count--;
                System.out.println("Car " + car.getNUMBER() + " come to parking. Free places: " + free_place_count);
                TimeUnit.SECONDS.sleep(2);
                return true;
            }
        }
        else {
            free_place_count--;
            System.out.println("Car " + car.getNUMBER() + " come to parking. Free places: " + free_place_count);
            TimeUnit.SECONDS.sleep(2);
            return true;
        }
    }
    public void at_parking(Car car) throws InterruptedException {
        TimeUnit.SECONDS.sleep((new Random().nextInt(1, 11)));
    }
    public synchronized void left_parking(Car car) throws InterruptedException {
        free_place_count++;
        System.out.println("Car " + car.getNUMBER() + " left parking. Free places: " + free_place_count);
        TimeUnit.SECONDS.sleep(2);
        notify();
    }
}
