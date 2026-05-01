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
public class Venditore extends Utente {

    private ArrayList<Alloggio> alloggiGestiti;

    public Venditore(String username, String password) {
        super(username, password);
    }

    public ArrayList<Alloggio> getAlloggiGestiti() {}

    public void aggiungiAlloggio(Alloggio a) {}

    public void rimuoviAlloggio(Alloggio a) {}

    public void modificaAlloggio(Alloggio vecchio, Alloggio nuovo) {}
}
