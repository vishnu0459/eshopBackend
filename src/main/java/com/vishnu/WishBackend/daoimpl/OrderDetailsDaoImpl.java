package com.vishnu.WishBackend.daoimpl;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.sql.ordering.antlr.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vishnu.WishBackend.dao.OrderDetailsDao;
import com.vishnu.WishBackend.model.UserOrder;


@Component
public class OrderDetailsDaoImpl implements OrderDetailsDao
{
	@Autowired
	SessionFactory factory;
	
	@Override
	public boolean saveOrderDetails(UserOrder userOrder) {
		
		Session session=null;
		try
		{
			session=factory.openSession();
			
			session.save(userOrder);
			System.out.println("hello");
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
	public List<UserOrder> getMyOrders(String userName) {
		Session session=factory.openSession();
		Query query= session.createQuery("from UserOrder where user.email=:us");
		query.setParameter("us", userName);
		List<UserOrder> list=query.list();
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return list;
	}

}
