package store.services;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import Decoder.BASE64Decoder;
import store.model.User;
import store.utill.Constant;
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
			String data = header.substring(header.indexOf(" ") + 1);

			byte[] bytes = new BASE64Decoder().decodeBuffer(data);
			decoded = new String(bytes);
		} catch (Exception ex) {

			throw new NotFoundException();
		}

		String userData[] = decoded.split(":");

		user = db.getUser(userData[0], userData[1]);

		return user;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean registerUser(User user) {
		IDatabase db = new DatabaseImpl();
		boolean result = db.saveData(Constant.USER_TYPE_ROOT, user);

		return result;
	}

}
