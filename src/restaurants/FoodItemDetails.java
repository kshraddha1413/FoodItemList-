package Restrorent;

public class FoodItemDetails {
	private String foodItemType;
	private String foodItemName;
	private double foodItemPrice;

	public String getFoodItemType() {
		return foodItemType;
	}

	public void setFoodItemType(String foodItemType) {
		this.foodItemType = foodItemType;
	}

	public String getFoodItemName() {
		return foodItemName;
	}

	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}

	public double getFoodItemPrice() {
		return foodItemPrice;
	}

	public void setFoodItemPrice(double foodItemPrice) {
		this.foodItemPrice = foodItemPrice;
	}

	public FoodItemDetails(String foodItemType, String foodItemName, double foodItemPrice) {
		super();
		this.foodItemType = foodItemType;
		this.foodItemName = foodItemName;
		this.foodItemPrice = foodItemPrice;
	}

	public static FoodItemDetails createFoodItem(String foodItemType, String foodItemName, double foodItemPrice) {
		return new FoodItemDetails(foodItemType, foodItemName, foodItemPrice);
	}
}
