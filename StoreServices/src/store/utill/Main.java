package store.utill;

import java.util.ArrayList;

import store.model.Item;
import store.model.User;

public class Main {

	public static void main(String[] args) {
		IDatabase db = new DatabaseImpl();
		
//		db.saveData(Constant.USER_TYPE_ROOT, new User("Harsha","tiran2323","asdf","Seller", 1234));
//		db.saveData(Constant.ITEM_TYPE_ROOT, new Item("item2", "this is 2", 300.50));

//		ArrayList<User> list = db.getAllData(Constant.USER_TYPE_ROOT);
//		ArrayList<Item> items = db.getAllData(Constant.ITEM_TYPE_ROOT);
//		
//		for(Item item : items) {
//			
//			System.out.println(item.getName());
//		}
		
//		Item item = db.getItem(2);
		
//		User user = db.getUser("Tiran", "12345");
		
//		System.out.println(user.getUserName());
	}

}
