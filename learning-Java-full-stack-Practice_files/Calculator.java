public class Calculator {
    
    
    static int add (int a, int b) {
        return a + b;
    };
    static double add (double a, double b) {
        return a + b;
    };
    public static void main(String[] args) {
        // Calculator calc = new Calculator();
        System.out.println(add(1, 2));
        System.out.println(add(1.5, 2.5));
    }

}
