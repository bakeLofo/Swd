package com.example.klaudia.swd;

/**
 * Created by KarolinaR on 2016-05-31.
 */
public enum Klimat {

    CIEPLY("Ciepło"), UMIARKOWANY("Umiarkowanie"), ZIMNY("Zimno");

    private String name;

    Klimat(String name){
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
