/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Housing;
import Model.Booking;
import Model.Review;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author franc
 */
public class CsvManager {
    private ArrayList<String[]> dati = new ArrayList<>();
    private Manager man=new Manager();
    
    public ArrayList<Housing> caricaAlloggi(String path) {
        ArrayList<Housing> alloggi=new ArrayList<>();
        //0
        String nome;
        //1
        String localita;
        //2
        int numeroCamere;
        //3
        double prezzo;
        //4
        ArrayList<String> servizi;
        //5
        String tipoAlloggio;
        //6
        Boolean[] dateDisponibili;
        //7
        ArrayList<Review> recensioni=new ArrayList<>();
        //8
        String proprietario;
        
        try {

            BufferedReader br = new BufferedReader(new FileReader(path));

            String riga;
            riga = br.readLine();
            while((riga = br.readLine()) != null) {
                riga.replace("\"","");
                String[] valori = riga.split(";");
                nome=valori[0];
                localita=valori[1];
                numeroCamere=Integer.parseInt(valori[2]);
                prezzo=Double.parseDouble(valori[3]);
                valori[4]=valori[4].substring(1, valori[4].length()-1);
                servizi=new ArrayList<>();
                for(String x: valori[4].split(",")){
                    servizi.add(x);
                }
                tipoAlloggio=valori[5];
                dateDisponibili=new Boolean[365];
                Arrays.fill(dateDisponibili, true);
                valori[6]=valori[6].substring(1, valori[6].length()-1);
                for(String x: valori[6].split(",")){
                    dateDisponibili[man.giornoaIndice(x)]=false;
                }
                recensioni=null;
                proprietario=valori[8];
                alloggi.add(new Housing(nome,localita,numeroCamere,prezzo,servizi,tipoAlloggio,dateDisponibili,recensioni,proprietario));
                
                
                
            }
            

            br.close();
            return alloggi;

        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void salvaAlloggi(String path, ArrayList<Housing> lista) {}

    //public ArrayList<Booking> caricaPrenotazioni(String path) {}

    public void salvaPrenotazioni(String path, ArrayList<Booking> lista) {}
    

    public void leggiCSV(String percorso) {

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

    public ArrayList<String[]> getDati() {
        return dati;
    }
}