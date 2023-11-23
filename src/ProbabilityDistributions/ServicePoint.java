package ProbabilityDistributions;

import java.util.LinkedList;

public class ServicePoint {
    private LinkedList<CustomerProb> queue;
    private int customerServed;
    private long serviceTimeSum;

    public ServicePoint() {
        queue = new LinkedList<>();
        customerServed = 0;
        serviceTimeSum = 0;

    }
    public void addCustomer(CustomerProb a) {
        a.setStartTime(System.currentTimeMillis());
        queue.addFirst(a);
    }
    private CustomerProb removeFromQueue() {
        if (queue.size() > 0)
            return queue.removeLast();
        else
            return null;
    }
    public void serve() {
        CustomerProb a;
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
            System.out.println(a);
            System.out.println(serviceTime + " ms");
            a.setEndTime(System.currentTimeMillis());
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