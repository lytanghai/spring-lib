package com.psp.fd.pspspringboot.dto;

public class Calculate {
    private String name;

    private Double eachPersonTotal;

    public String getName() {
        return name;
    }

    public Double getEachPersonTotal() {
        return eachPersonTotal;
    }

    public void setEachPersonTotal(Double eachPersonTotal) {
        this.eachPersonTotal = eachPersonTotal;
    }

    public void setName(String name) {
        this.name = name;
    }

}
