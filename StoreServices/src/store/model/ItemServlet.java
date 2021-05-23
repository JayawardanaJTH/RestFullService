package store.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import store.utill.Constant;
import store.utill.DatabaseImpl;
import store.utill.IDatabase;

public class ItemServlet {

	public static String readitems() {

		// System.out.println("GET");
		IDatabase db = new DatabaseImpl();
		String output = "";

		try {
			// Prepare the html table to be displayed

			output = "<div class=''><table class='table table-hover table-bordered table-striped table-bordered' style='width:100%' style='text-align:center'><thead class='thead-dark'>"
					+ "<th style='padding:10px; text-align:center;'>Item Code</th>"
					+ "<th style='padding:10px; text-align:center;'>Item Name</th>"
					+ "<th style='padding:10px; text-align:center;'>Item Description</th>"
					+ "<th style='padding:10px; text-align:center;'>Item Price</th>"
					+ "<th style='padding:10px; text-align:center;'>Status</th>"
					+ "<th style='padding:10px; text-align:center;'>Update</th><th class='text-center'>Remove</th></thead>";

			ArrayList<Item> list = db.getAllData(Constant.ITEM_TYPE_ROOT);
			// iterate through the rows in the result set
			for (Item rs : list) {
				String itemCode = Integer.toString(rs.getId());
				String itemName = rs.getName();
				String itemDesc = rs.getDesc();
				String itemPrice = Double.toString(rs.getPrice());
				String itemStatus = "0";

//				System.out.println(itemCode);
//				System.out.println(itemName);

				// Add into the html table
				output += "<tbody><td style='padding:10px; text-align:center;'>" + itemCode + "</td>";
				output += "<td style='padding:10px; text-align:center;'>" + itemName + "</td>";
				output += "<td style='padding:10px; text-align:center;'>" + itemDesc + "</td>";
				output += "<td style='padding:10px; text-align:center;'>" + itemPrice + "</td>";
				output += "<td style='padding:10px; text-align:center;'>" + itemStatus + "</td>";

				// buttons

				output += "<td class='text-center'><input id='update' onclick='click_update();' name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-success'></td>"
						+ "<td class='text-center'><button class='btnRemove btn btn-danger' name='btnRemove' id ='btnRemove' value='"
						+ itemCode + "' >Remove</button></td></tbody>";

			}
			// Complete the html table
			output += "</table></div>";
		} catch (Exception e) {
			output = "Error while reading the item details...!";
			System.out.println(e.getMessage());
			System.out.println(e);
			e.printStackTrace();
		}
		return output;
	}

	// insert
	public String insertitem(String item_category, String item_name, String item_des, String price, String date) {

		String output = "";
		try {
			IDatabase db = new DatabaseImpl();

			Item item = new Item(item_name, item_des, Double.parseDouble(price));

			db.saveData(Constant.ITEM_TYPE_ROOT, item);

			String newitem = readitems();
			output = "{\"status\":\"success\", \"data\": \"" + newitem + "\"}";

			// output = "item Details have been Inserted Successfully !";

		} catch (Exception e) {
			// output = "item Details Inserted Failed";
			System.out.println(e.getMessage());
			System.out.println(e);
			e.printStackTrace();
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the order.\"}";

		}

		return output;
	}

	// update
	public String updateitem(String itemCode, String item_category, String item_name, String item_des, String price,
			String date) {

		String output = "";

		try {

			String newitem = readitems();

			output = "{\"status\":\"success\", \"data\": \"" + newitem + "\"}";

			// output = "item details have been updated successfully...!";

		} catch (Exception e) {

			output = "{\"status\":\"error\", \"data\": \"Error while updating the order.\"}";

			// output = "Error while updating item details...!";
			System.err.println(e.getMessage());
			System.out.println(e.getMessage());
			System.out.println(e);
			e.printStackTrace();
		}

		return output;

	}

	// delete
	public String deleteitem(String item_code) {

		String output = "";

		try {

			
			String newitem = readitems();

			output = "{\"status\":\"success\", \"data\": \"" + newitem + "\"}";

			// output = "item has been deleted successfully";

		} catch (Exception e) {

			output = "{\"status\":\"error\", \"data\": \"Error while deleting the order.\"}";

			// output = "Error while deleting the item from the database.";
			System.err.println(e.getMessage());
			System.out.println(e.getMessage());
			System.out.println(e);
			e.printStackTrace();

		}

		return output;

	}

}
