package IntroductionToSimulate;
import java.util.LinkedList;
import java.util.Scanner;

public class Program_Task4 {
    public static void main(String[] args) {
        LinkedList<Customer> customerQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an action:");
            System.out.println("1. Add a customer to the queue");
            System.out.println("2. Remove the longest-waiting customer");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Customer newCustomer = new Customer(customerQueue, System.nanoTime(), System.nanoTime() + 3600000000000L);
                    customerQueue.add(newCustomer);
                    System.out.println("Customer added to the queue.");
                    break;
                case 2:
                    if (!customerQueue.isEmpty()) {
                        Customer removedCustomer = customerQueue.remove();
                        double timeSpent = (double) removedCustomer.getTimeSpent() / 3600000000000.0;
                        System.out.println("Customer " + removedCustomer.getId() + " removed from the queue.");
                        System.out.println("Time spent in the queue: " + timeSpent + " hours");
                    } else {
                        System.out.println("Queue is empty. No customers to remove.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
