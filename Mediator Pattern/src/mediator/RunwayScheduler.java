package scheduler;

import aircraft.Aircraft;

import java.util.Queue;

public interface RunwayScheduler {
    Aircraft getNextAircraft(Queue<Aircraft> landingQueue, Queue<Aircraft> takeOffQueue);
}
