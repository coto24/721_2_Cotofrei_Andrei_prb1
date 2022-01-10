package com.company;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<Offerte> sortListeOffertenNachPreis(List<Offerte> liste) {
        return liste.stream()
                .sorted((o1, o2) -> (int) (o2.getPreis() + o2.getPreis()*o2.getMehrwertsteuer() - o1.getPreis() + o1.getPreis()*o1.getMehrwertsteuer()))
                .collect(Collectors.toList());
    }

    public List<Offerte> calculateLastPrice(List<Offerte> liste){
        return liste.stream()
                .forEach();
    }
}
