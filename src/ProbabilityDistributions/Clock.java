package ProbabilityDistributions;

public class Clock {
    private static Clock instance;
    private double time;

    private Clock() { }

    public static Clock getInstance() {
        if (instance == null)
            instance = new Clock();
        return instance;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getTime() {
        return time;
    }
}
