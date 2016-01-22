package com.springapp.mvc.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by rdemarla on 30-Oct-15.
 **/
@Entity
@Table(name = "ADDRESS")
public class Address extends BaseEntity implements Serializable {

    @NotNull
    @Column(name = "ADDRESS_ONE")
    private String address1;

    @Column(name = "ADDRESS_TWO")
    @JsonIgnore
    private String address2;

    @Column(name = "STREET")
    @JsonIgnore
    private String street;

    @NotNull
    @Column(name = "CITY")
    private String city;

    @NotNull
    @Column(name = "STATE")
    private String state;

    @NotNull
    @Column(name = "PINCODE")
    private String pinCode;

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
