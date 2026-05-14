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
    private ArrayList<Review> recensioni;
    
    public Client(String username, String password) {
        super(username, password);
    }

    //public ArrayList<Booking> getPrenotazioni() {}
    public boolean prenota(String userName, String housingName, int firstDay, int lastDay, double price, Housing h){
        Booking prenotazione=new Booking( userName,  housingName,  firstDay,  lastDay, price, h);
        if(prenotazione.calcolaDisponibilita(firstDay, lastDay) ){
            prenotazioni.add(prenotazione);
            return true;
        }
        return false;
    }
    public void lasciaRecensione(Housing a, Review r) {}
    
    
    
    public void annullaPrenotazione(int giornoInizio, int giornoFine) {}

    public void aggiungiRecensione(Review r) {}
}
