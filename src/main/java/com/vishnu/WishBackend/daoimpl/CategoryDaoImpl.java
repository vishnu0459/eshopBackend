package com.vishnu.WishBackend.daoimpl;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.vishnu.WishBackend.dao.CategoryDao;
import com.vishnu.WishBackend.model.Category;



@Component("catDaoimpl")
public class CategoryDaoImpl implements CategoryDao
{
	@Autowired
	SessionFactory sessionFactory;
	//=============================================SAVE CATEGORY========================================
	
   public boolean saveCategory(Category category)
   {
		System.out.println("~~~~~~"+sessionFactory);
		Session session=null;
		try 
		{
			session=sessionFactory.openSession();
			/*
			 * if(category.getCatergoryId()==0) { Random random=new Random();
			 * category.setCatergoryId(random.nextInt(10000)); }
			 */
			session.save(category);
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
		System.out.println("hello finnaly");
	}
	
		//=============================================Delete CATEGORY========================================
		
	}

	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.delete(category);
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return true;
	}

	
	//=============================================GET CATEGORY DATA========================================
	public Category getCategory(int categoryId) {
		Session session=sessionFactory.openSession();
		Category category=session.get(Category.class,categoryId);
		session.close();
		return category;

	}
	//=============================================GET CATEGORY LIST DATA========================================
	public List<Category> getCategoryList() {
		
		Session session = sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> list=query.list();
		 
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return list;

		
	}

	@Override
	public boolean editCategory(Category category) {
		Session session=null;
		try 
		{
			session=sessionFactory.openSession();
			/*
			 * if(category.getCatergoryId()==0) { Random random=new Random();
			 * category.setCatergoryId(random.nextInt(10000)); }
			 */
			session.update(category);
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

}
