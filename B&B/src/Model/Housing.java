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
    private ArrayList<String> dateDisponibili;
    private ArrayList<Review> recensioni;
    private String proprietario;

    private ArrayList<Boolean> disponibilita; // 365 giorni
    
    public Housing(String nome, String localita, int numeroCamere, double prezzo, ArrayList<String> servizi, String tipoAlloggio, ArrayList<String> dateDisponibili, ArrayList<Review> recensioni, String proprietario) {
        this.nome = nome;
        this.localita = localita;
        this.numeroCamere = numeroCamere;
        this.prezzo = prezzo;
        this.servizi = servizi;
        this.tipoAlloggio = tipoAlloggio;
        this.dateDisponibili = dateDisponibili;
        this.recensioni = recensioni;
        this.proprietario = proprietario;
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

    public ArrayList<String> getDateDisponibili() {
        return dateDisponibili;
    }

    public ArrayList<Review> getRecensioni() {
        return recensioni;
    }

    public String getProprietario() {
        return proprietario;
    }

    public ArrayList<Boolean> getDisponibilita() {
        return disponibilita;
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

    public void setDateDisponibili(ArrayList<String> dateDisponibili) {
        this.dateDisponibili = dateDisponibili;
    }

    public void setRecensioni(ArrayList<Review> recensioni) {
        this.recensioni = recensioni;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public void setDisponibilita(ArrayList<Boolean> disponibilita) {
        this.disponibilita = disponibilita;
    }

    // LOGICA
    public boolean verificaDisponibilita(int giornoInizio, int giornoFine) {
    
        for(int i = giornoInizio; i < giornoFine; i++ ){
            if(disponibilita.get(i) == false) return false;
        }
        return true;
    }

    public double calcolaMediaRecensioni() {
        double somma = 0;
        
        for(int i = 0; i < recensioni.size(); i++ ){
            somma = somma + recensioni.get(i).getVote(); 
        }
        return somma / recensioni.size();
    }
    
    public int NumeroRecensioni(){
        return recensioni.size();
    }
    public boolean haServizio(String servizio){
        
        for (int i = 0; i < servizi.size(); i++){
            if(servizio.equals(servizi.get(i))) return true;
        }
        return false;
    }
    
    public void aggiungiServizio(String servizio){
        servizi.add(servizio);
    }
    
    public void rimuoviServizio(String servizio){
        servizi.remove(servizio);
    }
    
    public boolean soddisfaPrezzo(double maxPrezzo){
        if(prezzo <= maxPrezzo) return true;
        else return false;
    }
    
    public boolean haNumeroCamere(int minCamere){
        if(numeroCamere >= minCamere) return true;
        else return false;
    }
    
    
    
}