package View;

import Control.Manager;
import Model.Housing;
import Control.CsvManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author franc
 */
public class Main {

    public static void main(String[] args) {

            Manager gestore = new Manager();
            
            // CARICAMENTO DATI


        // CREAZIONE ALLOGGIO
        List<String> servizi = new ArrayList<>();
        servizi.add("wifi");
        servizi.add("cucina");

        //Housing a = new Housing("Casa Bella", "Roma", 3, 80.0, servizi, "appartamento");
        //gestore.aggiungiAlloggio(a);

        // RICERCA
        //List<Housing> risultati = gestore.cercaPerLocalita("Roma");

        // PRENOTAZIONE
        //boolean esito = gestore.prenota("mario", "Casa Bella", 10, 15);

        // RECENSIONE
        //gestore.aggiungiRecensione("Casa Bella", r);
        CsvManager e=new CsvManager();
        //ArrayList<Housing> j= e.caricaAlloggi("disponibilita.csv");
        e.leggiCSV("disponibilita.csv",CsvManager.getDatiAlloggi());
        gestore.caricaAlloggi();
        for(Housing x:gestore.ricercapernCamere(0)){
            ArrayList<String> h=new ArrayList(Arrays.asList(gestore.alloggioaStringa(x)));
            System.out.println(Manager.toCSV(h));
            
        }
        
                
       // e.salva("Salva.csv",CsvManager.getDatiAlloggi());
        //System.out.println(j.get(0).toString());
        
        
        // SALVATAGGIO
       // gestore.salvaDatabase("alloggi.csv", "prenotazioni.csv");

        System.out.println("Test completato.");
    }
}
