/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mattia
 */
public class Utente {

    private String first_name;
    private String second_name;
    private String città;
    private Long id;
    private Double latitudine;
    private Double longitudine;

    public Utente() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(Double latitudine) {
        this.latitudine = latitudine;
    }

    public Double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(Double longitudine) {
        this.longitudine = longitudine;
    }

    public void SalvaCSV() throws FileNotFoundException {

        String s = first_name +";"+ second_name +";"+ id +";"+ latitudine+";"+ longitudine+"\n";

        try {
            Files.writeString(Paths.get("NomiCitta.txt"), s, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     /*public static double GetDistanceKilometers() {
        double R = 6371.0088;
        Double lat1 = location1.lat;
        Double lon1 = location1.lon;
        Double lat2 = location2.lat;
        Double lon2 = location2.lon;
        Double latDistance = Math.toRadians((lat2 - lat1));
        Double lonDistance = Math.toRadians((lon2 - lon1));
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double a = haversin(latDistance) + Math.cos(lat1) * Math.cos(lat2) * haversin(lonDistance);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
    private static double haversin(double val){
        return Math.pow(Math.sin(val / 2), 2);
    }*/
}
