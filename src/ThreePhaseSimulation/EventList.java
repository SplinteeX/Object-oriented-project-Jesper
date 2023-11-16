package ThreePhaseSimulation;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class EventList {
    private PriorityQueue<Event> evenList;

        public EventList() {
            evenList = new PriorityQueue<>();
    }
    public void add(Event e) {
        System.out.println("Adding to the event list " + e.getType() + " " + e.getTime());
        evenList.add(e);
    }
    public Event remove() {
        System.out.println("Removing from the event list " + evenList.peek().getType() + " " + evenList.peek().getTime());
        return evenList.remove();
    }
    public void print() {
        Object[] tmp = evenList.toArray();
        Arrays.sort(tmp);
        for (Object e : tmp)
            System.out.println(e);
    }
    public static void main(String[] args) {
            EventList eventList = new EventList();
            Random random = new Random();

            for (int i = 0; i<10; i++) {
                EvenType type;
                if (random.nextBoolean())
                    type = EvenType.ARR;
                else
                    type = EvenType.DEP;
                eventList.add(new Event(type, random.nextInt(1000)));
            }
        System.out.println("Event removed: " + eventList.remove());
            eventList.print();
    }
}
