package com.springapp.mvc.modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Created by rdemarla on 29-Oct-15.
 * Simple JavaBean domain object with an id property.
 * Used as a base class for objects needing this property.
 */
@MappedSuperclass
public class BaseEntity
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "TRANSACTION_DATE", nullable = false)
    private Date transactionDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return (this.id == null);
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
