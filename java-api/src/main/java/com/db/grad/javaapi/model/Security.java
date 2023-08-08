package com.db.grad.javaapi.model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Security")
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String isin;

    @Column(nullable = false, length = 50)
    private String cusip;

    @Column(nullable = false, length = 255)
    private String issuer;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate maturityDate;

    @Column
    private Float coupon;

    @Column(length = 50)
    private String type;

    @Column
    private Float faceValue;

    @Column(length = 50)
    private String status;

    // Constructors, getters, and setters

    public Security() {
        // Default constructor required by JPA
    }

    public Security(String isin, String cusip, String issuer, LocalDate maturityDate, Float coupon, String type, Float faceValue, String status) {
        this.isin = isin;
        this.cusip = cusip;
        this.issuer = issuer;
        this.maturityDate = maturityDate;
        this.coupon = coupon;
        this.type = type;
        this.faceValue = faceValue;
        this.status = status;
    }

    // Getters and setters for all fields

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Float getCoupon() {
        return coupon;
    }

    public void setCoupon(Float coupon) {
        this.coupon = coupon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(Float faceValue) {
        this.faceValue = faceValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
