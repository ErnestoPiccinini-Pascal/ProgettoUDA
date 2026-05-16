/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Housing;
import Model.Booking;
import Model.Client;
import Model.Seller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author franc
 */

public class Manager {


    private static ArrayList<Housing> alloggi;
  //  private ArrayList<String[]> dati=new ArrayList<>();
    
    private static Map<String,String> registrati=new HashMap<>();

    private static Map<String, Seller> proprietari = new HashMap<>();
    private static Map<String, Client> clienti = new HashMap<>();
    private CsvManager csv=new CsvManager();
    private static String utenteAtt;
    private static int annoCorrente=2026;
    //----------------------------------------------- ALLOGGI------------------------------------
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

        for(String[] riga:CsvManager.getDatiAlloggi()){
            Arrays.setAll(riga, i -> riga[i].replace("\"", "").trim());
            Arrays.setAll(riga, i -> riga[i].replace("{", "").trim());
            Arrays.setAll(riga, i -> riga[i].replace("}", "").trim());
            String[] valori = riga;
            nome=valori[0];
            localita=valori[1];
            numeroCamere=Integer.parseInt(valori[2]);
            prezzo=Double.parseDouble(valori[3]);

            servizi=new ArrayList<>();
            for(String x: valori[4].split(",")){
                servizi.add(x);
            }
            tipoAlloggio=valori[5];
            dateDisponibili=new Boolean[365];
            Arrays.fill(dateDisponibili, true);
            for(String x: valori[6].split(",")){
                dateDisponibili[this.giornoaIndice(x)]=false;
            }
            recensioni=new ArrayList<>();
            for(String x: valori[7].split(",")){
                recensioni.add(Double.valueOf(x));
            }

            proprietario=valori[8].toLowerCase();
            if(proprietari.get(proprietario)==null ){
                proprietari.put(proprietario, new Seller(null,"",""));
                proprietari.put(proprietario.toLowerCase(), new Seller(null,"",""));
            }
            alloggi.add(new Housing(nome,localita,numeroCamere,prezzo,servizi,tipoAlloggio,dateDisponibili,recensioni,proprietario));

            proprietari.get(proprietario).aggiungiAlloggio(new Housing(nome,localita,numeroCamere,prezzo,servizi,tipoAlloggio,dateDisponibili,recensioni,proprietario));

        }
            
    }

    public static ArrayList<Housing> getAlloggi() {
        return alloggi;
    }
    
    public void vediAlloggi(){
        for(Housing x : alloggi){
            System.out.println("ALLOGGI " + x.getLocalita());
        }
    }
    
    public Manager() {
        
    }
    private static ArrayList<Integer> mesi = new ArrayList<>(
        Arrays.asList(0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334)
    );
  
    public int giornoaIndice(String giorno){
        String[] tokens=giorno.split("/");
        int somma=Integer.valueOf(tokens[0])+mesi.get(Integer.parseInt(tokens[1])-1);
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
        for(Housing x:alloggi){
            if(x.getLocalita().toLowerCase().equals(Località.toLowerCase())){
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
    public ArrayList<Housing> ricercaperProprietario(String p){
     return proprietari.get(p).getAlloggiGestiti();
    }

    public String[] alloggioaStringa(Housing a){
        return CsvManager.getDatiAlloggi().get(a.getCod());
    }
    
    public void caricaRegistrati(String path){
        CsvManager.load(path);
        registrati=CsvManager.getDatiRegistrati();
    }
    
    public void deleteAlloggio(int indice){
        CsvManager.getDatiAlloggi().remove(indice);
        this.caricaAlloggi();
    }
   
    public void modificaAlloggio(int indice, Housing nuovo) {
        alloggi.set(indice, nuovo);
        String[] s= CsvManager.getDatiAlloggi().set(indice, this.alloggioaStringa(nuovo));
         List<String> g=Arrays.asList(s);
        CsvManager.setDatiAlloggi(CsvManager.getDatiAlloggi());
    
    }

    public Map<String, String> getRegistrati() {
        return registrati;
    }
    public String usernameaNome(String userna){
        String[] s=userna.split(".");
        utenteAtt=(s[0].split(" ")[0]+s[0].split(" ")[1]).toLowerCase();
        return (s[0]+s[1]).toLowerCase();
        
    }
    
    public Map<String, Seller> getProprietari() {
        return proprietari;
    }

    public static String getUtenteAtt() {
        return utenteAtt;
    }
        
    
    public void caricaPrenotazioni() {
        //0
        String userName;
        //1
        String housingName;
        //2
        int firstDay;
        //3
        int lastDay;
        //4
        double price;
        int cod=0;
        Housing alloggio;

        boolean primaRiga = true;

        for (String[] riga : CsvManager.getDatiPrenotazioni()) {

            // salta header csv
            if (primaRiga) {
                primaRiga = false;
                continue;
            }

            Arrays.setAll(riga, i -> riga[i].replace("\"", "").trim());

            String[] valori = riga;

            userName = valori[0];
            housingName = valori[1];

            // converte data -> indice
            firstDay = giornoaIndice(valori[2]);
            lastDay = giornoaIndice(valori[3]);

            price = Double.parseDouble(valori[4]);

            alloggio = null;

            // cerca alloggio
            for (Housing h : alloggi) {
                if (h.getNome().equalsIgnoreCase(housingName)) {
                    alloggio = h;
                    break;
                }
            }

            // crea cliente se non esiste
            if (clienti.get(userName.toLowerCase()) == null) {
                clienti.put(userName.toLowerCase(),new Client(userName, ""));
            }
            // aggiunge prenotazione al cliente
            clienti.get(userName.toLowerCase()).prenota(userName,housingName,firstDay,lastDay,price,alloggio);
            cod++;
        }
    }
    public ArrayList<Booking> ricercaperPrenotazione(String p){
     return clienti.get(p).getPrenotazioni();
    }
    public String[] prenotazioneaStringa(Booking b){
        return CsvManager.getDatiPrenotazioni().get(b.getCod());
    }
    public void prenota(String name, String userName, String housingName, int firstDay, int lastDay, double price, Housing h){
        clienti.get(name).prenota(userName, housingName, firstDay, lastDay, price, h);
    }
    public void aggiungiAlloggio(String name, String nome, String localita, int numeroCamere, double prezzo, ArrayList<String> servizi, String tipoAlloggio, Boolean[] dateDisponibili, ArrayList<Double> recensioni, String proprietario){
        Housing a=new Housing(nome,localita,numeroCamere,prezzo,servizi,tipoAlloggio,dateDisponibili,recensioni,proprietario);
        proprietari.get(name).aggiungiAlloggio(a);
    }

}