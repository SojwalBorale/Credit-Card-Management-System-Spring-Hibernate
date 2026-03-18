package com.orm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.orm.dao.BillDao;
import com.orm.dao.CreditCardDao;
import com.orm.dao.CustomerDao;
import com.orm.dao.PaymentDao;
import com.orm.dao.TransactionDao;
import com.orm.entity.Bill;
import com.orm.entity.CreditCard;
import com.orm.entity.Customer;
import com.orm.entity.Payment;
import com.orm.entity.Transaction;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
     ApplicationContext apc = new ClassPathXmlApplicationContext("config.xml");
     
    CustomerDao customerDao = apc.getBean("customerDao",CustomerDao.class );
    CreditCardDao creditCardDao = apc.getBean("creditCardDao", CreditCardDao.class);
    TransactionDao transactionDao = apc.getBean("transactionDao", TransactionDao.class);
    BillDao billDao = apc.getBean("billDao", BillDao.class);
    PaymentDao paymentDao = apc.getBean("paymentDao", PaymentDao.class);
    
    Scanner sc = new Scanner(System.in);
    int choice;
    do {
    	 System.out.println("\n===== CREDIT CARD MANAGEMENT SYSTEM =====");
         System.out.println("1 Register Customer");
         System.out.println("2 Apply Credit Card");
         System.out.println("3 View Credit Card Details");
         System.out.println("4 Make Transaction");
         System.out.println("5 View Transactions");
         System.out.println("6 Generate Bill");
         System.out.println("7 Pay Bill");
         System.out.println("8 Exit");
         System.out.print("Enter choice (just the number): ");
         
         choice =sc.nextInt();
         sc.nextLine();
         switch(choice) {
         case 1: 
        	 System.out.println("Enter Name:");
        	 String name = sc.nextLine();
        	 
        	 System.out.println("Enter Email:");
             String email = sc.nextLine();
             
             System.out.println("Enter Mobile:");
             String mobile = sc.nextLine();
             
             System.out.println("Enter Address:");
             String address = sc.nextLine();
             
             Customer customer = new Customer(name,email,mobile,address);
             int id = customerDao.registerCustomer(customer);
             System.out.println("customer registered with ID: "+id);
             break;
         case 2: 
             System.out.println("Enter the Customer ID: ");
             int cid = Integer.parseInt(sc.nextLine());
             
             System.out.println("Enter Credit Limit: ");
             int limit = Integer.parseInt(sc.nextLine());
             
             String cardNumber = "7020-"+new Random().nextInt(9999);
             
             CreditCard creditCard = new CreditCard();
             creditCard.setCardNumber(cardNumber);
             creditCard.setCreditLimit(limit);
             creditCard.setAvailableLimit(limit);
             
             Customer cust = customerDao.getCustomerById(cid);
             creditCard.setCustomer(cust);
             
             creditCardDao.applyCard(creditCard);
             
             System.out.println("Credit Card Generated Successfully");
             System.out.println("Card Number: "+cardNumber);
             System.out.println("Available Limit: "+ limit);
             break;
         case 3: 
             System.out.println("Enter Card Number: ");
             String cardNo = sc.nextLine();
            CreditCard cc = creditCardDao.getCardByNumber(cardNo);
            if(cc!=null) {
            	System.out.println("Card ID: "+cc.getCardId());
            	System.out.println("Card Number: "+cc.getCardNumber());
            	System.out.println("Credit Limit: "+cc.getCreditLimit());
            	System.out.println("Available Limit: "+cc.getAvailableLimit());
            }else {
            	System.out.println("Card Not Found!");
            }
             break;
         case 4: 
        	 System.out.println("Enter Card Number:");
             String cn = sc.nextLine();

             System.out.println("Enter Merchant:");
             String merchant = sc.nextLine();

             System.out.println("Enter Amount:");
             int amount = Integer.parseInt(sc.nextLine());
             
            Transaction t = new Transaction();
            t.setMerchant(merchant);;
            t.setAmount(amount);
            t.setDate(new Date());
            
            CreditCard card = creditCardDao.getCardByNumber(cn);
            t.setCreditCard(card);
            
            transactionDao.saveTransaction(t);
            System.out.println("Transaction recorded successfullly");
             break;
         case 5: 
             List<Transaction> list = transactionDao.getAllTransactions();
             System.out.println("----- transaction history ---------");
             for(Transaction tr : list) {
            	 System.out.println("ID: " + tr.getTransactionId());
                 System.out.println("Card: " + tr.getCreditCard().getCardNumber());
                 System.out.println("Merchant: " + tr.getMerchant());
                 System.out.println("Amount: " + tr.getAmount());
                 System.out.println("Date: " + tr.getDate());
                 System.out.println("-------------------");
             }
             break;
         case 6: 
        	 System.out.println("Enter Card Number:");
             String cardNum = sc.nextLine();

             System.out.println("Enter Total Amount:");
             int total = Integer.parseInt(sc.nextLine());
             
             Bill bill = new Bill();
             CreditCard c = creditCardDao.getCardByNumber(cardNum);
             bill.setCreditCard(c);
             bill.setTotalAmount(total);
             bill.setBillDate(new Date());
             bill.setDueDate(new Date());
             
             billDao.generateBill(bill);
             System.out.println("Bill generated Successfully");
             break;
         case 7: 
        	  System.out.println("Enter Bill ID:");
              int billId = Integer.parseInt(sc.nextLine());

              System.out.println("Enter Payment Amount:");
              int pay = Integer.parseInt(sc.nextLine());
              
              Payment payment = new Payment();
             Bill bid = billDao.getBillById(billId);
              payment.setBill(bid);
              payment.setAmount(pay);
              payment.setPaymentDate(new Date());
              
              paymentDao.payBill(payment);
              System.out.println("payment Successful!");
             break;
         case 8: 
             System.out.println("Exiting system. Goodbye!");
             break;
         default: 
             System.out.println("Invalid choice. Please try again.");
           }
    }while(choice != 8);
        
        
	}
	
}
