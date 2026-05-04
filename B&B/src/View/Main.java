package View;

import Control.Manager;
import Model.Housing;
import Model.Review;
import java.util.ArrayList;
import java.util.List;

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
        gestore.caricaDatabase("alloggi.csv", "prenotazioni.csv");

        // CREAZIONE ALLOGGIO
        List<String> servizi = new ArrayList<>();
        servizi.add("wifi");
        servizi.add("cucina");

        Housing a = new Housing("Casa Bella", "Roma", 3, 80.0, servizi, "appartamento");
        gestore.aggiungiAlloggio(a);

        // RICERCA
        List<Housing> risultati = gestore.cercaPerLocalita("Roma");

        // PRENOTAZIONE
        boolean esito = gestore.prenota("mario", "Casa Bella", 10, 15);

        // RECENSIONE
        Review r = new Review("mario", 5, "Bellissimo!");
        gestore.aggiungiRecensione("Casa Bella", r);

        // SALVATAGGIO
        gestore.salvaDatabase("alloggi.csv", "prenotazioni.csv");

        System.out.println("Test completato.");
    }
}
