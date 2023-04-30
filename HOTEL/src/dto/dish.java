package dto;

import java.io.Serializable;

public class dish implements Serializable {

	private int d_id;
	private double price;
	private String name;
	private String descp;
	private int rating;

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescp() {
		return descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	@Override
	public String toString() {
		return "\n\t\t\t" + d_id + " | " + name + " | " + price + " | "
				+ descp + " | " + rating + "\n\t\t\t--------------------------------------------------------\n";
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
