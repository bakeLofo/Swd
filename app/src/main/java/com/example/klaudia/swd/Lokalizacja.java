package com.example.klaudia.swd;

/**
 * Created by KarolinaR on 2016-05-31.
 */
public enum Lokalizacja {

    MIASTO("Miasto"), GORY("Góry"), MORZE("Morze");

    private String name;
    Lokalizacja(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
