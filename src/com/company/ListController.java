package com.company;

import java.util.*;
import java.util.stream.Collectors;

import static com.company.Ort.*;
import static java.util.stream.Collectors.*;

public class ListController {
    /*public List<Tier> sortListeTiereByName(List<Tier> liste) {
        return liste.stream()
                .sorted((tier, otherTier) -> tier.getName().compareTo(otherTier.getName()))
                .collect(Collectors.toList());
    }

    public List<Tier> filterListeByDiaet(List<Tier> liste, Diaet diaet) {
        return liste.stream()
                .filter(tier -> {
                    return tier.getDiaet() == diaet;
                }) // daca am acolade, trebuie sa dau return
                .collect(Collectors.toList());
    }

    public List<Tier> filterListeByName(List<Tier> liste, String name) {
        return liste.stream()
                .filter(tier -> tier.getName().equals(name))
                .collect(Collectors.toList());
    }


    public String getMostFrequentPlace(List<Tier> liste) {
        Map.Entry<String, Long> maxLocation = liste.stream()
                .collect(Collectors.groupingBy(Tier::getOrt, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(NullPointerException::new);

        return maxLocation.getKey() + ": " + maxLocation.getValue();
    }*/

    public List<Offerte> sortListeOffertenNachFinalPreis(List<Offerte> liste) {
        List<Offerte> aux_liste = liste;
        calculateLastPrice(aux_liste);
        return aux_liste.stream()
                .sorted((o1, o2) -> (int) (o2.getPreis() - o1.getPreis()))
                .collect(Collectors.toList());
    }

    public void calculateLastPrice(List<Offerte> liste){
        liste.stream().forEach(offer -> offer.setPreis((int) (offer.getPreis()+ offer.getPreis()* offer.getMehrwertsteuer()/100)));
    }

    public Map<String,Integer> getBiggestEinkommen(List<Offerte> liste) {
        int a=0,b=0,c=0;
        for(Offerte o:liste){
            if(o.getOrt()==Thurgau)
                a+=o.getPreis();
            if(o.getOrt()==Zürich)
                b+=o.getPreis();
            if(o.getOrt()==St_Gallen)
                c+=o.getPreis();
        }
        Map<String,Integer> map=new HashMap<>();
        map.put("Thurgau",a);
        map.put("Zürich",b);
        map.put("St_Gallen",c);

        return map;
    }
}
