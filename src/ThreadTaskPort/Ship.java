package ThreadTaskPort;

public class Ship implements Runnable {
    private final Status STATUS;
    private final int NUMBER;
    private final int MAX_SHIP_LOADING;
    private int ship_loading;
    private Port port;


    public Ship(Status status, int number, int loading, int max_ship_loading, Port port){
        STATUS = status;
        NUMBER = number;
        MAX_SHIP_LOADING = max_ship_loading;
        this.ship_loading = loading;
        this.port = port;
    }

    public Status getSTATUS() {
        return STATUS;
    }
    public int getNUMBER() {
        return NUMBER;
    }
    public int getMAX_SHIP_LOADING() {
        return MAX_SHIP_LOADING;
    }
    public int getShip_loading() {
        return ship_loading;
    }

    public void setShip_loading(int loading) {
        this.ship_loading = loading;
    }

    @Override
    public void run() {
        try {
            port.come_into_port(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
