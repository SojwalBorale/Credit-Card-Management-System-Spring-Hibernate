package com.orm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.orm.entity.CreditCard;

public class CreditCardDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public void setHibernateTemplate (HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public int applyCard(CreditCard card) {
        return (Integer) hibernateTemplate.save(card);
    }
	
	public CreditCard getCardByNumber(String cardNumber) {
        return (CreditCard) hibernateTemplate.find("from CreditCard where cardNumber=?", cardNumber).get(0);
    }
	
}
