package com.vishnu.WishBackend;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestExample {
	@BeforeClass
	public static void test1()
	{
		System.out.println("hello");
	}
	
	@Test
	public  void test3()
	{
		
		Cal cal= new Cal();
	
		assertEquals("success", true,cal.even(8));
	}
	
	@AfterClass
	public static void testlast()
	{
		System.out.println("bye");
	}

}
