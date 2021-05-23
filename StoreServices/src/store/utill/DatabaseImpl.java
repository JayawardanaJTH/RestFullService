package store.utill;

import java.io.File;
import java.util.ArrayList;

import javax.ws.rs.NotFoundException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import store.model.Item;
import store.model.User;

public class DatabaseImpl implements IDatabase {

	@Override
	public <T> boolean saveData(String type, Object data) {
		Document doc = ReadFile.getFile();

		if (type.contentEquals(Constant.USER_TYPE_ROOT)) {
			try {
				User userObj = (User) data;

				Node node = doc.getElementsByTagName(type).item(0);
				NamedNodeMap attr = node.getAttributes();
				Node nodeAttr = attr.getNamedItem("id");

				int userID = Integer.parseInt(nodeAttr.getTextContent());
				userID++;

				nodeAttr.setTextContent(Integer.toString(userID));

				Element user = doc.createElement(Constant.USER_TYPE_NODE);

				Element userid = doc.createElement(Constant.USER_ID);
				Element username = doc.createElement(Constant.USER_NAME);
				Element useremail = doc.createElement(Constant.USER_EMAIL);
				Element usercontact = doc.createElement(Constant.USER_CONTACT);
				Element userpassword = doc.createElement(Constant.USER_PASSWORD);
				Element usertype = doc.createElement(Constant.USER_TYPE);

				userid.setTextContent(Integer.toString(userID));
				username.setTextContent(userObj.getUserName());
				useremail.setTextContent(userObj.getEmail());
				usercontact.setTextContent(Integer.toString(userObj.getContact()));
				userpassword.setTextContent(userObj.getPassword());
				usertype.setTextContent(userObj.getType());

				user.appendChild(userid);
				user.appendChild(username);
				user.appendChild(useremail);
				user.appendChild(usercontact);
				user.appendChild(userpassword);
				user.appendChild(usertype);

				node.appendChild(user);

				File inputFile = new File(System.getProperty("catalina.base") + Constant.XML_FILE_NAME);
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				transformer.setOutputProperty(OutputKeys.METHOD, "xml");
				DOMSource source = new DOMSource(doc);
				Result result = new StreamResult(inputFile);
				transformer.transform(source, result);

			} catch (TransformerException e) {
				e.printStackTrace();
				throw new NotFoundException();
			}
		} else if (type.contentEquals(Constant.ITEM_TYPE_ROOT)) {
			try {
				Item itemObj = (Item) data;

				Node node = doc.getElementsByTagName(type).item(0);
				NamedNodeMap attr = node.getAttributes();
				Node nodeAttr = attr.getNamedItem("id");

				int itemID = Integer.parseInt(nodeAttr.getTextContent());
				itemID++;

				nodeAttr.setTextContent(Integer.toString(itemID));
				
				System.out.println(itemID);

				Element item = doc.createElement(Constant.ITEM_TYPE_NODE);

				Element itemid = doc.createElement(Constant.ITEM_ID);
				Element itemname = doc.createElement(Constant.ITEM_NAME);
				Element itemdesc = doc.createElement(Constant.ITEM_DESC);
				Element itemprice = doc.createElement(Constant.ITEM_PRICE);

				itemid.setTextContent(Integer.toString(itemID));
				itemname.setTextContent(itemObj.getName());
				itemdesc.setTextContent(itemObj.getDesc());
				itemprice.setTextContent(Double.toString(itemObj.getPrice()));

				item.appendChild(itemid);
				item.appendChild(itemname);
				item.appendChild(itemdesc);
				item.appendChild(itemprice);

				node.appendChild(item);

				File inputFile = new File(System.getProperty("catalina.base") + Constant.XML_FILE_NAME);
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				transformer.setOutputProperty(OutputKeys.METHOD, "xml");
				DOMSource source = new DOMSource(doc);
				Result result = new StreamResult(inputFile);
				transformer.transform(source, result);

			} catch (TransformerException e) {
				e.printStackTrace();
				throw new NotFoundException();
			}
		} else {

		}
		return true;
	}

