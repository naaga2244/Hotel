package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dto.Bill;
import dto.dish;

public class BillMain {

	static Scanner s = new Scanner(System.in);
	static List<dish> ds = new ArrayList<dish>();
	static Writer writer;
	static Bill bs = new Bill();

	public static void enterdish() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean a = true;
		int ordno = 1;// initializing order number for auto increment
		String exit;
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		while (a) {
			Date date1 = new Date();

			System.out.println("***Welcome to Hotel-TY***");
			System.out.print("Order? Y/N/Exit: ");
			exit = s.next();
			if (exit.equals("Y")) {

				// reate new object for list of dish

				// Date object in to string
				String date;
				date = simpleDateFormat.format(date1);

				String uname;
				System.out.print("\nCustome_Name: ");
				uname = s.next();
				bs.setOrder_no(ordno);
				bs.setDate(date);
				int dno = 0;

				boolean b = true;
				// boolean b1 = true;
				System.out.println("Bill: " + ordno);
				System.out.println("Date: " + date);

				while (b) {

					System.out.println("Enter your choice:");
					System.out.println(
							"1.Add Dish\n2.Remove Dish\n3.Search\n4.Show by Price\n5.Total\n6.Generate Bill\n7.Exit");
					System.out.print("Choice?  :");
					int choice = s.nextInt();
					dish Dish = new dish();
					bs.setDishes(ds);

					switch (choice) {
					case 1:
						System.out.println();
						dno += 1;
						System.out.println("Dish No:" + dno + "\n");
						System.out.print("Dish Name:");
						String dname = s.next();
						System.out.println();
						System.out.print("Price:");
						double price = s.nextDouble();
						System.out.println();
						System.out.print("Description:");
						String descp = s.next();
						System.out.println();
						System.out.print("Ratings:");
						int rating = s.nextInt();
						System.out.println();

						Dish.setD_id(dno);
						Dish.setName(dname);
						Dish.setPrice(price);
						Dish.setDescp(descp);
						Dish.setRating(rating);

						bs.addDish(Dish);

						// add
						break;

					case 2:
						// remove
						int di = 0;
						List<dish> removelist = bs.getDishes();
						for (dish dish2 : removelist) {
							System.out.println("\t" + di + ": " + dish2.getName());
							di++;
						}
						System.out.println("select your dish");
						int deldish = s.nextInt();
						removelist.remove(deldish);
						bs.setDishes(removelist);
						System.out.println(bs.getDishes());

						break;

					case 3:
						// search
						break;

					case 4:
						// sortbyprice
						List<dish> srt = bs.getDishes();

						int i1 = 0;
						Collections.sort(srt, bs.dishcompareTo);
						for (dish dish2 : srt) {
							System.out.println("\t\t\t" + i1 + "." + dish2.getName() + "\t    " + dish2.getPrice()
									+ "\t   " + dish2.getDescp() + "    " + dish2.getRating());
							i1++;
						}

						break;

					case 5:
						// calculateTotal
						int i = 1;
						int total = 0;
						List<dish> d = bs.getDishes();
						for (dish dish2 : d) {
							total += dish2.getPrice();
							System.out.println("\t\t" + i + "." + dish2.getName() + "||         " + dish2.getPrice()
									+ "       ||" + dish2.getDescp() + "\n\t\t-------------------------------------");
							i++;
						}
						System.out.println("\t\t\tTotal: " + total + "\n\t\t\t------------------------");
						break;

					case 6:
						System.out.println(bs.BillDetails());
						String path = ordno + "-" + uname + ".txt";
						String s1 = "\t\t\t******Welcome to A2B Restaurent********\n\t\t\t" + uname + bs.BillDetails();
						try {
							writer = new FileWriter(path);
							writer.write(s1);
							writer.flush();
							writer.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						System.out.println("\t\t\tBill has been Generated");
						// bill
						break;

					case 7:
						// exit
						b = false;
						System.out.println("---------EXIT-----------");
						bs.setDishes(null);
						break;
					default:
						System.out.println("*************************");
						break;
					}
				}

			} else if (exit.equals("N")) {
				ordno += ordno;
				System.out.println(ordno);

			}

			else if (exit.equals("Exit")) {
				a = false;
				System.out.println("Closing the Bill Set-Up!....");
			}
		}

	}
}
