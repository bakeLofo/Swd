package com.example.klaudia.swd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by KarolinaR on 2016-05-25.
 */
public class lrw2 {

    private List<Boolean> tmp;
    /*
        l0 - cieply klimat
        l1 - umiarkowany klimat
        l2 - zimny klimat
        l3 - zwiedzanie
        l4 - sport
        l5 - opalanie sie
        l6 - egzotyka
        l7 - morze
        l8 - gory
        l9 - miasto
        l10 - Rzym
        l11 - Gran Canaria
        l12 - Tajlandia
        l13 - Gdansk
        l14 - Alpy
    */


    private List<List<Boolean>> policz(List<Integer> choices){
        List<List<Boolean>> list = new ArrayList<>();
        int n = 15;
        int rows = (int) Math.pow(2, n);
        List<List<Boolean>> su1 = new ArrayList<>();
        List<List<Boolean>> su2 = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            tmp = new ArrayList<>();
            for (int j = n - 1; j >= 0; j--) {
                tmp.add((i / (int) Math.pow(2, j)) % 2 == 1);
            }

            Boolean F1 = !tmp.get(10) || (tmp.get(3) && tmp.get(9)); //rzym
            Boolean F2 = !tmp.get(11) || (tmp.get(7) && tmp.get(8)); //gran canaria
            Boolean F3 = !tmp.get(12) || (tmp.get(6) && tmp.get(7)); //tajlandia*/
            Boolean F4 = !tmp.get(13) || (tmp.get(1) && tmp.get(3) && tmp.get(5) && tmp.get(7) && tmp.get(9)); //gdansk
            Boolean F5 = !tmp.get(14) || (/*tmp.get(2) && tmp.get(4) &&*/ tmp.get(8)); //alpy
            Boolean F6 = !(tmp.get(10) || tmp.get(11) || tmp.get(12)) || (tmp.get(0));//cieplo
            Boolean F7 = !(tmp.get(11) || tmp.get(12)) || (tmp.get(4) && tmp.get(5));//sport + opalanie sie
            Boolean F8 = !tmp.get(2) && tmp.get(5);//za zimno na opalanie sie
            Boolean F9 = (tmp.get(0) ^ tmp.get(1) ^ tmp.get(2)) ^ (tmp.get(0) && tmp.get(1) && tmp.get(2));//nie moze byc jednoczesnie zimno, cieplo i umiarkowanie
            Boolean F10 = (tmp.get(10) || tmp.get(11) || tmp.get(12) || tmp.get(13) || tmp.get(14))
                    && !(tmp.get(10) && tmp.get(11) && tmp.get(12) && tmp.get(13) && tmp.get(14)) //5
                    && !(tmp.get(10) && tmp.get(11) && tmp.get(12) && tmp.get(13)) //4
                    && !(tmp.get(10) && tmp.get(11) && tmp.get(12) && tmp.get(14)) //4
                    && !(tmp.get(10) && tmp.get(12) && tmp.get(13) && tmp.get(14)) //4
                    && !(tmp.get(11) && tmp.get(12) && tmp.get(13) && tmp.get(14)) //4
                    && !(tmp.get(10) && tmp.get(11) && tmp.get(12)) //3
                    && !(tmp.get(10) && tmp.get(11) && tmp.get(13)) //3
                    && !(tmp.get(10) && tmp.get(11) && tmp.get(14)) //3
                    && !(tmp.get(11) && tmp.get(12) && tmp.get(13)) //3
                    && !(tmp.get(11) && tmp.get(12) && tmp.get(14)) //3
                    && !(tmp.get(12) && tmp.get(13) && tmp.get(14)) //3
                    && !(tmp.get(10) && tmp.get(11)) && !(tmp.get(10) && tmp.get(12)) && !(tmp.get(10) && tmp.get(13)) && !(tmp.get(10) && tmp.get(14))
                    && !(tmp.get(11) && tmp.get(12)) && !(tmp.get(11) && tmp.get(13)) && !(tmp.get(11) && tmp.get(14))
                    && !(tmp.get(12) && tmp.get(13)) && !(tmp.get(12) && tmp.get(14))
                    && !(tmp.get(13) && tmp.get(14));
            Boolean F = F1 && F2 && F3 && F4 && F5 && F6 && F7 && F8 && F9 && F10;
            Boolean Fy = true;
            for(Integer in : choices){
                Fy = Fy && tmp.get(in);
            }
            Boolean l1 = F && Fy;
            Boolean l2 = F && !Fy;
            if (l1) {
                List<Boolean> t = new ArrayList<>();
                t.add(tmp.get(10));
                t.add(tmp.get(11));
                t.add(tmp.get(12));
                t.add(tmp.get(13));
                t.add(tmp.get(14));
                if (!this.checkIfContains(su1, t)) {
                    su1.add(t);
                }
            } else if (l2) {
                List<Boolean> t = new ArrayList<>();
                t.add(tmp.get(10));
                t.add(tmp.get(11));
                t.add(tmp.get(12));
                t.add(tmp.get(13));
                t.add(tmp.get(14));
                if (!this.checkIfContains(su2, t)) {
                    su2.add(t);
                }
            }
            list.add(tmp);
        }
        su1.removeAll(su2);
        /*for (List<Boolean> l : su1) {
            for (Boolean b : l) {
                System.out.print(b ? 1 + " " : 0 + " ");
            }
            System.out.println();
        }*/
        return su1;
    }

    private Boolean checkIfContains(List<List<Boolean>> src, List<Boolean> tmp){
        Boolean res = false;
        for(List<Boolean> s : src){
            res = true;
            if(s.size() == tmp.size()){
                int i = 0;
                while(res && i < s.size()){
                    if(s.get(i) != tmp.get(i)){
                        res = false;
                    }
                    i++;
                }
                if(res){
                    return true;
                }
            }
        }
        return res;
    }

   /* public static void main(String[] args){
        lrw2 l = new lrw2();
        List<List<Integer>> choices = new ArrayList<>();
        List<Integer> firstChoice = new ArrayList<>();
        List<Integer> secondChoice = new ArrayList<>();
        List<Integer> thirdChoice = new ArrayList<>();
        //firstChoice.add(1);
        //firstChoice.add(5);
        firstChoice.add(0);
        secondChoice.add(0);
        secondChoice.add(7);
        secondChoice.add(6);
        thirdChoice.add(8);
        choices.add(firstChoice);
        choices.add(secondChoice);
        choices.add(thirdChoice);
        for(List<Integer> choice : choices) {
        	System.out.println("Wybor: ");
          //  choice.
           // choice.forEach(c -> System.out.print(c + " "));
            System.out.println();
            System.out.println("Wynik: ");
            for (List<Boolean> lista : l.policz(choice)) {
                for (Boolean b : lista) {
                    System.out.print(b ? 1 + " " : 0 + " ");
                }
                System.out.println();
            }
        }
    }*/
}