	@Override
	public <T> ArrayList<T> getAllData(String type) {

		Document doc = ReadFile.getFile();

		if (type.contentEquals(Constant.USER_TYPE_ROOT)) {

			NodeList nodeList = doc.getElementsByTagName(Constant.USER_TYPE_NODE);
			Element element = null;
			Node node = null;
			ArrayList<User> arrayList = new ArrayList<User>();

			for (int value = 0; value < nodeList.getLength(); value++) {
				element = (Element) nodeList.item(value);
				User user = new User();

				user.setId(Integer.parseInt(element.getElementsByTagName(Constant.USER_ID).item(0).getTextContent()));
				user.setUserName(element.getElementsByTagName(Constant.USER_NAME).item(0).getTextContent());
				user.setEmail(element.getElementsByTagName(Constant.USER_EMAIL).item(0).getTextContent());
				user.setContact(
						Integer.parseInt(element.getElementsByTagName(Constant.USER_CONTACT).item(0).getTextContent()));

				arrayList.add(user);

			}
			return (ArrayList<T>) arrayList;

		} else if (type.contentEquals(Constant.ITEM_TYPE_ROOT)) {
			NodeList nodeList = doc.getElementsByTagName(Constant.ITEM_TYPE_NODE);
			Element element = null;
			Node node = null;
			ArrayList<Item> arrayList = new ArrayList<Item>();

			for (int value = 0; value < nodeList.getLength(); value++) {
				element = (Element) nodeList.item(value);
				Item item = new Item();

				item.setId(Integer.parseInt(element.getElementsByTagName(Constant.ITEM_ID).item(0).getTextContent()));
				item.setName(element.getElementsByTagName(Constant.ITEM_NAME).item(0).getTextContent());
				item.setDesc(element.getElementsByTagName(Constant.ITEM_DESC).item(0).getTextContent());
				item.setPrice(
						Double.parseDouble(element.getElementsByTagName(Constant.ITEM_PRICE).item(0).getTextContent()));

				arrayList.add(item);

			}
			return (ArrayList<T>) arrayList;
		} else {

		}

		throw new NotFoundException();
	}

	@Override
	public Item getItem(int id) {
		Document doc = ReadFile.getFile();

		NodeList nodeList = doc.getElementsByTagName(Constant.ITEM_TYPE_NODE);
		Element element = null;
		Node node = null;
		Item item = new Item();

		for (int value = 0; value < nodeList.getLength(); value++) {
			element = (Element) nodeList.item(value);

			if (Integer.parseInt(element.getElementsByTagName(Constant.ITEM_ID).item(0).getTextContent()) == id) {

				item.setId(Integer.parseInt(element.getElementsByTagName(Constant.ITEM_ID).item(0).getTextContent()));
				item.setName(element.getElementsByTagName(Constant.ITEM_NAME).item(0).getTextContent());
				item.setDesc(element.getElementsByTagName(Constant.ITEM_DESC).item(0).getTextContent());
				item.setPrice(
						Double.parseDouble(element.getElementsByTagName(Constant.ITEM_PRICE).item(0).getTextContent()));

				break;
			}

		}
		return item;
	}

	@Override
	public User getUser(String username, String password) {
		Document doc = ReadFile.getFile();

		NodeList nodeList = doc.getElementsByTagName(Constant.USER_TYPE_NODE);
		Element element = null;
		Node node = null;
		User user = null;

		for (int value = 0; value < nodeList.getLength(); value++) {
			element = (Element) nodeList.item(value);

			if (element.getElementsByTagName(Constant.USER_NAME).item(0).getTextContent().trim().contentEquals(username)
					&& element.getElementsByTagName(Constant.USER_PASSWORD).item(0).getTextContent().trim()
							.contentEquals(password)) {

				user = new User();
				user.setId(Integer.parseInt(element.getElementsByTagName(Constant.USER_ID).item(0).getTextContent()));
				user.setUserName(element.getElementsByTagName(Constant.USER_NAME).item(0).getTextContent());
				user.setEmail(element.getElementsByTagName(Constant.USER_EMAIL).item(0).getTextContent());
				user.setType(element.getElementsByTagName(Constant.USER_TYPE).item(0).getTextContent());
				user.setContact(
						Integer.parseInt(element.getElementsByTagName(Constant.USER_CONTACT).item(0).getTextContent()));

				break;
			}

		}

		if (user == null) {
			throw new NotFoundException();
		} else {

			return user;
		}
	}

	@Override
	public boolean deleteData(String type, int id) {
		Document doc = ReadFile.getFile();

		if (type.contentEquals(Constant.USER_TYPE_ROOT)) {
			
		}else if (type.contentEquals(Constant.ITEM_TYPE_ROOT)) {
			
			Node node = doc.getElementsByTagName(Constant.ITEM_TYPE_NODE).item(0);
			
			NodeList nodeList = node.getChildNodes();
			Element element = null;
			Item item = new Item();

			for (int value = 0; value < nodeList.getLength(); value++) {
				element = (Element) nodeList.item(value);

				if (Integer.parseInt(element.getElementsByTagName(Constant.ITEM_ID).item(0).getTextContent()) == id) {

					node.removeChild(element);
					
					File inputFile = new File(System.getProperty("catalina.base") + Constant.XML_FILE_NAME);
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer;
					try {
						transformer = transformerFactory.newTransformer();
						transformer.setOutputProperty(OutputKeys.METHOD, "xml");
						DOMSource source = new DOMSource(doc);
						Result result = new StreamResult(inputFile);
						transformer.transform(source, result);
					} catch (TransformerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}

			}
		}
		return false;
	}

}
