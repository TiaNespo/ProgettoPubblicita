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
    private long message_id;

    public Messaggio() {
    }    
    
    public Messaggio(long update_id, From f, Chat c, long date, String text, long message_id) {
        this.update_id = update_id;
        this.f = f;
        this.c = c;
        this.date = date;
        this.text = text;
        this.message_id=message_id;
    }

    public long getMessage_id() {
        return message_id;
    }

    public void setMessage_id(long message_id) {
        this.message_id = message_id;
    }
    
    public String ToString(){
        String s=update_id+"\n"+f.ToString()+"\n"+c.ToString()+"\n"+date+"\n"+text+"\n";
        return s;
    }

    public long getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(long update_id) {
        this.update_id = update_id;
    }

    public From getF() {
        return f;
    }

    public void setF(From f) {
        this.f = f;
    }

    public Chat getC() {
        return c;
    }

    public void setC(Chat c) {
        this.c = c;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
