/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Housing;
import Model.Booking;
import java.util.ArrayList;

/**
 *
 * @author franc
 */

public class Manager {

    private ArrayList<Housing> alloggi;
    private ArrayList<Booking> prenotazioni;
    private CsvManager csvManager;

    public Manager() {}

    // FILE
    public void caricaDatabase(String pathAlloggi, String pathPrenotazioni) {}

    public void salvaDatabase(String pathAlloggi, String pathPrenotazioni) {}
    // =====================
    //  RICERCA (CLIENTE)
    // =====================
    public ArrayList<Housing> cercaPerLocalita(String localita) {}

    public ArrayList<Housing> cercaPerPrezzo(double maxPrezzo) {}

    public ArrayList<Housing> cercaPerServizio(String servizio) {}

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
    public void aggiungiAlloggio(Housing a) {}

    public void rimuoviAlloggio(String nome) {}

    public void modificaAlloggio(String nome, Housing nuovo) {}

    public ArrayList<Housing> getAlloggi() {}

    // =====================
    // EXTRA
    // =====================
    public Housing trovaAlloggioPerNome(String nome) {}
}
