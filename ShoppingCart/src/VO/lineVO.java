package VO;

public class lineVO {

    private productVO product;
    private int quantity;
   

    public lineVO() {
    }

    public void setProduct(productVO p) {
        product = p;
    }

    public productVO getProduct() {
        return product;
    }

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
        int total = product.getProduct_Price() * quantity;
        return total;
    }
    
    

    
   
   

    
}
