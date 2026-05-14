/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Housing;
import Model.Booking;
import Model.Review;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.console;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author franc
 */
public class CsvManager {
    private static ArrayList<String[]> datiAlloggi = new ArrayList<>();
    private static ArrayList<String[]> datiPrenotazioni = new ArrayList<>();
    

    
    
    

    public void leggiCSV(String percorso,ArrayList<String[]> dati) {

        try {

            BufferedReader br = new BufferedReader(new FileReader(percorso));

            String riga;
            riga = br.readLine();
            while((riga = br.readLine()) != null) {

                String[] valori = riga.split(";");

                dati.add(valori);
            }

            br.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String[]> getDati(ArrayList<String[]> dati) {
        return dati;
    }
    public void salva(String path,ArrayList<String[]> dati){
        String nomeFile = path;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile))) {
        for(String[] x:dati){
           for(String y:x){
               writer.write(y+";");
           }
           writer.newLine();
        }
        
        // per andare a capo

        }

        catch (IOException e) {

        // error caught instructions

        }
    }

    public static ArrayList<String[]> getDatiAlloggi() {
        return datiAlloggi;
    }

    public static ArrayList<String[]> getDatiPrenotazioni() {
        return datiPrenotazioni;
    }
    
    public void delete(int indice){
        /* 
        for(String[] x: dati){
            if(x[0]==hotel){
                dati.remove(x);
                break;
            }
        }
        */
    }
}