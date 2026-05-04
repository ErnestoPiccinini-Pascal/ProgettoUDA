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
public class Client extends User {

    private ArrayList<Booking> prenotazioni;

    public Client(String username, String password) {
        super(username, password);
    }

    public ArrayList<Booking> getPrenotazioni() {}

    public void lasciaRecensione(Housing a, Review r) {}
    
    public void prenota(int giornoInizio, int giornoFine, String nomeUtente, String nomeAlloggio) {}
    
    public void annullaPrenotazione(int giornoInizio, int giornoFine) {}

    public void aggiungiRecensione(Review r) {}
}
