package com.example.klaudia.swd;

import android.util.Log;

import java.io.Serializable;
import java.util.List;

/**
 * Created by KarolinaR on 2016-05-31.
 */
public class Option implements Serializable{

    private Klimat klimat;
    private List<Aktywnosc> aktywnoscList;
    private List<Lokalizacja> lokalizacjaList;

    public Option(Klimat klimat, List<Aktywnosc> aktywnoscList, List<Lokalizacja> lokalizacjaList){
        this.klimat = klimat;
        this.aktywnoscList = aktywnoscList;
        this.lokalizacjaList = lokalizacjaList;
    }

    public Klimat getKlimat() {
        return klimat;
    }

    public void setKlimat(Klimat klimat) {
        this.klimat = klimat;
    }

    public List<Aktywnosc> getAktywnoscList() {
        return aktywnoscList;
    }

    public void setAktywnoscList(List<Aktywnosc> aktywnoscList) {
        this.aktywnoscList = aktywnoscList;
    }

    public List<Lokalizacja> getLokalizacjaList() {
        return lokalizacjaList;
    }

    public void setLokalizacjaList(List<Lokalizacja> lokalizacjaList) {
        this.lokalizacjaList = lokalizacjaList;
    }

   @Override
    public boolean equals(Object option){
        return true;//TODO
    }

    public boolean isEmpty(Option option){
        if(option.getKlimat()!=null || !(option.getAktywnoscList().isEmpty()) || !(option.getLokalizacjaList().isEmpty()) ){
            Log.d("Option","Opcja nie jest pusta");
            return false;
        }


        return true;
    }
}
