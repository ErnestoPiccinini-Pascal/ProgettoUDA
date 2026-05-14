/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Housing;
import Model.Booking;
import Model.Client;
import Model.Review;
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
    private ArrayList<Client> clienti;
  //  private ArrayList<String[]> dati=new ArrayList<>();
    private ArrayList<Review> recensioniMaster=new ArrayList<>();
    private Map<String, Seller> proprietari = new HashMap<>();
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
        ArrayList<Review> recensioni;
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
                valori[7]=valori[7].substring(2, valori[7].length()-2);
                System.out.println(valori[7]);
                String[] valtotrec=valori[7].split("\\|");
                System.out.println(valtotrec[0]);
                for(String x: valtotrec){
                    
                    String[] valrec=x.split(",");
                    Review g=new Review(valrec[0],Integer.parseInt(valrec[1]),valrec[2]);
                    recensioni.add(g);
                    recensioniMaster.add(g);
                }
                
                proprietario=valori[8];
                alloggi.add(new Housing(nome,localita,numeroCamere,prezzo,servizi,tipoAlloggio,dateDisponibili,recensioni,proprietario,cod));
                if(proprietari.get(proprietario).equals(null)){
                    proprietari.put(proprietario, new Seller(null,"",""));
                }
                proprietari.get(proprietario).aggiungiAlloggio(new Housing(nome,localita,numeroCamere,prezzo,servizi,tipoAlloggio,dateDisponibili,recensioni,proprietario,cod));
                cod++;
                
            }
            
    }
    
    public Manager() throws Exception {
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
        posti=null;
        for(Housing x:alloggi){
            if(x.soddisfaPrezzo(prezzo)){
               posti.add(x);
            }
        }return posti;
    }
    public ArrayList<Housing> ricercaperServizio(String servizio){
        ArrayList<Housing> posti=new ArrayList<>();
        posti=null;
        for(Housing x:alloggi){
            if(x.haServizio(servizio)){
                posti.add(x);
            }
        }return posti;
    }
    public ArrayList<Housing> ricercapernCamere(int numero){
        ArrayList<Housing> posti=new ArrayList<>();
        posti=null;
        for(Housing x:alloggi){
            if(x.haNumeroCamere(numero)){
                posti.add(x);
            }
        }return posti;
    }
    public ArrayList<Housing> ricercaperProprietario(String p){
     return proprietari.get(p).getAlloggiGestiti();
    }
    public boolean creaPrenotazione(Client prenotante, String userName, String housingName, int firstDay, int lastDay, double price, Housing h){
       return prenotante.prenota(userName, housingName, firstDay, lastDay, price, h);
       
    }
    public void aggiungiAlloggio(Housing a) {
    }

    public void rimuoviAlloggio(String nome) {}

    public void modificaAlloggio(String nome, Housing nuovo) {}


}
