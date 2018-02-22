package VO;

public class addressVO {
	
	private int address_id;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private Regvo user_id;
	
	
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Regvo getUser_id() {
		return user_id;
	}
	public void setUser_id(Regvo user_id) {
		this.user_id = user_id;
	}
	
	
	

}
