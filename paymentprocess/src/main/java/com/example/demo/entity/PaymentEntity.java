package com.example.demo.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "payments")

public class PaymentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double amount;

    private String paymentdate;  
    
    public String getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(String paymentdate) {
		this.paymentdate = paymentdate;
	}

	private String cardnumber;
    
    private String cardexpirymonth;
    
    private String cardexpiryyear;
    
    private String cardcvv;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCardNumber() {
		return cardnumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardnumber = cardNumber;
	}

	public String getCardExpiryMonth() {
		return cardexpirymonth;
	}

	public void setCardExpiryMonth(String cardExpiryMonth) {
		this.cardexpirymonth = cardExpiryMonth;
	}

	public String getCardExpiryYear() {
		return cardexpiryyear;
	}

	public void setCardExpiryYear(String cardExpiryYear) {
		this.cardexpiryyear = cardExpiryYear;
	}

	public String getCardCVV() {
		return cardcvv;
	}

	public void setCardCVV(String cardCVV) {
		this.cardcvv = cardCVV;
	}
    
}
  