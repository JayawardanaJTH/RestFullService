package store.services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import store.model.Item;
import store.utill.Constant;
import store.utill.DatabaseImpl;
import store.utill.IDatabase;

@Path("/ItemService")
public class ItemService {
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Item getItem(@PathParam("id") int id) {
		IDatabase db = new DatabaseImpl();
		Item item = db.getItem(id);
		
		return item;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean saveItem(Item item) {
		IDatabase db = new DatabaseImpl();
		boolean result = db.saveData(Constant.ITEM_TYPE_ROOT, item);
		
		return result;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Item> getAllItems() {
		IDatabase db = new DatabaseImpl();
		ArrayList<Item> list = db.getAllData(Constant.ITEM_TYPE_ROOT);
		
		return list;
	}
	
}
