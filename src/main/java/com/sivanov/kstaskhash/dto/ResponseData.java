package com.sivanov.kstaskhash.dto;

public class ResponseData {

    private String phone;
    private String hash;

    public ResponseData() {
    }

    public ResponseData(String phone, String hash) {
        this.phone = phone;
        this.hash = hash;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "phone='" + phone + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}
