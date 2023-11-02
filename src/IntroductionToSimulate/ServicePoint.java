package IntroductionToSimulate;

import java.util.LinkedList;

public class ServicePoint {
    private LinkedList<Customer> queue;
    private int customerServed;
    private long serviceTimeSum;

    public ServicePoint() {
        queue = new LinkedList<>();
        customerServed = 0;
        serviceTimeSum = 0;

    }
    public void addCustomer(Customer a) {
        a.setStartTime(System.currentTimeMillis());
        queue.addFirst(a);
    }
    private Customer removeFromQueue() {
        if (queue.size() > 0)
            return queue.removeLast();
        else
            return null;
    }
    public void serve() {
        Customer a;
        long tic,toc, serviceTime;
        a = removeFromQueue();
        while (a != null) {
            // Serve the customer
            tic = System.currentTimeMillis();
            try {
                Thread.sleep(Math.round(Math.random()*9000+1000));
            } catch (InterruptedException e){}

            // Customer served
            toc = System.currentTimeMillis();
            serviceTime = toc - tic;
            customerServed++; serviceTimeSum += serviceTime;
            System.out.println(serviceTime + " ms");
            a.setEndTime(System.currentTimeMillis());
            System.out.println(a);
            a = removeFromQueue();
        }

    }
    public double avgServiceTime() {
        if (customerServed != 0)
            return (double) serviceTimeSum / customerServed;
        else
            return 0.0;
    }
}
