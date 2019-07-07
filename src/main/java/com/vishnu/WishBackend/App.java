package com.vishnu.WishBackend;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vishnu.WishBackend.daoimpl.CategoryDaoImpl;
import com.vishnu.WishBackend.model.Category;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("DbConfig.xml");
    	SessionFactory sessionFactory=(SessionFactory) context.getBean("sessionFactory");
    	
		System.out.println( "Hello World!"+sessionFactory );
    	
    	Category category= new Category();
    	category.setCategoryDiscription("boss");
    	category.setCatergoryId(432);
    	category.setCategoryName("speakers");
    	CategoryDaoImpl categoryDaoImpl= new CategoryDaoImpl();
    	boolean value= categoryDaoImpl.saveCategory(category);
    	System.out.println(value);
    
    }
}
