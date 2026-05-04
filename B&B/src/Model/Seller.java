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

    public Seller(String username, String password) {
        super(username, password);
    }

    public ArrayList<Housing> getAlloggiGestiti() {}

    public void aggiungiAlloggio(Housing a) {}

    public void rimuoviAlloggio(Housing a) {}

    public void modificaAlloggio(Housing vecchio, Housing nuovo) {}
}
