package com.company;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FileRepo repo = new FileRepo();
        ListController ctrl = new ListController();

        try {
            List<Offerte> listeOfferten = repo.readFromFile("C:\\Users\\andre\\Documents\\stuff\\projects\\Java\\721_2_Cotofrei_Andrei_prb1\\src\\com\\company\\offerten.txt", "&");

            repo.writeToFile("C:\\Users\\andre\\Documents\\stuff\\projects\\Java\\721_2_Cotofrei_Andrei_prb1\\src\\com\\company\\offertensortiert.txt",ctrl.sortListeOffertenNachFinalPreis(listeOfferten),"&");

            repo.writeToFileString("C:\\Users\\andre\\Documents\\stuff\\projects\\Java\\721_2_Cotofrei_Andrei_prb1\\src\\com\\company\\statistik.txt",ctrl.getBiggestEinkommen(listeOfferten).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
