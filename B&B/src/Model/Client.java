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

    //public ArrayList<Booking> getPrenotazioni() {}
    public boolean prenota(String userName, String housingName, int firstDay, int lastDay, double price, Housing h,int cod){
        Booking prenotazione=new Booking( userName,  housingName,  firstDay,  lastDay, price, h,cod);
        if(prenotazione.calcolaDisponibilita(firstDay, lastDay) ){
            prenotazioni.add(prenotazione);
            return true;
        }
        return false;
    }
    
    public void annullaPrenotazione(int giornoInizio, int giornoFine) {}

    public ArrayList<Booking> getPrenotazioni() {
        return prenotazioni;
    }
    
}