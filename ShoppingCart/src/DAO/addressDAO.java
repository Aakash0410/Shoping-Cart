package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.Regvo;
import VO.addressVO;

public class addressDAO {
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	  
	  Session session =sessionFactory.openSession();

	public void insert(addressVO v){
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

}
