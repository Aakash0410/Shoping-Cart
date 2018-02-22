package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import VO.Regvo;


public class loginDAO {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	  
	  Session session =sessionFactory.openSession();
 
	
public List authentication(Regvo v){
		
		List l=new ArrayList();
		
		try
		{
			 
		   
			  Query q=session.createQuery("from Regvo where email='"+v.getEmail()+"' and password='"+v.getPassword()+"' ");
			  
			 
			  
			  l=q.list();
			  
			  
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return l;
	}

}
