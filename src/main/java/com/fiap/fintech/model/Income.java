package com.fiap.fintech.model;

import java.util.Date;

public class Income {
    private int incomeId;
    private int userId;
    private String source;
    private String description;
    private double amount;
    private Date incomeDate;

    public Income(int incomeId, int userId, String source, String description, double amount, Date incomeDate) {
        this.incomeId = incomeId;
        this.userId = userId;
        this.source = source;
        this.description = description;
        this.amount = amount;
        this.incomeDate = incomeDate;
    }
    
    public Income(int userId, String source, String description, double amount, Date incomeDate) {
        this.userId = userId;
        this.source = source;
        this.description = description;
        this.amount = amount;
        this.incomeDate = incomeDate;
    }

    public int getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
