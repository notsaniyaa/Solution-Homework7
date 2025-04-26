package aircraft;

import mediator.TowerMediator;

public abstract class Aircraft {
    protected String id;
    protected int fuelLevel;
    protected TowerMediator mediator;
    protected boolean emergency = false;

    public Aircraft(String id, int fuelLevel, TowerMediator mediator) {
        this.id = id;
        this.fuelLevel = fuelLevel;
        this.mediator = mediator;
    }

    public String getId() {
        return id;
    }

    public void send(String msg) {
        mediator.broadcast(msg, this);
    }

    public abstract void receive(String msg);

    public boolean isEmergency() {
        return emergency;
    }

    public boolean isRequestingLanding() {
        return true;
    }

    public void requestRunway() {
        boolean cleared = mediator.requestRunway(this);
        if (cleared) {
            System.out.println("[" + id + "] Granted runway access.");
            try {
                Thread.sleep(1000); // Simulate landing/takeoff
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mediator.freeRunway();
        } else {
            System.out.println("[" + id + "] Waiting for runway...");
        }
    }

    public void checkFuel() {
        if (fuelLevel <= 10) {
            emergency = true;
            send("MAYDAY");
        }
    }
}
