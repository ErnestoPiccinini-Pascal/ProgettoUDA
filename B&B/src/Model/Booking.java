/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author franc
 */
public class Booking {

    private String userName;
    private String housingName;
    private int firstDay;
    private int lastDay;
    private double price;
    Housing alloggio;
    private int cod;
    
    public Booking(String userName, String housingName, int firstDay, int lastDay, double price, Housing h,int cod) {
        this.userName = userName;
        this.housingName = housingName;
        this.firstDay = firstDay;
        this.lastDay = lastDay;
        this.price = price;
        price=price*(lastDay-firstDay);
        this.alloggio = h;
        this.cod=cod;
    }

    public int getCod() {
        return cod;
    }

 
    public String getUserName() {
        return userName;
    }

    public String getHousingName() {
        return housingName;
    }

    public int getFirstDay() {
        return firstDay;
    }

    public int getLastDay() {
        return lastDay;
    }
    
    public int getDurata(){
        return lastDay - firstDay;
    }
    
    public double calcolaCosto(){
        return price * getDurata();
    }
    
    public boolean book(int inizio,int fine){
        for(int i = inizio; i < fine ; i++){
            if(alloggio.getDateDisponibili()[i] == false) return false;
        }
        for(int i = inizio ; i < fine; i++){
            alloggio.getDateDisponibili()[i]=true;
        }
        return true;
    }
    
    public boolean calcolaDisponibilita(int primoGiorno,int ultimoGiorno){
       return alloggio.verificaDisponibilita(primoGiorno,ultimoGiorno);
    }
    
    public boolean estendi(int giorniDaEstendere){
        int newLastDay = lastDay + giorniDaEstendere;
        if(calcolaDisponibilita(firstDay,newLastDay) == false) return false;
        else{
            lastDay = newLastDay;
            book(firstDay,newLastDay);
            return true;
        }
    }
    
    public boolean riduci(int giorniDaRidurre){
        int newLastDay = lastDay - giorniDaRidurre;
        for(int i = newLastDay; i < lastDay; i++){
            alloggio.getDateDisponibili()[i]= true;
        }
        lastDay = newLastDay;
        return true;
    }
    
    public boolean nelPeriodo(int inizio, int fine){
        if(firstDay > inizio && firstDay < fine && lastDay < fine && lastDay > inizio) return true;
        else return false;
    }
    
}
