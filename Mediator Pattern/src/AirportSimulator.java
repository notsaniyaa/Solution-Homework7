import mediator.ControlTower;
import scheduler.DefaultRunwayScheduler;
import aircraft.*;

import java.util.*;
import java.util.concurrent.*;

public class AirportSimulator {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower(new DefaultRunwayScheduler());
        List<Aircraft> aircrafts = new ArrayList<>();
        Random rand = new Random();

        // Generate random aircraft
        for (int i = 0; i < 10; i++) {
            int type = rand.nextInt(3);
            int fuel = rand.nextInt(100) + 1;
            Aircraft aircraft;
            switch (type) {
                case 0 -> aircraft = new PassengerPlane("P-" + i, fuel, tower);
                case 1 -> aircraft = new CargoPlane("C-" + i, fuel, tower);
                default -> aircraft = new Helicopter("H-" + i, fuel, tower);
            }
            tower.registerAircraft(aircraft);
            aircrafts.add(aircraft);
        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(aircrafts.size());
        for (Aircraft ac : aircrafts) {
            executor.scheduleAtFixedRate(() -> {
                ac.checkFuel();
                ac.requestRunway();
            }, 0, 2, TimeUnit.SECONDS);
        }

        executor.schedule(() -> executor.shutdown(), 30, TimeUnit.SECONDS);
    }
}
