import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Main main = new Main();
		main.greeting();
		Field level1 = new Field();
		Hamster hamster = new Hamster();
		String action = "";

		level1.createRandomField(level1.getField());
		hamster.setHamsterOnField(level1.getField());
		level1.printField(level1.getField());

		while (!action.equals("5")) {
			main.rules();
			System.out.println("Enter your action: ");
			action = sc.nextLine();
			System.out.print("\n");

			switch (action) {
			case "1":
				hamster.turnLeft(level1);
				break;
			case "2":
				hamster.turnRight(level1);
				break;
			case "3":
				hamster.goStraight(level1);
				break;
			case "4":
				hamster.printEatenCorns();
				break;
			case "5":
				System.out.println("Thanks for playing the hamster game!");
				int cornsLeft = 7 - hamster.getEatenCorns();
				System.out.println("There are " + cornsLeft + " corns left in the game.");
				break;
			default:
				System.out.println("Wrong key entered! ");
				break;
			}
			if (hamster.getEatenCorns() == 7) {
				System.out.println("Congratulations!!! You ate all Corns and won the game ! ");
				break;
			}
		}

		sc.close();
	}

	public void greeting() {
		System.out.println("Welcome to the hamster game!");
		System.out.println("Try to eat all corns!");
		System.out.println("How to controll the hamster / game:");
		rules();
	}

	public void rules() {
		System.out.println("1: Turn left / 2: Turn right / 3: Go Straight / 4: Print eaten corns / 5: End the game");
	}

}
