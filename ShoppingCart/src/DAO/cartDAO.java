package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import VO.Regvo;
import VO.cartVO;
import VO.productVO;

public class cartDAO {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	  
	  Session session =sessionFactory.openSession();

	public void insert(cartVO v){
		try
		{
			  
		     System.out.println("You are in insert method");
			  Transaction tr = session.beginTransaction();
			  
			  session.save(v);
			  
			  tr.commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
}
	
public List search(cartVO v){
		
		List l=new ArrayList();
		
		try
		{
			 
		   
			  Query q=session.createQuery("from cartVO where activeflag='Y' and User_Id='"+v.getLogin_id().getUser_id()+"'"); 
			  
			 
			  
			  l=q.list();
			  
			  
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return l;
	}




public void update(cartVO v){
	
	 
	
	try
	{	  
	   
		 Query q=session.createQuery("UPDATE cartVO as a SET a.quantity='"+v.getQuantity()+"' where a.product_id='"+v.getProduct_id().getProduct_Id()+"'") ;	
		 
		 Transaction tr = session.beginTransaction();
		 
		 q.executeUpdate();
		 
		 tr.commit();
		 
		
		 
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}

public void updateflag(cartVO v){
	
	 
	
	try
	{	  
	   
		 Query q=session.createQuery("UPDATE cartVO as a SET a.activeflag='"+v.getActiveflag()+"' where a.login_id='"+v.getLogin_id().getUser_id()+"'") ;	
		 
		 Transaction tr = session.beginTransaction();
		 
		 q.executeUpdate();
		 
		 tr.commit();
		 
		
		 
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}
	
	public void remove(cartVO v){
		
		 
		
		try
		{	  
		   
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.delete(v);
			
			tr.commit();

			
			 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		

}
	
public void delete(cartVO v){
		
		 
		
		try
		{	  
		   
			 Query q=session.createQuery("delete from cartVO where User_Id='"+v.getLogin_id().getUser_id()+"'") ;	
			
			
			Transaction tr = session.beginTransaction();
			
			q.executeUpdate();
			
			tr.commit();

			
			 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		

}


	
	
	
}
