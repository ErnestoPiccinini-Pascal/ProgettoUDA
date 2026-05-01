/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Alloggio;
import Model.Prenotazione;
import java.util.ArrayList;

/**
 *
 * @author franc
 */

public class Gestore {

    private ArrayList<Alloggio> alloggi;
    private ArrayList<Prenotazione> prenotazioni;
    private CsvManager csvManager;

    public Gestore() {}

    // FILE
    public void caricaDatabase(String pathAlloggi, String pathPrenotazioni) {}

    public void salvaDatabase(String pathAlloggi, String pathPrenotazioni) {}
    // =====================
    //  RICERCA (CLIENTE)
    // =====================
    public ArrayList<Alloggio> cercaPerLocalita(String localita) {}

    public ArrayList<Alloggio> cercaPerPrezzo(double maxPrezzo) {}

    public ArrayList<Alloggio> cercaPerServizio(String servizio) {}

    // =====================
    // 🛏️ PRENOTAZIONE
    // =====================
    public boolean prenota(String username, String nomeAlloggio,int giornoInizio, int giornoFine) {}

    // =====================
    // ⭐ RECENSIONI
    // =====================
    public void aggiungiRecensione(String nomeAlloggio, Recensione r) {}

    // =====================
    // 🧑‍💼 CRUD VENDITORE
    // =====================
    public void aggiungiAlloggio(Alloggio a) {}

    public void rimuoviAlloggio(String nome) {}

    public void modificaAlloggio(String nome, Alloggio nuovo) {}

    public ArrayList<Alloggio> getAlloggi() {}

    // =====================
    // EXTRA
    // =====================
    public Alloggio trovaAlloggioPerNome(String nome) {}
}
