/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Housing;
import Model.Booking;
import Model.Client;
import Model.Seller;
import Model.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author franc
 */

public class Manager {


    private ArrayList<Housing> alloggi;
  //  private ArrayList<String[]> dati=new ArrayList<>();
    
    private Map<String,String> registrati=new HashMap<>();

    private Map<String, Seller> proprietari = new HashMap<>();
    private Map<String, Client> clienti = new HashMap<>();
    private CsvManager csv=new CsvManager();
            
    private static int annoCorrente=2026;
    public void caricaAlloggi() {
        alloggi=new ArrayList<>();
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
        ArrayList<Double> recensioni;
        //8
        String proprietario;
        //9
        int  cod=0;
            for(String[] riga:CsvManager.getDatiAlloggi()){
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
                    dateDisponibili[this.giornoaIndice(x)]=false;
                }
                recensioni=new ArrayList<>();
                valori[7]=valori[7].substring(1, valori[7].length()-2);
                for(String x: valori[7].split(",")){
                    recensioni.add(Double.valueOf(x));
                }
               
                proprietario=valori[8];
                if(proprietari.get(proprietario)==null ){
                    proprietari.put(proprietario, new Seller(null,"",""));
                }
                alloggi.add(new Housing(nome,localita,numeroCamere,prezzo,servizi,tipoAlloggio,dateDisponibili,recensioni,proprietario,cod));
                
                proprietari.get(proprietario).aggiungiAlloggio(new Housing(nome,localita,numeroCamere,prezzo,servizi,tipoAlloggio,dateDisponibili,recensioni,proprietario,cod));
                cod++;
                
            }
            
    }
    
    public Manager() {
    }
    private static ArrayList<Integer> mesi = new ArrayList<>(
        Arrays.asList(0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334)
    );
    // FILE
    //public void caricaDatabase(String pathAlloggi, String pathPrenotazioni) {}

   // public void salvaDatabase(String pathAlloggi, String pathPrenotazioni) {}
    public int giornoaIndice(String giorno){
        String[] tokens=giorno.split("/");
        int somma=Integer.parseInt(tokens[0])+mesi.get(Integer.parseInt(tokens[1])-1);
        return somma;
    }
     static public String indiceaGiorno (int indice){
        String mese;
        int i;
        for(i=11;i>0;i--){
            if(mesi.get(i)<indice){
                break;
            }
        }
        return (1+indice-mesi.get(i))+"/"+(i+1)+"/"+annoCorrente;
        
    }
     public static <T> String toCSV(ArrayList<T> list) {
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));

            if (i < list.size() - 1) {
                sb.append(",");
            }
        }

        sb.append("}");

        return sb.toString();
    }
    public ArrayList<Housing> ricercaperLocalità(String Località){
        ArrayList<Housing> posti=new ArrayList<>();
        posti=null;
        for(Housing x:alloggi){
            if(x.getLocalita().equals(Località)){
               posti.add(x);
            }
        }return posti;
    }
    public ArrayList<Housing> ricercaperPrezzoMin(Double prezzo){
        ArrayList<Housing> posti=new ArrayList<>();
        for(Housing x:alloggi){
            if(x.soddisfaPrezzo(prezzo)){
               posti.add(x);
            }
        }return posti;
    }
    public ArrayList<Housing> ricercaperServizio(String servizio){
        ArrayList<Housing> posti=new ArrayList<>();
        for(Housing x:alloggi){
            if(x.haServizio(servizio)){
                posti.add(x);
            }
        }return posti;
    }
    public ArrayList<Housing> ricercapernCamere(int numero){
        ArrayList<Housing> posti=new ArrayList<>();
        for(Housing x:alloggi){
            if(x.haNumeroCamere(numero)){
                posti.add(x);
            }
        }return posti;
    }
    public ArrayList<Housing> ricercaperProprietario(String p){
     return proprietari.get(p).getAlloggiGestiti();
    }
    public String[] alloggioaStringa(Housing a){
        return CsvManager.getDatiAlloggi().get(a.getCod());
    }
    public boolean creaPrenotazione(Client prenotante, String userName, String housingName, int firstDay, int lastDay, double price, Housing h){
       return prenotante.prenota(userName, housingName, firstDay, lastDay, price, h);
       
    }
    
    public void caricaRegistrati(String path){
        CsvManager.load(path);
        registrati=CsvManager.getDatiRegistrati();
    }
    
    public void delete(int indice){
        CsvManager.getDatiAlloggi().remove(indice);
        this.caricaAlloggi();
    }
    public void aggiungiAlloggio(Housing a) {
    }

    public void rimuoviAlloggio(String nome) {}

    public void modificaAlloggio(String nome, Housing nuovo) {}

    public Map<String, String> getRegistrati() {
        return registrati;
    }

    public Map<String, Seller> getProprietari() {
        return proprietari;
    }


}
