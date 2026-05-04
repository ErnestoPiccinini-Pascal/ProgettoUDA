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
public class Housing {

    private String nome;
    private String localita;
    private int numeroCamere;
    private double prezzo;
    private ArrayList<String> servizi;
    private String tipoAlloggio;
    private boolean[] disponibilita; // 365 giorni
    private ArrayList<Review> recensioni;

    public Housing(String nome, String localita, int numeroCamere, double prezzo, ArrayList<String> servizi, String tipoAlloggio, boolean[] disponibilita, ArrayList<Review> recensioni) {
        this.nome = nome;
        this.localita = localita;
        this.numeroCamere = numeroCamere;
        this.prezzo = prezzo;
        this.servizi = servizi;
        this.tipoAlloggio = tipoAlloggio;
        this.disponibilita = disponibilita;
        this.recensioni = recensioni;
    }

    // GETTER

    public String getNome() {
        return nome;
    }

    public String getLocalita() {
        return localita;
    }

    public int getNumeroCamere() {
        return numeroCamere;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public ArrayList<String> getServizi() {
        return servizi;
    }

    public String getTipoAlloggio() {
        return tipoAlloggio;
    }

    public boolean[] getDisponibilita() {
        return disponibilita;
    }

    public ArrayList<Review> getRecensioni() {
        return recensioni;
    }

    // SETTER

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLocalita(String localita) {
        this.localita = localita;
    }

    public void setNumeroCamere(int numeroCamere) {
        this.numeroCamere = numeroCamere;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setServizi(ArrayList<String> servizi) {
        this.servizi = servizi;
    }

    public void setTipoAlloggio(String tipoAlloggio) {
        this.tipoAlloggio = tipoAlloggio;
    }

    public void setDisponibilita(boolean[] disponibilita) {
        this.disponibilita = disponibilita;
    }

    public void setRecensioni(ArrayList<Review> recensioni) {
        this.recensioni = recensioni;
    }
    

    // LOGICA
    public boolean verificaDisponibilita(int giornoInizio, int giornoFine) {}

    public double calcolaMediaRecensioni() {}
}