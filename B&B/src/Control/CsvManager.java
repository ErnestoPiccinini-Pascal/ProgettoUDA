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
    private ArrayList<String[]> dati = new ArrayList<>();
    private Manager man=new Manager();
    
    public ArrayList<Housing> caricaAlloggi() {
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
        ArrayList<Review> recensioni;
        //8
        String proprietario;
        
            for(String[] riga:dati){
                for(String x:riga){
                    x.replace("\"","");
                }
                
                String[] valori = riga;
                nome=valori[0];
                localita=valori[1];
                numeroCamere=Integer.parseInt(valori[2]);
                prezzo=Double.parseDouble(valori[3]);
                valori[4]=valori[4].substring(1, valori[4].length()-2);
                servizi=new ArrayList<>();
                for(String x: valori[4].split(",")){
                    servizi.add(x);
                }
                tipoAlloggio=valori[5];
                dateDisponibili=new Boolean[365];
                Arrays.fill(dateDisponibili, true);
                valori[6]=valori[6].substring(2, valori[6].length()-2);
                for(String x: valori[6].split(",")){
                    dateDisponibili[man.giornoaIndice(x)]=false;
                }
                recensioni=new ArrayList<>();
                valori[7]=valori[7].substring(2, valori[7].length()-2);
                System.out.println(valori[7]);
                String[] valtotrec=valori[7].split("\\|");
                System.out.println(valtotrec[0]);
                for(String x: valtotrec){
                    
                    String[] valrec=x.split(",");
                    Review g=new Review(valrec[0],Integer.parseInt(valrec[1]),valrec[2]);
                    recensioni.add(g);
                }
                
                proprietario=valori[8];
                alloggi.add(new Housing(nome,localita,numeroCamere,prezzo,servizi,tipoAlloggio,dateDisponibili,recensioni,proprietario));
                
                
                
            }
            


            return alloggi;
    }

    public void salvaAlloggi(String path, ArrayList<Housing> lista) {
        
    
    }
    
    

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
    public void salva(String path){
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