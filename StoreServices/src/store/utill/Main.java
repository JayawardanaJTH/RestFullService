package store.utill;

public class Main {

	public static void main(String[] args) {
		IDatabase db = new DatabaseImpl();
		
		db.saveData("users", null);

	}

}
