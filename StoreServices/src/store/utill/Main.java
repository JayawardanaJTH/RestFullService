package store.utill;

import store.model.User;

public class Main {

	public static void main(String[] args) {
		IDatabase db = new DatabaseImpl();
		
		db.saveData(Constant.USER_TYPE_ROOT, new User("Harsha","tiran2323","asdf","Seller", 1234));

	}

}
