/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Housing;
import Model.Booking;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author franc
 */
public class CsvManager {
    private ArrayList<String[]> dati = new ArrayList<>();

    //public ArrayList<Housing> caricaAlloggi(String path) {}

    public void salvaAlloggi(String path, ArrayList<Housing> lista) {}

    //public ArrayList<Booking> caricaPrenotazioni(String path) {}

    public void salvaPrenotazioni(String path, ArrayList<Booking> lista) {}
    

    public void leggiCSV(String percorso) {

        try {

            BufferedReader br = new BufferedReader(new FileReader(percorso));

            String riga;

            while((riga = br.readLine()) != null) {

                String[] valori = riga.split(";");

                dati.add(valori);
            }

            br.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String[]> getDati() {
        return dati;
    }
}