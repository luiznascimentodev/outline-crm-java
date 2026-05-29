package com.crm.model;

public class Lead {

    private int id;
    private String clientName;
    private String phoneNumber;
    private String status;
    private double dealValue;

    public int getId() {
        return this.id;
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getStatus() {
        return this.status;
    }

    public double getDealValue() {
        return this.dealValue;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;

    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDealValue(double dealValue) {
        this.dealValue = dealValue;
    }

    public Lead(String clientName, String phoneNumber) {

        setClientName(clientName);
        setPhoneNumber(phoneNumber);
        this.status = "NEW";
        this.dealValue = 0.0;

    }

  public Lead (String clientName, String phoneNumber, String status, double dealValue) {
    this.clientName = clientName;
    this.phoneNumber = phoneNumber;
    this.status = status;
    this.dealValue = dealValue;
}

@Override
public String toString(){
    return " Cliente " + clientName + " Telefone: " + phoneNumber + " Status: " + status + " Contrato: " + dealValue;
}



}
