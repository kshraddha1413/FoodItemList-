package Restrorent;

import java.util.ArrayList;

import Restrorent.FoodItemDetails;


public class FoodItemList {
	private ArrayList<FoodItemDetails> foodList;

	public FoodItemList() {
		this.foodList = new ArrayList<FoodItemDetails>();
	}

	public boolean addNewFoodItem(FoodItemDetails details) {
		
		if (findFoodItem(details.getFoodItemName()) >= 0) {
			System.out.println("FoodItem is already on List");
			return false;
		}

		foodList.add(details);
		return true;

	}

	private int findFoodItem(String FoodItemName) {
			for (int i = 0; i <this.foodList.size(); i++) {
				FoodItemDetails details = this.foodList.get(i);
				if (details.getFoodItemName().equals(FoodItemName)) {
					return i;
				}
			}
		
		return -1;
	}

	public boolean updateFoodItem(FoodItemDetails oldDeatils, FoodItemDetails newDeatils) {
		int foundPosition = findFoodItem(oldDeatils);
		if (foundPosition < 0) {
			System.out.println(oldDeatils.getFoodItemName() + ", was not found.");
			return false;
		}

		this.foodList.set(foundPosition, newDeatils);
		System.out.println(oldDeatils.getFoodItemName() + ", was replaced with " + newDeatils.getFoodItemName());
		return true;
	}

	private int findFoodItem(FoodItemDetails details) {
		return this.foodList.indexOf(details);
	}

	public boolean removeFoodItemDetails(FoodItemDetails details) {
		int foundPosition = findFoodItem(details);
		if (foundPosition < 0) {
			System.out.println(details.getFoodItemName() + ", was not found.");
			return false;
		}
		this.foodList.remove(foundPosition);
		System.out.println(details.getFoodItemName() + ", was deleted.");
		return true;
	}

	public void printFoodItemDetails() {
		System.out.println("FoodItems List");
		for (int i = 0; i < this.foodList.size(); i++) {
			System.out.println((i + 1) + "." + this.foodList.get(i).getFoodItemType() + " -> "
					+ this.foodList.get(i).getFoodItemName() + " -> " + this.foodList.get(i).getFoodItemPrice());
		}

	}

	public FoodItemDetails queryFoodItemDeatils(String foodItemname) {
		int position = findFoodItem(foodItemname);
		if (position >= 0) {
			return this.foodList.get(position);
		}

		return null;
	}
	
}
