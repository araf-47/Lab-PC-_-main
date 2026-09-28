public class MenuProgram {
    public static void main(String[] args) {
        // Menu choice
        int choice = 3;
        
        // TODO: Write a switch statement that prints a menu option
        // 1 = "View Account"
        // 2 = "Transfer Money"
        // 3 = "Pay Bill"
        // 4 = "Exit"
        // Default = "Invalid choice"
        
        switch (choice) {
            case 1:
                System.err.println("View Account");
                break;

            case 2:
                System.err.println("View Account");
                break;

            case 3:
                System.err.println("Pay Bill.");
                break;

            case 4:
                System.err.println("Exit");
                break;
        
            default:
                System.err.println("Invalid Choice");
                break;
        }
        
    }
}