package com.vishnu.WishBackend.daoimpl;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vishnu.WishBackend.dao.CartDao;
import com.vishnu.WishBackend.model.Cart;
import com.vishnu.WishBackend.model.Product;


@Component("cartDaoImpl")
public class CartDaoImpl implements CartDao
{
	@Autowired
	SessionFactory factory;

	

	

	public boolean deleteCart(Cart cart) {


		Session session=factory.openSession();
		session.delete(cart);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();

		return true;
	}


	public Cart getCart(int cartId) {
		Session session=factory.openSession();
		Cart cart =session.get(Cart.class, cartId);
		session.close();
		return cart;

	}

	public List<Cart> getCartList(String uname) {
		
		Session session=factory.openSession();
		
		Query query=session.createQuery("from Cart where username=:un");
		query.setParameter("un", uname);
		
		List<Cart> list=(List<Cart>)query.list();
		return list;
	}


	@Override
	public boolean saveCart(Cart cart) {
		Session session=null;
		try
		{
			 session=factory.openSession(); 
			 if(cart.getCartId()==0)
			 {
				 int  id=(int)(Math.random()*10000); 
				 cart.setCartId(id);
				 }
				  cart.setProductId(cart.getProductId());
				  cart.setProductName(cart.getProductName());
				  cart.setProductPrice(cart.getProductPrice());
				  cart.setProductSupplier(cart.getProductSupplier());
				  cart.setQuantity(cart.getQuantity());
				  cart.setCartTotalPrice(cart.getProductPrice()*cart.getQuantity());
				  cart.setUserName(cart.getUserName()); 
				  session.save(cart); 
				 Transaction transaction=session.beginTransaction(); 
			 transaction.commit(); 
			 return true;
			 }
				  catch (Exception e) 
					{
					  return false; 
					  }
		 finally
		 {
			session.close(); 
				  }
	}



	@Override
	public boolean editCart(Cart cart) {
		Session session=null;
		try
		{
			session=factory.openSession();
		
			 session=factory.openSession(); 
			 if(cart.getCartId()==0)
			 {
				 int  id=(int)(Math.random()*10000); 
				 cart.setCartId(id);
				 }
				 cart.setProductId(cart.getProductId());
				  cart.setProductName(cart.getProductName());
				  cart.setProductPrice(cart.getProductPrice());
				  cart.setProductSupplier(cart.getProductSupplier());
				  int quantity=cart.getQuantity();
				  cart.setQuantity(quantity);
				  cart.setCartTotalPrice(cart.getProductPrice()*cart.getQuantity());
				String userName= cart.getUserName();
				  cart.setUserName(userName); 
			 session.update(cart);   
			 Transaction transaction=session.beginTransaction();
			 transaction.commit(); 
			 return true;
			 }
				  catch (Exception e) 
					{
					  return false; 
					  }
		 finally
		 {
			session.close(); 
				  }
	}

}
