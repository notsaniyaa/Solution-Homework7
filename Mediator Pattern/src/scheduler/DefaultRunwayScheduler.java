package scheduler;

import aircraft.Aircraft;
import java.util.Queue;

public class DefaultRunwayScheduler implements RunwayScheduler {
    @Override
    public Aircraft getNextAircraft(Queue<Aircraft> landingQueue, Queue<Aircraft> takeOffQueue) {
        // Priority to landing aircraft
        if (!landingQueue.isEmpty()) {
            return landingQueue.poll();
        } else if (!takeOffQueue.isEmpty()) {
            return takeOffQueue.poll();
        }
        return null;
    }
}

