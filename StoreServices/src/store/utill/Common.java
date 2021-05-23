package store.utill;

import java.io.IOException;
import java.util.Properties;

public class Common {

	public static final Properties PROPERTIES = new Properties();
	
	static {
		
		try {
			PROPERTIES.load(Common.class.getResourceAsStream(Constant.PROPERTY_FILE));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
