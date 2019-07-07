package com.vishnu.WishBackend.daoimpl;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vishnu.WishBackend.dao.SupplierDao;
import com.vishnu.WishBackend.model.Supplier;


@Component("supplierDaoImpl")
public class SupplierDaoImpl implements SupplierDao
{
	
	@Autowired
	SessionFactory factory;

	//=============================================Save Supplier Data========================================
	
	@Override
	public boolean saveSupplier(Supplier supplier) {
		
		Session session=null;
		try
		{
			session=factory.openSession();
			/*
			 * if(supplier.getSupplierId()==0) { Random random=new Random();
			 * supplier.setSupplierId(random.nextInt(10000)); }
			 */
			session.save(supplier);
			Transaction transaction=session.beginTransaction();
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		finally 
		{
			session.close();
		}
		
	}
	
	
	public Supplier getSupplierName(String sup_name)
	{
		Session session=factory.openSession();
		
		Query query=session.createQuery("from Supplier where supplierName=:sn");
		query.setParameter("sn",sup_name); 
		Supplier supplier=(Supplier)query.uniqueResult();
		
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		
		return supplier;
	}

	
	//=============================================Delete Supplier Data========================================
	@Override
	public boolean deleteSupplier(Supplier supplier) 
	{

		Session session =factory.openSession();
		session.delete(supplier);

		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();

		return true;
	}
	
	
	//=============================================Get Supplier Data Based On Supplier Id========================================
	@Override
	public Supplier getSupplier(int supplierId) 
	{

		Session session=factory.openSession();
		
		Supplier supplier=session.get(Supplier.class,supplierId);
		session.close();
		return supplier;

	}
	
	//=============================================Get Supplier List Data========================================
	@Override
	public List<Supplier> getSupplierList() 
	{
		Session session= factory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> list= query.list();
		
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close();
		return list;
	}


	@Override
	public boolean editSupplier(Supplier supplier) {
		
		Session session=null;
		try
		{
			session=factory.openSession();
			/*
			 * if(supplier.getSupplierId()==0) { Random random=new Random();
			 * supplier.setSupplierId(random.nextInt(10000)); }
			 */
			session.update(supplier);
			Transaction transaction=session.beginTransaction();
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		finally 
		{
			session.close();
		}
	}

}
