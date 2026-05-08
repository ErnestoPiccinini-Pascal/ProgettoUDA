/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author franc
 */
public class Review {

    private String author;
    private int vote;
    private String comments;

    public String getAuthor() {
        return author;
    }

    public int getVote() {
        return vote;
    }

    public String getComments() {
        return comments;
    }

    public Review(String author, int vote, String comments) {
        this.author = author;
        this.vote = vote;
        this.comments = comments;
    }
    

    
    public boolean findWord(String serchedWord){
        String words[] = comments.split(" ");
        
        for(String w : words){
            if(w.equals(serchedWord)) return true;
        } 
        return false;
    }
    public boolean isPositive(){
        if(vote >= 3)return true;
        else return false;
    }

}
