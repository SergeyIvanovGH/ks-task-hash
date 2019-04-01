package com.sivanov.kstaskhash.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Validated
public class GettingHashByPhoneRequest {

    @NotNull
    @Pattern(regexp = "\\d{10}")
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
