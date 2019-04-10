package com.turchanovskyi.mediasphere.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contacts")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private Long id_contact;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "information")
    private String information;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "workplace")
    private String workplace;

    @Column(name = "position")
    private String position;

    @Column(name = "location")
    private String location;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "verified")
    private int verified;

    @Column(name = "registered")
    private Date registered;

    @Column(name = "views")
    private int views;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "contacts_spheres",
                        joinColumns = @JoinColumn(name = "id_contact"),
                        inverseJoinColumns = @JoinColumn(name = "id_sphere"))
    private List<Sphere> sphereList = new ArrayList<>();

    @OneToMany(mappedBy = "id_contact", fetch = FetchType.LAZY)
    private List<Report> reportList = new ArrayList<>();

    @OneToMany(mappedBy = "id_contact", fetch = FetchType.LAZY)
    private List<Purchase> purchaseList = new ArrayList<>();

    public Contact() {}

    public Contact(String name, String surname, String information, String email, String phone, String workplace, String position, String location, String country, String city, int verified, Date registered, int views, List<Sphere> sphereList) {
        this.name = name;
        this.surname = surname;
        this.information = information;
        this.email = email;
        this.phone = phone;
        this.workplace = workplace;
        this.position = position;
        this.location = location;
        this.country = country;
        this.city = city;
        this.verified = verified;
        this.registered = registered;
        this.views = views;
        this.sphereList = sphereList;
    }

    public Long getId_contact() {
        return id_contact;
    }

    public void setId_contact(Long id_contact) {
        this.id_contact = id_contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public List<Sphere> getSphereList() {
        return sphereList;
    }

    public void setSphereList(List<Sphere> sphereList) {
        this.sphereList = sphereList;
    }

    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }
}