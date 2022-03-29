/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramApi;

import java.util.ArrayList;

/**
 *
 * @author Mattia
 */
public class Messaggi {

    ArrayList<Messaggio> m;

    public Messaggi() {
        m = new ArrayList<Messaggio>();
    }

    public ArrayList<Messaggio> getM() {
        return m;
    }

    public void setM(ArrayList<Messaggio> m) {
        this.m = m;
    }

}
