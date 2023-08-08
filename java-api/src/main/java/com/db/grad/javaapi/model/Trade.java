package com.db.grad.javaapi.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import java.time.LocalDate;
import com.db.grad.javaapi.model.Book;
import javax.persistence.CascadeType;

@Entity
public class Trade {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "BookId")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "CounterpartyId")
    private Counterparty counterparty;

    @ManyToOne
    @JoinColumn(name = "SecurityId")
    private Security security;

    @Column
    private Integer quantity;

    @Column(length = 50)
    private String status;

    @Column
    private Float price;

    @Column(length = 10)
    private String buySell;

    @Column
    private LocalDate tradeDate;

    @Column
    private LocalDate settlementDate;

    // Constructors, getters, and setters

    public Trade() {
        // Default constructor required by JPA
    }

    public Trade(Book book, Counterparty counterparty, Security security, Integer quantity, String status, Float price, String buySell, LocalDate tradeDate, LocalDate settlementDate) {
        this.book = book;
        this.counterparty = counterparty;
        this.security = security;
        this.quantity = quantity;
        this.status = status;
        this.price = price;
        this.buySell = buySell;
        this.tradeDate = tradeDate;
        this.settlementDate = settlementDate;
    }

    // Getters and setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Counterparty getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(Counterparty counterparty) {
        this.counterparty = counterparty;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getBuySell() {
        return buySell;
    }

    public void setBuySell(String buySell) {
        this.buySell = buySell;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDate settlementDate) {
        this.settlementDate = settlementDate;
    }
}
