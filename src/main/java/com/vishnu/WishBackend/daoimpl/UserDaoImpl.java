package com.vishnu.WishBackend.daoimpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vishnu.WishBackend.dao.UserDao;
import com.vishnu.WishBackend.model.UserRegister;


@Component
public class UserDaoImpl implements UserDao

{
	@Autowired
	SessionFactory factory;


	@Override
	public boolean addUser(UserRegister user) {
		Session session=null;
		try
		{
			session=factory.openSession();
			
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			session.save(user);
			Transaction transaction=session.beginTransaction();
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		finally {
			session.close();	
		}
	



	}

	@Override
	public boolean checkLogin(UserRegister user) {


		Session session= factory.openSession();
		Query query= session.createQuery("from UserRegister where email=:em and password=:pw");
		query.setParameter("em", user.getEmail());
		query.setParameter("pw", user.getPassword());
		UserRegister us=null;
		us=(UserRegister)query.uniqueResult();
		System.out.println(us);
		if(us!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}

	
	



	@Override
	public UserRegister getUser(String email) {
		 
		Session session=factory.openSession();
		Query query= session.createQuery("from UserRegister where email=:em");
		query.setParameter("em", email);
		UserRegister register=(UserRegister) query.uniqueResult();
		
		return register;
	}
	

	
	 public boolean editUser(UserRegister user) {
	        Session session=null;
	        try {
	            session    =factory.openSession();
	            session.update(user);
	        Transaction transaction=    session.beginTransaction();
	        transaction.commit();
	         
	            return true;
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	          
	            return false;
	        }
	        finally
	        {
	            session.close();
	        }
	}
}
