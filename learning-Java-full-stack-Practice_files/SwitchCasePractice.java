public class SwitchCasePractice{
	public static void main (String[] args){
		int input = 6;

		switch (input) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				System.out.println("Weekday");
				break;
			case 6:
				System.out.println("weekday");
				break;
			case 7:
			default:
				System.out.println("Invalid input");
				break;
		}
	}
}
