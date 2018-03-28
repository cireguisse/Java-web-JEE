/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

/**
 *
 * @author 21708582
 */
public class MessageDor {
    private int id;
    private String pseudo;
    private String  message;
    
    public MessageDor (){
        
    }

    public MessageDor(int id, String pseudo, String message) {
        this.id = id;
        this.pseudo = pseudo;
        this.message = message;
    }
    public MessageDor(String message , String pseudo) {
        
        this.pseudo = pseudo;
        this.message = message;
    }


    public int getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getMessage() {
        return message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
