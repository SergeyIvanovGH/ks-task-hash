package com.sivanov.kstaskhash.dto;

import javax.validation.constraints.NotNull;

public class GettingPhoneByHashRequest {

    @NotNull
    private String hash;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "GettingPhoneByHashRequest{" +
                "hash='" + hash + '\'' +
                '}';
    }
}
