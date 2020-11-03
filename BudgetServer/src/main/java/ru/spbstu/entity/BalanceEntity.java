package ru.spbstu.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "Balance", schema = "dbo", catalog = "Budget")
public class BalanceEntity {
    private int id;
    private String createdate;
    private double debit;
    private double credit;
    private double amount;
    private Collection<OperationsEntity> operationsById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "createdate", nullable = false)
    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createData) {
        this.createdate = createData;
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
    @Column(name = "Amount", nullable = false, precision = 0)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BalanceEntity that = (BalanceEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.debit, debit) != 0) return false;
        if (Double.compare(that.credit, credit) != 0) return false;
        if (Double.compare(that.amount, amount) != 0) return false;
        if (createdate != null ? !createdate.equals(that.createdate) : that.createdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (createdate != null ? createdate.hashCode() : 0);
        temp = Double.doubleToLongBits(debit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(credit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }


    public  String toString() {
        String data = "id: " + String.valueOf(id) + " create date: " + createdate
                + " debit: " + String.valueOf(debit) + " credit: "
                + String.valueOf(credit) + " amount: " + String.valueOf(amount);
        return data;
    }

  //  @OneToMany(mappedBy = "balanceByBalanceId")
    //public Collection<OperationsEntity> getOperationsById() {
      //  return operationsById;
    //}

    public void setOperationsById(Collection<OperationsEntity> operationsById) {
        this.operationsById = operationsById;
    }
}
