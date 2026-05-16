/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc
 */
public class CsvManager {
    private static ArrayList<String[]> datiAlloggi = new ArrayList<>();
    private static ArrayList<String[]> datiPrenotazioni = new ArrayList<>();
    private static Map<String, String> datiRegistrati = new HashMap<>();

    public static  Map<String, String> getDatiRegistrati() {
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
        Map<String, String> users = new HashMap<>();

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("config.ini"));
             String line;
            while ((line = br.readLine()) != null) {
            line = line.trim();

            if (line.isEmpty() || line.startsWith("[")) continue;

            String[] parts = line.split("=");

            if (parts.length == 2) {
                String user = parts[0].trim();
                String pass = parts[1].trim();

                users.put(user, pass);
            }
        }
        } catch (Exception ex) {
            Logger.getLogger(CsvManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void load(String path)  {
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
        datiRegistrati=config;
    }
    public static ArrayList<String[]> getDatiAlloggi() {
        return datiAlloggi;
    }

    public static ArrayList<String[]> getDatiPrenotazioni() {
        return datiPrenotazioni;
    }
    
   
}