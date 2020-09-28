package com.pl.OrdersManagement.contractor;

import com.pl.OrdersManagement.address.Address;
import com.pl.OrdersManagement.order.Order;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Contractor {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @NotNull
    @Size(min = 2)
    private String name;

    @OneToOne
    private Address companyAddress;

    @OneToMany
    private List<Address> shippingAddress;

    @NotNull
    @Pattern(regexp="^(ATU[0-9]{8}|BE[01][0-9]{9}|BG[0-9]{9,10}|HR[0-9]{11}|CY[A-Z0-9]{9}|CZ[0-9]{8,10}|DK[0-9]{8}|EE[0-9]{9}|FI[0-9]{8}|FR[0-9A-Z]{2}[0-9]{9}|DE[0-9]{9}|EL[0-9]{9}|HU[0-9]{8}|IE([0-9]{7}[A-Z]{1,2}|[0-9][A-Z][0-9]{5}[A-Z])|IT[0-9]{11}|LV[0-9]{11}|LT([0-9]{9}|[0-9]{12})|LU[0-9]{8}|MT[0-9]{8}|NL[0-9]{9}B[0-9]{2}|PL[0-9]{10}|PT[0-9]{9}|RO[0-9]{2,10}|SK[0-9]{10}|SI[0-9]{8}|ES[A-Z]([0-9]{8}|[0-9]{7}[A-Z])|SE[0-9]{12}|GB([0-9]{9}|[0-9]{12}|GD[0-4][0-9]{2}|HA[5-9][0-9]{2}))$\n")
    private String vatId;

    private String contactPerson;

    @NotNull
    private String phoneNumber;

    @OneToMany
    private List<Order> orders;

    public Contractor() {
    }

    public Contractor(String id, String name, Address companyAddress,
            List<Address> shippingAddress, String vatId,
            String contactPerson, String phoneNumber, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.companyAddress = companyAddress;
        this.shippingAddress = shippingAddress;
        this.vatId = vatId;
        this.contactPerson = contactPerson;
        this.phoneNumber = phoneNumber;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(Address companyAddress) {
        this.companyAddress = companyAddress;
    }

    public List<Address> getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(List<Address> shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getVatId() {
        return vatId;
    }

    public void setVatId(String vatId) {
        this.vatId = vatId;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contractor{" +
                "name='" + name + '\'' +
                ", companyAddress=" + companyAddress +
                ", shippingAddress=" + shippingAddress +
                ", vatId='" + vatId + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
