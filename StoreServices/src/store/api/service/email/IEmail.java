package store.api.service.email;

import store.model.User;

public interface IEmail {

	public void sendEmail(User user);
}
