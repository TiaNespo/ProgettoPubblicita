/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramApi;

/**
 *
 * @author nespoli_mattia
 */
public class Messaggio {
    private long update_id;
    private From f;
    private Chat c;
    private long date;
    private String text;

    public Messaggio(long update_id, From f, Chat c, long date, String text) {
        this.update_id = update_id;
        this.f = f;
        this.c = c;
        this.date = date;
        this.text = text;
    }
    
    public String ToString(){
        String s=update_id+"\n"+f.ToString()+"\n"+c.ToString()+"\n"+date+"\n"+text+"\n";
        return s;
    }
    
}
