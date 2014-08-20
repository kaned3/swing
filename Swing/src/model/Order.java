package model;
import java.util.ArrayList;

public class Order extends Invoice{

	private Supplier supplier;
	private int id;
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public Order(){
		super();
		this.supplier = new Supplier();
		this.id = 0;
	}
	
	public Order(int id, ArrayList<Product> products, Supplier supplier) {
		this.products = products;
		this.supplier = supplier;
		this.id = id;
		calculatePrice();
	}
	
	public void calculatePrice(){
		double price = 0;
		for(Product product: products){
			price += product.getSupplierPrice() * product.getQuantity();
		}
		super.setTotalPrice(price);
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
}
