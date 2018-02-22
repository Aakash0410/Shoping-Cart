package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import VO.order_VO;
import VO.productVO;

public class orderDAO {

	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	  
	  Session session =sessionFactory.openSession();

	public void insert(order_VO v){
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
	
	
public List search(order_VO v){
		
		List l=new ArrayList();
		
		try
		{
			 
		   
			  Query q=session.createQuery("from order_VO where creditcard_number='"+v.getCreditcard_number()+"' and user_id='"+v.getUser_id().getUser_id()+"'" );
			  
			 
			  
			  l=q.list();
			  
			  
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return l;
	}

}
