import java.util.Scanner;

public class Lab8 {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		String[] studentName = { "John", "Rachel", "Helen", "Liz", "Jim", "Sarah", "Laura", "Bill", "Kathy", "Joe" };
		String[] homeTown = { "Detroit", "Chicago", "San Francisco", "Denver", "Los Angeles", "Philadelphia", "Dalls",
				"San Antonio", "Austin", "New York" };
		String[] favoriteFood = { "Pizza", "Burgers", " Fries", "BBQ", "Salad", "Burgers", "Hot dogs", "Pizza", "Salad",
				"Fries" };

		for (int i = 0; i < studentName.length; i++) {
			System.out.print((i + 1) + "." + studentName[i] + " ");
		}

		System.out.println();
		boolean valid = false;

		do {
			System.out.println("Which student would you like to learn more about? (enter a number 1-10)");

			int userChoice = scnr.nextInt();
			int index = userChoice - 1;

			try {
				System.out.println("Student " + userChoice + " is " + studentName[index] + ".");
				valid = true;

			} catch (ArrayIndexOutOfBoundsException ex) {
				scnr.nextLine();
				System.out.println("That student does not exist. Please try again. " + "");
				valid = false;
				continue;
			}

			scnr.nextLine();

			String knowMore = "yes";

			while (knowMore.equalsIgnoreCase("yes")) {
				System.out.println("What would you like to know about " + studentName[index]
						+ " ? (enter \"hometown\" or \"favorite food\")\n");
				String infoChoice = scnr.nextLine();
				if (infoChoice.equalsIgnoreCase("hometown")) {
					System.out.println(studentName[index] + " is from " + homeTown[index] + ".\n");
				} else if (infoChoice.equalsIgnoreCase("favorite food")) {
					System.out.println(studentName[index] + " likes " + favoriteFood[index] + ".\n");
				} else {
					System.out.println("That data does not exist. Please try again. ");
					continue;
				}
				int flag = 0;

				do {
					System.out.println("Would you like to know more? (enter \"yes\" or \"no\")\n ");
					knowMore = scnr.nextLine();

					if (knowMore.equalsIgnoreCase("yes")) {
						flag = 1;// continue;
					} else if (knowMore.equalsIgnoreCase("no")) {
						flag = 1;
						System.out.println("Thanks!");
					} else if ((!knowMore.equalsIgnoreCase("yes")) || (!knowMore.equalsIgnoreCase("no"))) {
						System.out.println("Invalid response. Please type \"yes\" or \"no\".");
						continue;
					}
				} while (flag != 1);
			}

		} while (!valid);
		scnr.close();
	}

}
