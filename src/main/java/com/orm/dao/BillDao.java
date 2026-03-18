package com.orm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.orm.entity.Bill;

public class BillDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public void setHibernateTemplate (HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	 public int generateBill(Bill bill) {
	        return (Integer) hibernateTemplate.save(bill);
	    }
	
	 public Bill getBillById(int id) {
	        return hibernateTemplate.get(Bill.class, id);
	    }
}
