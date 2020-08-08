package com.shristi.BloodBank.Models;

import com.google.gson.annotations.SerializedName;

public class DonorDetails {
    // @SerializedName("phone")
    private Integer phone;
    //@SerializedName("id")
    // private Integer id;
    // @SerializedName("name")
    private String name;
    //  @SerializedName("address")
    private String address;
    //@SerializedName("bloodgroup")
    private String bloodgroup;


    public DonorDetails() {
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

}
