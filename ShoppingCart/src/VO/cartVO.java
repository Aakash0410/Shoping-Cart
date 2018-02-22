package VO;

public class cartVO {

	private productVO product_id;
	private Regvo login_id;
	private int cart_id;
	private int quantity;
	private String name;
	private int price;
	private String activeflag;
	
	
	
	public String getActiveflag() {
		return activeflag;
	}
	public void setActiveflag(String activeflag) {
		this.activeflag = activeflag;
	}
	public productVO getProduct_id() {
		return product_id;
	}
	public void setProduct_id(productVO product_id) {
		this.product_id = product_id;
	}
	public Regvo getLogin_id() {
		return login_id;
	}
	public void setLogin_id(Regvo login_id) {
		this.login_id = login_id;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
	
	
	
	
}
