/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Housing;
import Model.Seller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author franc
 */

public class Manager {


    private static ArrayList<Housing> alloggi;
  //  private ArrayList<String[]> dati=new ArrayList<>();
    
    private static Map<String,String> registrati=new HashMap<>();

    public CsvManager getCsv() {
        return csv;
    }

    public static int getAnnoCorrente() {
        return annoCorrente;
    }

    public static ArrayList<Integer> getMesi() {
        return mesi;
    }

    private static Map<String, Seller> proprietari = new HashMap<>();

    private CsvManager csv=new CsvManager();
    private static String utenteAtt;
    private static int annoCorrente=2026;
    //----------------------------------------------- ALLOGGI------------------------------------
    public void caricaAlloggi() {

    alloggi = new ArrayList<>();
    proprietari = new HashMap<>(); 

    // 0
    String nome;
    String localita;
    int numeroCamere;
    double prezzo;
    ArrayList<String> servizi;
    String tipoAlloggio;
    Boolean[] dateDisponibili;
    ArrayList<Double> recensioni;
    String proprietario;

    int cod = 0;

    for (String[] riga : CsvManager.getDatiAlloggi()) {

        Arrays.setAll(riga, i -> riga[i].replace("\"", "").trim());
        Arrays.setAll(riga, i -> riga[i].replace("{", "").trim());
        Arrays.setAll(riga, i -> riga[i].replace("}", "").trim());

        nome = riga[0];
        localita = riga[1];
        numeroCamere = Integer.parseInt(riga[2]);
        prezzo = Double.parseDouble(riga[3]);

        servizi = new ArrayList<>();
        if (!riga[4].isEmpty()) {
            for (String x : riga[4].split(",")) {
                servizi.add(x.trim());
            }
        }

        tipoAlloggio = riga[5];

        dateDisponibili = new Boolean[365];
        Arrays.fill(dateDisponibili, true);

        if (!riga[6].isEmpty()) {
            for (String x : riga[6].split(",")) {
                dateDisponibili[giornoaIndice(x.trim())] = false;
            }
        }

        recensioni = new ArrayList<>();
        if (!riga[7].isEmpty()) {
            for (String x : riga[7].split(",")) {
                recensioni.add(Double.valueOf(x.trim()));
            }
        }

        proprietario = riga[8].toLowerCase();

        if (!proprietari.containsKey(proprietario)) {
            proprietari.put(proprietario, new Seller(null, "", ""));
        }

        Housing h = new Housing(
                nome, localita, numeroCamere, prezzo,
                servizi, tipoAlloggio,
                dateDisponibili, recensioni,
                proprietario, cod
        );

        alloggi.add(h);
        proprietari.get(proprietario).aggiungiAlloggio(h);

        cod++;
    }
}

