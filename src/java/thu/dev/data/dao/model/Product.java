package thu.dev.data.dao.model;

import thu.dev.data.dao.DatabaseDao;
import java.sql.Timestamp;
import thu.dev.data.dao.Database;

public class Product {
	private int id;
	private String name ;
	private String description;
	private double price;
	private int quantity;
	private int view;
	private Timestamp createdAt;
	private int categoryId;
        private String img;
	
	public Product(String name, String description, double price, int quantity, int view, Timestamp createdAt,
			int categoryId,String img) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.view = view;
		this.createdAt = createdAt;
		this.categoryId = categoryId;
                this.img = img;
	}
	public Product(int id, String name, String description, double price, int quantity, int view, Timestamp createdAt,
			int categoryId,String img) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.view = view;
		this.createdAt = createdAt;
		this.categoryId = categoryId;
                this.img = img;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoyId) {
		this.categoryId = categoyId;
	}
        public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
        public Category getCategory() {
        return Database.getInstance().getCategoryDao().find(categoryId);
    }
}
