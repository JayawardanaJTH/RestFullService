package store.utill;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DatabaseImpl implements IDatabase {

	@Override
	public <T> boolean saveData(String type, Object data) {
		Document doc = ReadFile.getFile();
		
		NodeList rootNode = doc.getElementsByTagName(type);
		System.out.println(rootNode.getLength());
		
		if(type.contentEquals("")) {
			
		}
		return false;
	}

	@Override
	public <T> ArrayList<T> getData(String type) {
		return null;
	}

}
