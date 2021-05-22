package store.utill;

import java.util.ArrayList;

import store.model.Item;
import store.model.User;

public interface IDatabase {

	public <T> boolean saveData(String type, Object data);
	public <T> ArrayList<T> getAllData(String type);
	public Item getItem(int id);
	public User getUser(String username, String password);
}
