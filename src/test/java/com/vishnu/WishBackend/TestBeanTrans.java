package com.vishnu.WishBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vishnu.WishBackend.daoimpl.CategoryDaoImpl;
import com.vishnu.WishBackend.model.Category;

public class TestBeanTrans {
	static CategoryDaoImpl categoryDaoImpl;
	static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	@BeforeClass
	public static void test1()
	{
		
		annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.vishnu.WishBackend");
		annotationConfigApplicationContext.refresh();
		 categoryDaoImpl=(CategoryDaoImpl)annotationConfigApplicationContext.getBean("catDaoimpl");	
	}
	
	@Test
	public void saveCat_positiveTest()
	{
		Category category= new Category();
    	category.setCategoryDiscription("boss");
    	category.setCatergoryId(1228);
    	category.setCategoryName("speakers");
		
		assertEquals("Success",true, categoryDaoImpl.saveCategory(category));
		//annotationConfigApplicationContext.refresh();
	}
	@Test
	public void saveCat_NegativeTest()
	{
		Category category= new Category();
    	category.setCategoryDiscription("boss");
    	category.setCatergoryId(1228);
    	category.setCategoryName("speakers");
    	assertEquals("fail",false, categoryDaoImpl.saveCategory(category));
		//annotationConfigApplicationContext.refresh();
	}
	@Test

	public void deleteCat_Test()
	{
		Category category= new Category();
    	category.getCatergoryId();
    	assertEquals("deleted",true, categoryDaoImpl.deleteCategory(category));
		//annotationConfigApplicationContext.refresh();
	}
}
