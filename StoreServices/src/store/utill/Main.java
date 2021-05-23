package store.utill;

import java.util.ArrayList;

import com.twilio.Twilio;
import com.twilio.converter.Promoter; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber; 
 
import java.net.URI; 
import java.math.BigDecimal;
import store.model.Item;
import store.model.User;

public class Main {
	// Find your Account Sid and Token at twilio.com/console 
    public static final String ACCOUNT_SID = "ACd72fb73389057fb4b8934e5c770f9f44"; 
    public static final String AUTH_TOKEN = "376d8317808f35ca9e4e1b0f8d8df7e6"; 
    
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
		
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("+94769036197"),  
                "MG87b2ebde5183a5fc59a3f4ab480e2114", 
                "Your payment is successful ")      
            .create(); 
 
        System.out.println(message.getSid()); 
		
		
	}

}
