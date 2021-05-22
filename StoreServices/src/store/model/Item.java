package store.model;

public class Item {

	private int id;
	private String name;
	private String desc;
	private double price;
	
	public Item() {
		super();
	}

	public Item(String name, String desc, double price) {
		super();
		this.name = name;
		this.desc = desc;
		this.price = price;
	}

	public Item(int id, String name, String desc, double price) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
