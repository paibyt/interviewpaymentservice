package com.interview.paymentservice;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentRequest {
    private String user;
    private String password;
    private double amount;
    private String currency;
    private String cardBrand;
    private String cardNumber;
    private String cardHolder;
    private Date cardExpiryDate;
    private Integer cardCVV;

    private static DecimalFormat AMOUNT_FORMAT = new DecimalFormat("#0,00");
    private static DateFormat EXPIRY_DATE_FORMAT = new SimpleDateFormat("yyyyMM");

    public PaymentRequest(String user,
                          String password,
                          String amount,
                          String currency,
                          String cardBrand,
                          String cardNumber,
                          String cardHolder,
                          String cardExpiryYear,
                          String cardExpiryMonth,
                          String cardCVV
    ) throws ParseException {
        this.user = user;
        this.password = password;
        this.amount = AMOUNT_FORMAT.parse(amount).doubleValue();
        this.currency = currency;
        this.cardBrand = cardBrand;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.cardExpiryDate = EXPIRY_DATE_FORMAT.parse("20" + cardExpiryYear + cardExpiryMonth);
        this.cardCVV = Integer.valueOf(cardCVV);
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public Date getCardExpiryDate() {
        return cardExpiryDate;
    }

    public Integer getCardCVV() {
        return cardCVV;
    }

    @Override
    public String toString() {
        return "PaymentRequest {" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", cardBrand='" + cardBrand + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", cardExpiryDate='" + cardExpiryDate + '\'' +
                ", cardCVV='" + cardCVV + '\'' +
                '}';
    }
}
