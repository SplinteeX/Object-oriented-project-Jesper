package IntroductionToSimulate;

import java.util.ArrayList;
import java.util.List;
public class Program_Task3 {
    public static void main(String[] args) {
        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(customerList, System.currentTimeMillis(), System.currentTimeMillis() + 3600000));
        customerList.add(new Customer(customerList, System.currentTimeMillis(), System.currentTimeMillis() + 7200000));

        for (Customer customer : customerList) {
            double timeSpent = (double) customer.getTimeSpent() / 3600000;
            System.out.println("This is customer number: " + customer.getId());
            System.out.println("He has been spent: " + timeSpent + " hours");
        }
    }
}
class Customer {
    private int id;
    private long startTime;
    private long endTime;
    public Customer(List<Customer> customerList, long startTime, long endTime) {
        this.id = customerList.size() + 1;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public int getId() {
        return this.id;
    }
    public void setId() {
        this.id = id;
    }
    public long getStartTime() {
        return this.startTime;
    }
    public long getEndTime() {
        return this.endTime;
    }
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    public long getTimeSpent() {
        return this.endTime - this.startTime;
    }

}
