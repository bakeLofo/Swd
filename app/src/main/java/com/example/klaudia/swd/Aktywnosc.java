package com.example.klaudia.swd;

/**
 * Created by KarolinaR on 2016-05-31.
 */
public enum Aktywnosc {

    ZWIEDZANIE("Zwiedzanie"), OPALANIE("Opalanie"), SPORT("Sport");

    private String name;

    Aktywnosc(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
