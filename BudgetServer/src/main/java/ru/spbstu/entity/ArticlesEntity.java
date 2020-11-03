package ru.spbstu.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Articles", schema = "dbo", catalog = "Budget")
public class ArticlesEntity {
    private int id;
    private String name;
    private Collection<OperationsEntity> operationsById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticlesEntity that = (ArticlesEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public  String toString() {
        String data = "id: " + String.valueOf(id) + " name: " + name;
        return data;
    }
   // @OneToMany(mappedBy = "articlesByArticleId")
   // public Collection<OperationsEntity> getOperationsById() {
   //     return operationsById;
   // }

    public void setOperationsById(Collection<OperationsEntity> operationsById) {
        this.operationsById = operationsById;
    }
}
