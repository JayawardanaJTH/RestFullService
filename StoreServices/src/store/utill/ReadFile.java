package store.utill;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class ReadFile {

	public  static Document doc;
	
	public static Document getFile() {
		
		if(doc == null) {
			try {
				File inputFile = new File("dataSource.xml");
				DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
				doc = documentBuilder.parse(inputFile);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		return doc;
	}
}
