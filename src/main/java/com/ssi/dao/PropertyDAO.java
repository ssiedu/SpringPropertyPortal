package com.ssi.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssi.entities.Property;

@Component
public class PropertyDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Property searchProperty(String pcode){
		Session session=sessionFactory.openSession();
		Property property=session.get(Property.class, pcode);
		session.close();
		return property;
	}
	public void saveProperty(Property property){
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(property);
		tr.commit();
		session.close();
	}
}
