package mediator;

import aircraft.Aircraft;
import scheduler.RunwayScheduler;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new ConcurrentLinkedQueue<>();
    private Queue<Aircraft> takeOffQueue = new ConcurrentLinkedQueue<>();
    private boolean runwayAvailable = true;
    private List<Aircraft> aircraftList = new ArrayList<>();
    private RunwayScheduler scheduler;

    public ControlTower(RunwayScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void registerAircraft(Aircraft aircraft) {
        aircraftList.add(aircraft);
    }

    @Override
    public void broadcast(String msg, Aircraft sender) {
        System.out.println("[Tower] " + sender.getId() + " says: " + msg);
        if (msg.equalsIgnoreCase("MAYDAY")) {
            emergencyProtocol(sender);
        } else {
            for (Aircraft ac : aircraftList) {
                if (ac != sender) {
                    ac.receive("Message from " + sender.getId() + ": " + msg);
                }
            }
        }
    }

    @Override
    public synchronized boolean requestRunway(Aircraft aircraft) {
        if (aircraft.isEmergency()) {
            landingQueue.add(aircraft);
        } else if (aircraft.isRequestingLanding()) {
            landingQueue.add(aircraft);
        } else {
            takeOffQueue.add(aircraft);
        }

        if (runwayAvailable) {
            Aircraft nextAircraft = scheduler.getNextAircraft(landingQueue, takeOffQueue);
            if (nextAircraft != null && nextAircraft.equals(aircraft)) {
                runwayAvailable = false;
                System.out.println("[Tower] Runway cleared for: " + nextAircraft.getId());
                return true;
            }
        }

        return false;
    }

    public synchronized void freeRunway() {
        runwayAvailable = true;
    }

    private void emergencyProtocol(Aircraft emergencyAircraft) {
        System.out.println("[Tower] EMERGENCY! Clearing runway for: " + emergencyAircraft.getId());
        landingQueue.clear();
        takeOffQueue.clear();
        landingQueue.add(emergencyAircraft);

        for (Aircraft ac : aircraftList) {
            if (ac != emergencyAircraft) {
                ac.receive("[Tower] Hold your position. Emergency landing in progress.");
            }
        }

        runwayAvailable = true;
    }
}
