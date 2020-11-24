package ru.spbstu.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Balance", schema = "dbo", catalog = "Budget")
public class BalanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "createdate", nullable = false)
    private String createdate;

    @Column(name = "debit", nullable = false)
    private double debit;

    @Column(name = "credit", nullable = false)
    private double credit;

    @Column(name = "amount", nullable = false)
    private double amount;

    public BalanceEntity() {

    }

    public BalanceEntity(String create_date, double debit, double credit, double amount) {
        this.createdate = create_date;
        this.debit = debit;
        this.credit = credit;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String create_date) {
        this.createdate = create_date;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", create_date=" + createdate +
                ", debit=" + debit +
                ", credit=" + credit +
                ", amount=" + amount +
                '}';
    }
}
