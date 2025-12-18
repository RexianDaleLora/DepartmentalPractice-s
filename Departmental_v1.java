import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Departmental_v1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("How many branches to analyze? ");
        int numBranches = scanner.nextInt();
        double[] sales = inputSales(scanner, numBranches);
    
        String report = "";
        for (int i = 0; i < sales.length; i++) {
            String performance = evaluatePerformance(sales[i]);
    
            report += String.format("Branch %d: ₱%.2f - %s%n", i + 1, sales[i], performance);
        }
    
        saveReport(report);
        System.out.println("Report saved to sales_report.txt");
    
        scanner.close();
    }
    
    public static double[] inputSales(Scanner scanner, int numBranches) {
        double[] sales = new double[numBranches];
        System.out.println("Enter weekly sales for " + numBranches + " branches:");
        for (int i = 0; i < numBranches; i++) {
            System.out.print("Branch " + (i + 1) + ": ");
            sales[i] = scanner.nextDouble();
        }
        return sales;
    }
    
    public static String evaluatePerformance(double sales) {
        if (sales > 100000) {
            return "Excellent Performance";
        } else if (sales >= 50000) {
            return "Good Performance";
        } else {
            return "Needs Improvement";
        }
    }
    
    public static void saveReport(String data) {
        try (FileWriter writer = new FileWriter("sales_report.txt", java.nio.charset.StandardCharsets.UTF_8)) {
            writer.write(data);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the report.");
            e.printStackTrace();
        }
    }
}