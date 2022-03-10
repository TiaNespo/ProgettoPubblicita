/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramApi;

/**
 *
 * @author Mattia
 */
public class From {

    private long id;
    private boolean is_bot;
    private String first_name;
    private String last_name;
    private String username;
    private String language_code;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isIs_bot() {
        return is_bot;
    }

    public void setIs_bot(boolean is_bot) {
        this.is_bot = is_bot;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }
    
    public String ToString(){
        String s=id+" "+is_bot+" "+first_name+" "+last_name+" "+username+" "+language_code+" ";
        return s;
    }
}
