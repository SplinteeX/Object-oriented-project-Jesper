package IntroductionToSimulate;

public class Program_task5 {
    public static void main(String[] args) {
        System.out.println("Basic Queue/Servicepoint simulator");
        ServicePoint servicePoint = new ServicePoint();

        new CustomerGenerator(servicePoint);
        servicePoint.serve();
        System.out.println("Average servicetime: " + servicePoint.avgServiceTime() + " ms");
    }
}
