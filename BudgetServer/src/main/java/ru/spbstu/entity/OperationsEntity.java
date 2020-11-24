package ru.spbstu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Operations", schema = "dbo", catalog = "Budget")
public class OperationsEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @OneToOne(targetEntity = ArticlesEntity.class)
    private ArticlesEntity article;

    @Column(name = "debit", nullable = false)
    private double debit;

    @Column(name = "credit", nullable = false)
    private double credit;

    @Column(name = "createdate", nullable = false)
    private String createdate;

    @OneToOne(targetEntity = BalanceEntity.class)
    private BalanceEntity balance;

    public OperationsEntity() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArticlesEntity getArticle() {
        return article;
    }

    public void setArticle(ArticlesEntity article) {
        this.article = article;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String create_date) {
        this.createdate = create_date;
    }

    public BalanceEntity getBalance() {
        return balance;
    }

    public void setBalance(BalanceEntity balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", articles=" + article +
                ", debit=" + debit +
                ", credit=" + credit +
                ", create_date=" + createdate +
                ", balance=" + balance +
                '}';
    }
}
