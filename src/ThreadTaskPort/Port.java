package ThreadTaskPort;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Port {
    private final int PIERS_COUNT;
    private final int MAX_LOADING;
    private Integer loading;
    private Semaphore semaphore;
    private ArrayList<String> results;

    public Port(int piers_count, int max_loading, int loading, ArrayList<String> results){
        PIERS_COUNT = piers_count;
        MAX_LOADING = max_loading;
        this.loading = loading;
        semaphore = new Semaphore(PIERS_COUNT);
        this.results = results;
    }

    public void came_port(int NUMBER){
        System.out.println("Ship " + NUMBER + " came to port");
    }
    public void left_port(int NUMBER){
        System.out.println("Ship " + NUMBER + " left port");
    }
    public void waiting_to_unloading (int NUMBER){
        System.out.println("Ship " + NUMBER + " is waiting to unload");
    }
    public void waiting_to_loading(int NUMBER){
        System.out.println("Ship " + NUMBER + " is waiting to load");
    }
    public void waiting_both(int NUMBER){
        System.out.println("Ship " + NUMBER + " is waiting to upload and load");
    }
    public void loaded(int NUMBER){
        System.out.println("Ship " + NUMBER + " were loaded");
    }
    public void unloaded(int NUMBER){
        System.out.println("Ship " + NUMBER + " were unloaded");
    }
    public void in_progress(int NUMBER){
        System.out.println("Ship " + NUMBER + " in progress");
    }
    public String info(Ship ship){
        return "Ship " + ship.getNUMBER() + " current loading: " + ship.getShip_loading() + ", max loading: " + ship.getMAX_SHIP_LOADING() + ". Port loading: " + loading + ". Ship status: " + ship.getSTATUS();
    }

    public void come_into_port(Ship ship) throws InterruptedException {
        came_port(ship.getNUMBER());
        if(ship.getSTATUS() == Status.LOADING){
            waiting_to_loading(ship.getNUMBER());
            TimeUnit.SECONDS.sleep(1);
            semaphore.acquire();
            load(ship);
            left_port(ship.getNUMBER());
            semaphore.release();
        }
        if(ship.getSTATUS() == Status.UNLOADING){
            waiting_to_unloading(ship.getNUMBER());
            TimeUnit.SECONDS.sleep(1);
            semaphore.acquire();
            unload(ship);
            left_port(ship.getNUMBER());
            semaphore.release();
        }
        if(ship.getSTATUS() == Status.BOTH){
            waiting_both(ship.getNUMBER());
            TimeUnit.SECONDS.sleep(1);
            semaphore.acquire();
            unload(ship);
            load(ship);
            left_port(ship.getNUMBER());
            semaphore.release();
        }
    }
    public void load(Ship ship) throws InterruptedException {
        in_progress(ship.getNUMBER());
        TimeUnit.SECONDS.sleep(1);
        try {
                process(ship, true);
        }
        catch(PortException e){
            e.printStackTrace();
            System.out.println(e.problem);
        }
        TimeUnit.SECONDS.sleep(1);
        loaded(ship.getNUMBER());
    }
    public void unload(Ship ship) throws InterruptedException {
        in_progress(ship.getNUMBER());
        TimeUnit.SECONDS.sleep(1);
        try {
                process(ship, false);
        }
        catch(PortException e){
            e.printStackTrace();
            System.out.println(e.problem);
        }
        TimeUnit.SECONDS.sleep(1);
        unloaded(ship.getNUMBER());
    }
    public synchronized void process(Ship ship, Boolean action) throws PortException {
        if(action){
            results.add(info(ship) + " l");
            if (loading - ship.getMAX_SHIP_LOADING() + ship.getShip_loading() >= 0) {
                loading -= ship.getMAX_SHIP_LOADING() - ship.getShip_loading();
                ship.setShip_loading(ship.getMAX_SHIP_LOADING());
                if (loading < 0) throw new PortException("Loading < 0");
            } else {
                ship.setShip_loading(ship.getShip_loading() + loading);
                loading = 0;
                if (ship.getShip_loading() > ship.getMAX_SHIP_LOADING())
                    throw new PortException("Ship overloading");
            }
            results.add(info(ship) + " l");
        }
        else{
            results.add(info(ship) +" ul");
            if (loading + ship.getShip_loading() <= MAX_LOADING) {
                loading += ship.getShip_loading();
                ship.setShip_loading(0);
                if (loading > MAX_LOADING) throw new PortException("Port overloading");
            } else {
                ship.setShip_loading(ship.getShip_loading() - MAX_LOADING + loading);
                loading = MAX_LOADING;
                if (ship.getShip_loading() < 0) throw new PortException("Ship loading < 0");
            }
            results.add(info(ship) + " ul");
        }
    }
}
