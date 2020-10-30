package com.perfectsquare.gstinnotes.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "company")
public class Company {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "company_type")
    private String company_type;

    @ColumnInfo(name = "Company_name")
    private String company_name;

    @ColumnInfo(name = "gstin")
    private String gstin;

    @ColumnInfo(name = "contact_person")
    private String contact_person;

    @ColumnInfo(name = "mob_no")
    private String mob_no;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "State")
    private String state;

    @ColumnInfo(name = "createdAt")
    private String createdAt;

    @ColumnInfo(name = "UpdatedAt")
    private String UpdatedAt;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        UpdatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany_type() {
        return company_type;
    }

    public void setCompany_type(String company_type) {
        this.company_type = company_type;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getMob_no() {
        return mob_no;
    }

    public void setMob_no(String mob_no) {
        this.mob_no = mob_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", company_type='" + company_type + '\'' +
                ", company_name='" + company_name + '\'' +
                ", gstin='" + gstin + '\'' +
                ", contact_person='" + contact_person + '\'' +
                ", mob_no='" + mob_no + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
