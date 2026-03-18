package com.orm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.orm.entity.Transaction;

public class TransactionDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public void setHibernateTemplate (HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public int saveTransaction(Transaction transaction) {
        return (Integer) hibernateTemplate.save(transaction);
    }
	
	public List<Transaction> getAllTransactions() {
        return hibernateTemplate.loadAll(Transaction.class);
    }
}
