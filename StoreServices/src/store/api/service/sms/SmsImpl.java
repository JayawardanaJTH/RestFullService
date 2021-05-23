package store.api.service.sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import store.model.User;
import store.utill.Common;
import store.utill.Constant;

public class SmsImpl implements ISms {

	@Override
	public void sendSms(User user) {

		Twilio.init(Common.PROPERTIES.getProperty(Constant.PROPERTY_ACCOUNT_SID), 
				Common.PROPERTIES.getProperty(Constant.PROPERTY_AUTH_TOKEN)); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("+94"+Integer.toString(user.getContact())),  
                Common.PROPERTIES.getProperty(Constant.PROPERTY_SMS_SECRET_KEY), 
                "Dear coustomer your payment is successful Thankyou").create(); 
	}

}
