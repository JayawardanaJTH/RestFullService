package store.utill;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DatabaseImpl implements IDatabase {

	@Override
	public <T> boolean saveData(String type, Object data) {
		Document doc = ReadFile.getFile();
		
		
		if(type.contentEquals(Constant.USER_TYPE_ROOT)) {
			
			Node node = doc.getElementsByTagName(type).item(0);
			NamedNodeMap attr = node.getAttributes();
			Node nodeAttr = attr.getNamedItem("id");
			
			int userID = Integer.parseInt(nodeAttr.getTextContent());
			userID++;
			
			System.out.println(userID);
			
			Element user = doc.createElement(Constant.USER_TYPE_NODE);
		}
		else if(type.contentEquals(Constant.ITEM_TYPE_ROOT)) {
			
		}
		else {
			
		}
		return false;
	}

	@Override
	public <T> ArrayList<T> getData(String type) {
		return null;
	}

}