    public static void setUtenteAtt(String utenteAtt) {
        Manager.utenteAtt = utenteAtt;
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
    public ArrayList<String[]> ricercaperProprietario(String p){
        ArrayList<String[]> s=new ArrayList<>();
        for(Housing x:proprietari.get(p).getAlloggiGestiti()){
            s.add(this.alloggioaStringa(x));
        }
      return s;
    }

    public String[] alloggioaStringa(Housing a){
       String[] dati = new String[10];

        dati[0] = a.getNome();
        dati[1] = a.getLocalita();
        dati[2] = String.valueOf(a.getNumeroCamere());
        dati[3] = String.valueOf(a.getPrezzo());

        dati[4] = a.getServizi().toString();
        dati[4] = dati[4].replace("[","");
        dati[4] = dati[4].replace("]","");
        
       
        

        dati[5] = a.getTipoAlloggio();
        ArrayList<String> date=new ArrayList<>();
        for(int i=0;i<365;i++){
            if(!a.getDateDisponibili()[i]){
                date.add(Manager.indiceaGiorno(i));
            }
        }
        
        dati[6] = Arrays.toString(date.toArray());
        dati[6] = dati[6].replace("[","");
        dati[6] = dati[6].replace("]","");
        
                
        dati[7] = a.getRecensioni().toString();
        dati[7] = dati[7].replace("[","");
        dati[7] = dati[7].replace("]","");

        dati[8] = a.getProprietario();
        //dati[9] = String.valueOf(a.getCod());

        return dati;
    }
    
    public static void caricaRegistrati(String path){
        CsvManager.load(path);
        registrati=CsvManager.getDatiRegistrati();
    }
    
    public void delete(Housing daEliminare) {

        // RIMUOVE DA LISTA GLOBALE
        alloggi.removeIf(h ->
                h.getCod() == daEliminare.getCod()
        );

        // RIMUOVE DAL PROPRIETARIO
        if (proprietari.get(daEliminare.getProprietario()) != null) {
            proprietari.get(daEliminare.getProprietario())
                    .getAlloggiGestiti()
                    .removeIf(h ->
                            h.getCod() == daEliminare.getCod()
                    );
        }

        // RIMUOVE DAL CSV (IN MEMORIA)
        CsvManager.getDatiAlloggi().removeIf(riga -> {

            if (riga == null || riga.length < 9) {
                return false;
            }

            return riga[0].equalsIgnoreCase(daEliminare.getNome())
                    && riga[8].equalsIgnoreCase(daEliminare.getProprietario());
        });
    }
   
    public void modificaAlloggio(String[] valori, Housing vecchio) {

        // PULIZIA STRINGHE
        for (int i = 0; i < valori.length; i++) {

            if (valori[i] != null) {

                valori[i] = valori[i]
                        .replace("\"", "")
                        .replace("{", "")
                        .replace("}", "")
                        .replace("[", "")
                        .replace("]", "")
                        .trim();
            }
        }

        // DATI BASE
        String nome = valori[0];
        String localita = valori[1];
        int numeroCamere = Integer.parseInt(valori[2]);
        double prezzo = Double.parseDouble(valori[3]);

        // SERVIZI
        ArrayList<String> servizi = new ArrayList<>();

        if (!valori[4].isEmpty()) {

            for (String x : valori[4].split(",")) {
                servizi.add(x.trim());
            }
        }

        // TIPO
        String tipoAlloggio = valori[5];

        // DATE
        Boolean[] dateDisponibili = new Boolean[365];
        Arrays.fill(dateDisponibili, true);

        if (!valori[6].isEmpty()) {

            for (String x : valori[6].split(",")) {

                x = x.trim();

                if (!x.isEmpty()) {
                    dateDisponibili[this.giornoaIndice(x)] = false;
                }
            }
        }

        // RECENSIONI
        ArrayList<Double> recensioni = new ArrayList<>();

        if (!valori[7].isEmpty()) {

            for (String x : valori[7].split(",")) {

                x = x.trim();

                if (!x.isEmpty()) {
                    recensioni.add(Double.valueOf(x));
                }
            }
        }

        // CREA NUOVO ALLOGGIO
        Housing nuovo = new Housing(
                nome,
                localita,
                numeroCamere,
                prezzo,
                servizi,
                tipoAlloggio,
                dateDisponibili,
                recensioni,
                vecchio.getProprietario(),
                vecchio.getCod()
        );

        // AGGIORNA LISTA GLOBALE
        for (int i = 0; i < alloggi.size(); i++) {

            if (alloggi.get(i).getCod() == vecchio.getCod()) {

                alloggi.set(i, nuovo);
                break;
            }
        }

        // AGGIORNA LISTA DEL PROPRIETARIO
        ArrayList<Housing> lista =
                proprietari.get(vecchio.getProprietario())
                        .getAlloggiGestiti();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getCod() == vecchio.getCod()) {

                lista.set(i, nuovo);
                break;
            }
        }

        // AGGIORNA DATI CSV IN MEMORIA
        for (int i = 0; i < CsvManager.getDatiAlloggi().size(); i++) {

            String[] riga = CsvManager.getDatiAlloggi().get(i);

            if (riga[0].equalsIgnoreCase(vecchio.getNome())
                    && riga[8].equalsIgnoreCase(vecchio.getProprietario())) {

                CsvManager.getDatiAlloggi().set(i, valori);
                break;
            }
        }
    }
    public void inserisciAlloggio(String[] valori) {

    for (int i = 0; i < valori.length; i++) {

            if (valori[i] != null) {

                valori[i] = valori[i]
                        .replace("\"", "")
                        .replace("{", "")
                        .replace("}", "")
                        .replace("[", "")
                        .replace("]", "")
                        .trim();
            }
        }

        String nome = valori[0];
        String localita = valori[1];
        int numeroCamere = Integer.parseInt(valori[2]);
        double prezzo = Double.parseDouble(valori[3]);

        ArrayList<String> servizi = new ArrayList<>();

        if (!valori[4].isEmpty()) {

            for (String x : valori[4].split(",")) {
                servizi.add(x.trim());
            }
        }

        String tipoAlloggio = valori[5];

        Boolean[] dateDisponibili = new Boolean[365];
        Arrays.fill(dateDisponibili, true);

        if (!valori[6].isEmpty()) {

            for (String x : valori[6].split(",")) {

                x = x.trim();

                if (!x.isEmpty()) {
                    dateDisponibili[this.giornoaIndice(x)] = false;
                }
            }
        }

        ArrayList<Double> recensioni = new ArrayList<>();

        if (!valori[7].isEmpty()) {

            for (String x : valori[7].split(",")) {

                x = x.trim();

                if (!x.isEmpty()) {
                    recensioni.add(Double.valueOf(x));
                }
            }
        }

        int cod = alloggi.size();

        Housing nuovo = new Housing(
                nome,
                localita,
                numeroCamere,
                prezzo,
                servizi,
                tipoAlloggio,
                dateDisponibili,
                recensioni,
                Manager.getUtenteAtt(),
                cod
        );

        // AGGIUNTA LISTE
        alloggi.add(nuovo);

        proprietari.get(Manager.getUtenteAtt())
                .aggiungiAlloggio(nuovo);

        // AGGIUNTA CSV
        CsvManager.getDatiAlloggi().add(valori);
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
        
    
    
    
    

}