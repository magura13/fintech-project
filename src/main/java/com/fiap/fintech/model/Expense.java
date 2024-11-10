package com.fiap.fintech.model;

import java.util.Date;

public class Expense {
    private int expenseId;
    private int userId;
    private String source;
    private String description;
    private double amount;
    private Date expenseDate;

    public Expense(int userId, String source, String description, double amount, Date expenseDate) {
        this.userId = userId;
        this.source = source;
        this.description = description;
        this.amount = amount;
        this.expenseDate = expenseDate;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }
}
