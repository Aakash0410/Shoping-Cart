package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.addressVO;
import VO.cardVO;

public class cardDAO {
	

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	  
	  Session session =sessionFactory.openSession();

	public void insert(cardVO v){
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
