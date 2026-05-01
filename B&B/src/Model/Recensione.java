/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author franc
 */
public class Recensione {

    private String autore;
    private int voto;
    private String commento;

    public Recensione(String autore, int voto, String commento) {
        this.autore = autore;
        this.voto = voto;
        this.commento = commento;
    }

    public String getAutore() {
        return autore;
    }

    public int getVoto() {
        return voto;
    }

    public String getCommento() {
        return commento;
    }

}
