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
    public int getNumber(String name){
        if(name=="Ciepło"){
            return 0;
        }else if(name=="Umiarkowanie"){
            return 1;
        }else if(name=="Zimno"){
            return 2;
        }

        return -1;
    }

    public void setName(String name) {
        this.name = name;
    }
}
