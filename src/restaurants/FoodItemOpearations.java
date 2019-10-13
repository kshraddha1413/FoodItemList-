package Restrorent;

import java.util.Scanner;

public class FoodItemOpearations {
	private static Scanner scanner = new Scanner(System.in);
	private static FoodItemList foodItemList = new FoodItemList();

	public static void main(String[] args) {
		boolean quit = false;
		printActions();
		while (!quit) {
			System.out.println("\nEnter action: (5 to show available actions)");
			int action = scanner.nextInt();
			scanner.nextLine();
			switch (action) {
			case 1:
				foodItemList.printFoodItemDetails();
				break;
			case 2:
				addNewFoodItemDetails();
				break;
			case 3:
				updateFoodItemDetails();
				break;
			case 4:
				removeFoodItemDetails();
				break;
			case 5:
				printActions();
				break;
			

			}
		}
	}

	private static void printActions() {
		System.out.println("\nAvailable actions:\npress");
		System.out
				.println("1  - to print foodItems List\n" + "2  - to add a new fooditem\n" + "3  - to update fooditem\n"
						+ "4  - to remove food item\n" + "5  - to print a list of available actions."
						);
		System.out.println("Choose your action: ");
	}

	private static void addNewFoodItemDetails() {
		System.out.println("Enter new food item type: ");
		String foodItemType = scanner.nextLine();
		System.out.println("Enter food item name: ");
		String foodItemName = scanner.nextLine();
		System.out.println("Enter food item price: ");
		double foodItemPrice = scanner.nextDouble();

		FoodItemDetails details = FoodItemDetails.createFoodItem(foodItemType, foodItemName, foodItemPrice);
		if (foodItemList.addNewFoodItem(details)) {
			System.out.println("New food item added: food type = " + foodItemType + "food Item name" + foodItemName
					+ "food item price" + foodItemPrice);
		} else {
			System.out.println("Cannot add, " + foodItemName + " already on list");
		}
	}

	private static void updateFoodItemDetails() {
		System.out.println("Enter existing food item name: ");
		String foodItemName1 = scanner.nextLine();
		FoodItemDetails existingContactRecord = foodItemList.queryFoodItemDeatils(foodItemName1);
		if (existingContactRecord == null) {
			System.out.println("Food Item not found.");
			return;
		}

		System.out.println("Enter new food item type: ");
		String foodItemType = scanner.nextLine();
		System.out.println("Enter food item name: ");
		String foodItemName = scanner.nextLine();
		System.out.println("Enter food item price: ");
		double foodItemPrice = scanner.nextDouble();

		FoodItemDetails details = FoodItemDetails.createFoodItem(foodItemType, foodItemName, foodItemPrice);
		if (foodItemList.updateFoodItem(existingContactRecord, details)) {
			System.out.println("Successfully updated record");
		} else {
			System.out.println("Error updating record.");
		}

	}

	private static void removeFoodItemDetails() {
		System.out.println("Enter existing food item name: ");
		String name = scanner.nextLine();
		FoodItemDetails existingContactRecord = foodItemList.queryFoodItemDeatils(name);
		if (existingContactRecord == null) {
			System.out.println("Food item not found.");
			return;
		}

		if (foodItemList.removeFoodItemDetails(existingContactRecord)) {
			System.out.println("Successfully deleted");
		} else {
			System.out.println("Error deleting food item");
		}
	}

}
