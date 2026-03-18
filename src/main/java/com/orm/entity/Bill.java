package com.orm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bill_id")
    private int billId;

    private int totalAmount;
    private Date billDate;
    private Date dueDate;

    @ManyToOne
    @JoinColumn(name="card_number", referencedColumnName="cardNumber", nullable=false)
    private CreditCard creditCard;

    @OneToMany(mappedBy="bill", cascade=CascadeType.ALL)
    private List<Payment> payments;

}