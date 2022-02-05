package ThreadTaskParking;

public class Car implements Runnable{

    private final Integer NUMBER;
    private Parking parking;

    Car(int NUMBER, Parking parking){
        this.NUMBER = NUMBER;
        this.parking = parking;
    }
    public Integer getNUMBER() {
        return NUMBER;
    }

    @Override
    public void run() {
        try {
            parking.come(this);
            if(parking.come_parking(this)) {
                parking.at_parking(this);
                parking.left_parking(this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

