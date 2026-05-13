/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Housing;
import Model.Booking;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author franc
 */

public class Manager {

    private ArrayList<Housing> alloggi;
    private ArrayList<Booking> prenotazioni;
    private CsvManager csvManager;
    private int annoCorrente=2026;
    public Manager() {}
    private ArrayList<Integer> mesi = new ArrayList<>(
        Arrays.asList(0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334)
    );
    // FILE
    public void caricaDatabase(String pathAlloggi, String pathPrenotazioni) {}

    public void salvaDatabase(String pathAlloggi, String pathPrenotazioni) {}
    public int giornoaIndice(String giorno){
        String[] tokens=giorno.split("/");
        int somma=Integer.parseInt(tokens[0])+mesi.get(Integer.parseInt(tokens[1])-1);
        return somma;
    }
    public String indiceaGiorno (int indice){
        String mese;
        int i;
        for(i=11;i>-1;i--){
            if(mesi.get(i)<indice){
                break;
            }
        }
        return indice-mesi.get(i)+"/"+i+"/"+annoCorrente;
        
    }
    // =====================
    //  RICERCA (CLIENTE)
    // =====================
    //public ArrayList<Housing> cercaPerLocalita(String localita) {}

    //public ArrayList<Housing> cercaPerPrezzo(double maxPrezzo) {}

    //public ArrayList<Housing> cercaPerServizio(String servizio) {}

    // =====================
    // 🛏️ PRENOTAZIONE
    // =====================
    //public boolean prenota(String username, String nomeAlloggio,int giornoInizio, int giornoFine) {}

    // =====================
    // ⭐ RECENSIONI
    // =====================
    //public void aggiungiRecensione(String nomeAlloggio, Recensione r) {}

    // =====================
    // 🧑‍💼 CRUD VENDITORE
    // =====================
    public void aggiungiAlloggio(Housing a) {}

    public void rimuoviAlloggio(String nome) {}

    public void modificaAlloggio(String nome, Housing nuovo) {}

    //public ArrayList<Housing> getAlloggi() {}

    // =====================
    // EXTRA
    // =====================
    //public Housing trovaAlloggioPerNome(String nome) {}
}
