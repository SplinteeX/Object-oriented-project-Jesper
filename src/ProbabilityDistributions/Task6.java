package ProbabilityDistributions;

import eduni.distributions.Negexp;

public class Task6 {
    public static void main(String[] args) {
        // Task 6 implementation
        System.out.println("Simulator\n");

        EventList eventList = new EventList();
        ArrivalProcess arrivalProcess = new ArrivalProcess(new Negexp(10, System.currentTimeMillis()), eventList, EventType.ARR);
        for (int i = 0; i < 10; i++) {
            Clock.getInstance().setTime(arrivalProcess.generateNextEvent());
        }
        System.out.println("Last event: " + Clock.getInstance().getTime());

       // Task 7 implementation
        ServicePoint servicePoint = new ServicePoint();
        Event e = eventList.remove();
        while (e != null) {
            if (e.getType() == EventType.ARR) {
                CustomerProb customer = new CustomerProb(e.getTime());
                servicePoint.addCustomer(customer);
            }
            e = eventList.remove();
        }
        servicePoint.serve();
    }
}

