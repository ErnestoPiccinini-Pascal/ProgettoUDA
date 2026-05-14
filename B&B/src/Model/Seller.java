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
public class Seller extends User {

    private ArrayList<Housing> alloggiGestiti;

    public Seller(ArrayList<Housing> alloggiGestiti, String username, String password) {
        super(username, password);
        this.alloggiGestiti = new ArrayList<>();
    }


    public ArrayList<Housing> getAlloggiGestiti() {
        return alloggiGestiti;
    }

    public void aggiungiAlloggio(Housing a) {
        alloggiGestiti.add(a);
    }

    public void rimuoviAlloggio(Housing a) {
        alloggiGestiti.remove(a);
    }

    public void modificaAlloggio(Housing vecchio, Housing nuovo) {
    }

    public void add(Housing housing) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
