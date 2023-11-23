package ProbabilityDistributions;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int[] ageGroups = { 20, 21, 22, 23, 24, 25, 26, 28, 30, 35 };
        double[] probabilities = { 0.16, 0.18, 0.18, 0.16, 0.14, 0.07, 0.05, 0.02, 0.02, 0.02 };

        System.out.println("Running age distribution simulation multiple times to observe variability:\n");

        for (int run = 1; run <= 5; run++) {
            int[] generatedAges = simulateAgeDistribution(ageGroups, probabilities, 1000);

            System.out.println("Run " + run + ":");
            System.out.println("Age  Count     %-Share");
            for (int age = 0; age < ageGroups.length; age++) {
                int ageValue = ageGroups[age];
                int count = generatedAges[age];
                double percentage = (double) count / 1000 * 100;
                System.out.printf("%-4d %-8d %-8.2f%%\n", ageValue, count, percentage);
            }
            System.out.println();
        }
    }

    public static int[] simulateAgeDistribution(int[] ageGroups, double[] probabilities, int iterations) {
        double[] cumulativeProbabilities = createCumulativeDistribution(probabilities);

        int[] generatedAges = new int[ageGroups.length];

        Random rand = new Random();
        for (int i = 0; i < iterations; i++) {
            double randNum = rand.nextDouble();

            int simulatedAge = mapRandomToAge(randNum, cumulativeProbabilities, ageGroups);
            int index = findIndex(ageGroups, simulatedAge);
            generatedAges[index]++;
        }

        return generatedAges;
    }

    public static double[] createCumulativeDistribution(double[] probabilities) {
        double[] cumulativeProbabilities = new double[probabilities.length];
        double cumulative = 0;
        for (int i = 0; i < probabilities.length; i++) {
            cumulative += probabilities[i];
            cumulativeProbabilities[i] = cumulative;
        }
        return cumulativeProbabilities;
    }

    public static int mapRandomToAge(double randNum, double[] cumulativeProbabilities, int[] ageGroups) {
        for (int i = 0; i < cumulativeProbabilities.length; i++) {
            if (randNum <= cumulativeProbabilities[i]) {
                return ageGroups[i];
            }
        }
        return ageGroups[ageGroups.length - 1];
    }

    public static int findIndex(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
