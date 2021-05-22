package store.utill;

import java.util.ArrayList;

public interface IDatabase {

	public <T> boolean saveData(String type, Object data);
	public <T> ArrayList<T> getData(String type);
}
