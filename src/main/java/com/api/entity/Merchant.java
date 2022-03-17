package com.api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Merchant {
    @Id
    private Long merchantId;

    private String merchantName;

    private String gstin;

    private String pan;

    private String address;

    private Integer accountNumber;

    private String phoneNumber;

    public Merchant() {
    }

    public Merchant(Long merchantId, String merchantName, String gstin, String pan, String address, Integer accountNumber, String phoneNumber) {
        this.merchantId = merchantId;
        this.merchantName = merchantName;
        this.gstin = gstin;
        this.pan = pan;
        this.address = address;
        this.accountNumber = accountNumber;
        this.phoneNumber = phoneNumber;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
