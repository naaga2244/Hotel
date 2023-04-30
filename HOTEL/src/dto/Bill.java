package dto;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class Bill implements Serializable {

	private int order_no;
	private String date;
	private List<dish> dishes;

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<dish> dishes) {
		this.dishes = dishes;
	}

	public void addDish(dish d) {
		this.dishes.add(d);
		System.out.println("Dish added\n***********");
	}

	public void removeDish(int id) {
		this.dishes.remove(id - 1);
		System.out.println("Dish removed\n***********");
	}

	public String BillDetails() {
		return "\n\n\t\t\t\t-------------------------------\n\t\t\torder_no: " + order_no + "\t\t\t\tdate: " + date
				+ "\n\n\t\t\tdishes you ordered\n\t\t\t****************************************************\n\t\t\tDishno | Name | Price | About | Rating "
				+ dishes + "\n\t\t\t***********Thank You Enjoy your visit**************\n";
	}

	public static Comparator<dish> dishcompareTo = new Comparator<dish>() {

		@Override
		public int compare(dish o1, dish o2) {
			// TODO Auto-generated method stub
			int d1 = (int) o1.getPrice();
			int d2 = (int) o2.getPrice();
			return d1 - d2;
		}
	};
}
