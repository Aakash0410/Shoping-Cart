package VO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class cartItems {
	
	 private ArrayList<lineVO> items;
	
	    public cartItems() {
	        items = new ArrayList<lineVO>();
	    }

	    public ArrayList<lineVO> getItems() {
	        return items;
	    }
	    
	    

	  

	    

		public void setItems(ArrayList<lineVO> items) {
			this.items = items;
		}

		public void addItem(lineVO item) {
	    	  String name = item.getProduct().getProduct_Name();
	    	  System.out.println("Name is"+name);
	          int quantity = item.getQuantity();
	          for (lineVO cartItem : items) 
	          {
	        	  String name1=cartItem.getProduct().getProduct_Name();
	        	  System.out.println("Name"+name1);
	              if (cartItem.getProduct().getProduct_Name().equals(name))
	              {
	            	  System.out.println("Aakash Shah");
	                  cartItem.setQuantity(quantity);
	                  return;
	              }
	          }
	       
	          items.add(item);
	     	    }
	    
	   public void removeItem(lineVO item) {
	        String name = item.getProduct().getProduct_Name();
	        int price= item.getProduct().getProduct_Price();
	        int id=item.getProduct().getProduct_Id();
	        for (int i = 0; i < items.size(); i++) {
	            lineVO linevo = items.get(i);
	            if (linevo.getProduct().getProduct_Name().equals(name) && linevo.getProduct().getProduct_Id()==id && linevo.getProduct().getProduct_Price()==price ) {
	                items.remove(i);
	                return;
	                
	            }
	        }
	        
	       
	    }
	   
	

}
