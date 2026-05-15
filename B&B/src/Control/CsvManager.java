/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Housing;
import Model.Booking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author franc
 */
public class CsvManager {
    private static ArrayList<String[]> datiAlloggi = new ArrayList<>();
    private static ArrayList<String[]> datiPrenotazioni = new ArrayList<>();
    private static ArrayList<String[]> datiRegistrati = new ArrayList<>();

    public static ArrayList<String[]> getDatiRegistrati() {
        return datiRegistrati;
    }
    
    public static void leggiCSV(String percorso,ArrayList<String[]> dati) {

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
    public static Map<String, String> load(String path)  {
        Map<String, String> config = new HashMap<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                // salta sezioni tipo [app]
                if (line.startsWith("[") || line.isEmpty()) continue;

                if (line.contains("=")) {
                    String[] parts = line.split("=");
                    config.put(parts[0].trim(), parts[1].trim());
                }
            }

            br.close();
        }catch(Exception e){
            config=null;
        }
        return config;
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