package com.vishnu.WishBackend.daoimpl;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vishnu.WishBackend.dao.ProductDao;
import com.vishnu.WishBackend.model.Category;
import com.vishnu.WishBackend.model.Product;

@Component("productDaoImpl")
public class ProductDaoImpl implements ProductDao 
{
	
	@Autowired
	SessionFactory factory;
	
	
	//=============================================Save Supplier Data ========================================
	@Override
	public boolean saveProduct(Product product) {

		Session session=null;
		try
		{
			session=factory.openSession();
			
			System.out.println(product.getProductId());
			session.save(product);
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
	
	
	//=============================================Delete Product Data========================================

	@Override
	public boolean deleteProduct(Product product)
	{
		Session session=factory.openSession();
		session.delete(product);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return true;

	}

	
	//=============================================Get Product Data Based On Supplier Id========================================
	@Override
	public Product getProduct(int productId)
	{
		Session session=factory.openSession();
		Product product=session.get(Product.class, productId);
		session.close();
		return product;

	}

	
	//=============================================Get Product Data List ========================================
	@Override
	public List<Product> getProductrList() 
	{
		Session session=factory.openSession();
		Query query= session.createQuery("from Product");
		List<Product> list=query.list();
		session.close();
		return list;

	}


	@Override
	public boolean editProduct(Product product) {
		Session session=null;
		try
		{
			session=factory.openSession();
			
			session.update(product);
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
	public List<Product> getProductList(Category category)
	{
		Session session=factory.openSession();
		Query query= session.createQuery("from Product where productCategory=:pm");
		query.setParameter("pm", category.getCategoryName());
		List<Product> list=query.list();
		session.close();
		return list;
		
	}

}
