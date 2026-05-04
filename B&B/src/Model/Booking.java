/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author franc
 */
public class Booking {

    private String nomeUtente;
    private String nomeAlloggio;
    private int giornoInizio;
    private int giornoFine;

    public Booking(String nomeUtente, String nomeAlloggio, int giornoInizio, int giornoFine) {
        this.nomeUtente = nomeUtente;
        this.nomeAlloggio = nomeAlloggio;
        this.giornoInizio = giornoInizio;
        this.giornoFine = giornoFine;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public String getNomeAlloggio() {
        return nomeAlloggio;
    }

    public int getGiornoInizio() {
        return giornoInizio;
    }

    public int getGiornoFine() {
        return giornoFine;
    }

}
