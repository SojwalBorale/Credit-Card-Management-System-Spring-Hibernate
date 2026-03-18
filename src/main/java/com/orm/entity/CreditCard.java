package com.orm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="creditcard")
public class CreditCard  implements Serializable{
	 private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="card_id")
    private int cardId;

    @Column(name="cardNumber", length=16, nullable=false,unique=true)
    private String cardNumber;

    private int creditLimit;
    private int availableLimit;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

}