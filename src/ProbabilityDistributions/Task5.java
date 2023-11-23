package ProbabilityDistributions;

public class Task5 {
    public static void main(String[] args) {
        Clock clock = Clock.getInstance();
        clock.setTime(15);
        System.out.println("Current time: " + clock.getTime());
        clock.setTime(22);
        System.out.println("Current time: " + clock.getTime());
    }
}
