package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.Regvo;
import VO.productVO;


public class productDAO {
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	  
	  Session session =sessionFactory.openSession();
	  
		public void insert(productVO v){
			try
			{
				  
			   
				  Transaction tr = session.beginTransaction();
				  
				  session.save(v);
				  
				  tr.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	}
	
	
	
public List search(productVO v){
		
		List l=new ArrayList();
		
		try
		{
			 
		   
			  Query q=session.createQuery("from productVO");
			  
			 
			  
			  l=q.list();
			  
			  
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return l;
	}


public List display(productVO v){
	
	List l=new ArrayList();
	
	try
	{
		 
	   
		  Query q=session.createQuery("from productVO where product_Id='"+v.getProduct_Id()+"' ");
		  
		 
		  
		  l=q.list();
		  
		  
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return l;
}


}


