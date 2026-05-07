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

    public Booking(String userName, String housingName, int firstDay, int lastDay, double price) {
        this.userName = userName;
        this.housingName = housingName;
        this.firstDay = firstDay;
        this.lastDay = lastDay;
        this.price = price;
        price=price*(lastDay-firstDay);
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
    

}
