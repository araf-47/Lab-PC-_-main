public class SalaryCalculator {
    public static void main(String[] args) {
        double monthlySalary = 50000;
        double bonus = 10000;
        double tax = 5000;
        int months = 12;

        double grossSalary = (monthlySalary + bonus) * months;
        double finalSalary = grossSalary - tax;

        boolean doesEarnAtLeast5000 = finalSalary >= 5000;

        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("Final Salary: " + finalSalary);
        System.out.println("Does earn at least 5000: " + doesEarnAtLeast5000);
    }
}
