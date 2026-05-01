/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;



/**
 *
 * @author franc
 */
public class Cliente extends Utente {

    private ArrayList<Prenotazione> prenotazioni;

    public Cliente(String username, String password) {
        super(username, password);
    }

    public ArrayList<Prenotazione> getPrenotazioni() {}

    public void lasciaRecensione(Alloggio a, Recensione r) {}
    
    public void prenota(int giornoInizio, int giornoFine, String nomeUtente, String nomeAlloggio) {}
    
    public void annullaPrenotazione(int giornoInizio, int giornoFine) {}

    public void aggiungiRecensione(Recensione r) {}
}
