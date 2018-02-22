package VO;

import java.io.Serializable;

import javax.servlet.ServletContext;

public class orderVO implements Serializable{

	private int aakash;
	
	private Regvo user_id;
	
	private int creditcard_number;
	private cartVO cart_id;
	
	
	

	
	public int getAakash() {
		return aakash;
	}
	public void setAakash(int aakash) {
		this.aakash = aakash;
	}
	public Regvo getUser_id() {
		return user_id;
	}
	public void setUser_id(Regvo user_id) {
		this.user_id = user_id;
	}
	public int getCreditcard_number() {
		return creditcard_number;
	}
	public void setCreditcard_number(int creditcard_number) {
		this.creditcard_number = creditcard_number;
	}
	public cartVO getCart_id() {
		return cart_id;
	}
	public void setCart_id(cartVO cart_id) {
		this.cart_id = cart_id;
	}
	
	
	
	
}
