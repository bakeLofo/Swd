package com.example.klaudia.swd;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
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

    public List<Integer> convertOptionToNumbers(Option option){
        List<Integer> lista= new ArrayList<>();
        Klimat klimat= option.getKlimat();
        List <Aktywnosc> listaA= option.getAktywnoscList();
        List <Lokalizacja> listaL= option.getLokalizacjaList();
        if(klimat!=null) {
            if (klimat.getName() == "Ciepło") {
                lista.add(0);
            } else if (klimat.getName() == "Umiarkowanie") {
                lista.add(1);
            } else if (klimat.getName() == "Zimno") {
                lista.add(2);
            }
        }
        Log.d("Option","convert"+listaA);
        for(Aktywnosc a: listaA) {
            if (a.getName()=="Opalanie") {
                lista.add(5);
                Log.d("Option", "convert w ifie" + listaA);
            } else if (a.getName()=="Zwiedzanie") {
                lista.add(3);

            } else if (a.getName()=="Sport"){
                lista.add(4);
            }
        }
        for(Lokalizacja l: listaL) {
            if (l.getName()=="Egzotyka") {
                lista.add(6);
            } else if (l.getName()=="Morze") {
                lista.add(7);

            } else if (l.getName()=="Góry") {
                lista.add(8);
            } else if (l.getName()=="Miasto") {
                lista.add(9);
            }
        }
        return lista;
    }
}
