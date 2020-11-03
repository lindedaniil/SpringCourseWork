package ru.spbstu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Operations", schema = "dbo", catalog = "Budget")
public class OperationsEntity {
    private int id;
    private int articleId;
    private double debit;
    private double credit;
    private String createdate;
    private int balanceId;
    private ArticlesEntity articlesByArticleId;
    private BalanceEntity balanceByBalanceId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   // @Basic
   // @Column(name = "ArticleId", nullable = false)
   // public int getArticleId() {
   //     return articleId;
   // }

    //public void setArticleId(int articleId) {
    //   this.articleId = articleId;
   // }

    @Basic
    @Column(name = "articleId", nullable = false, precision = 0)
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "Debit", nullable = false, precision = 0)
    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    @Basic
    @Column(name = "Credit", nullable = false, precision = 0)
    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Basic
    @Column(name = "createdate", nullable = false)
    public String getCreatedate() {
        return createdate;
    }



    public void setCreatedate(String createDate) {
        this.createdate = createDate;
    }

    //@Basic
    //@Column(name = "BalanceId", nullable = false)
   // public int getBalanceId() {
   //     return balanceId;
   // }


    @Basic
    @Column(name = "balanceId", nullable = false, precision = 0)
    public int getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(int balanceId) {
        this.balanceId = balanceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationsEntity that = (OperationsEntity) o;

        if (id != that.id) return false;
        if (articleId != that.articleId) return false;
        if (Double.compare(that.debit, debit) != 0) return false;
        if (Double.compare(that.credit, credit) != 0) return false;
        if (balanceId != that.balanceId) return false;
        if (createdate != null ? !createdate.equals(that.createdate) : that.createdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + articleId;
        temp = Double.doubleToLongBits(debit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(credit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (createdate != null ? createdate.hashCode() : 0);
        result = 31 * result + balanceId;
        return result;
    }

    public  String toString() {
        String data = "id: " + String.valueOf(id) + " article id: " + String.valueOf(articleId)
                + " create date: " +  createdate + " debit: " + String.valueOf(debit)
                + " credit: " + String.valueOf(credit) + " balance id: " + String.valueOf(balanceId);
        return data;
    }

    //@ManyToOne
    //@JoinColumn(name = "ArticleId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    //public ArticlesEntity getArticlesByArticleId() {
    //    return articlesByArticleId;
    //}

   // public void setArticlesByArticleId(ArticlesEntity articlesByArticleId) {
     //   this.articlesByArticleId = articlesByArticleId;
    //}

   // @ManyToOne
    //@JoinColumn(name = "BalanceId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    //public BalanceEntity getBalanceByBalanceId() {
    //    return balanceByBalanceId;
   // }

    //public void setBalanceByBalanceId(BalanceEntity balanceByBalanceId) {
    //    this.balanceByBalanceId = balanceByBalanceId;
    //}
}
