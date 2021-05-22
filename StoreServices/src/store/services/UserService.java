package store.services;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import Decoder.BASE64Decoder;
import store.model.User;
import store.utill.DatabaseImpl;
import store.utill.IDatabase;

@Path("/UserService")
public class UserService {

	@Context
	private HttpServletRequest request;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser() {
		String decoded = null;
		User user = null;
		IDatabase db = new DatabaseImpl();

		try {
			String header = request.getHeader("authorization");
			System.out.println(header);
			String data = header.substring(header.indexOf(" ") + 1);

			byte[] bytes = new BASE64Decoder().decodeBuffer(data);
			decoded = new String(bytes);
		} catch (Exception ex) {
			user = new User();

			return user;
		}

		String userData[] = decoded.split(":");
		System.out.println(userData);

		user = db.getUser(userData[0], userData[1]);

		return user;
	}

}
