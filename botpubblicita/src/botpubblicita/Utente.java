/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mattia
 */
public class Utente {

    private String first_name;
    private String second_name;
    private Long id;
    private Double latitudine;
    private Double longitudine;

    public Utente() {
    }

    public Utente(String first_name, String second_name, Long id, Double latitudine, Double longitudine) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.id = id;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
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

        File file = new File("NomiCitta.csv");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner scanner = new Scanner(file);
        StringBuffer stringBuffer = new StringBuffer();
        String rigaDaModificare = null;
        while (scanner.hasNextLine()) {
            String riga = scanner.nextLine();
            if (riga.contains(String.valueOf(id))) {
                rigaDaModificare = riga;
            }
            stringBuffer.append(riga + System.lineSeparator());
        }
        String contents = stringBuffer.toString();
        scanner.close();
        if (rigaDaModificare != null) {
            contents = contents.replaceAll(rigaDaModificare, id + ";" + first_name + ";" + second_name + ";" + latitudine + ";" + longitudine);
        } else {
            contents += id + ";" + first_name + ";" + second_name + ";" + latitudine + ";" + longitudine + System.lineSeparator();
        }
        contents = contents.trim();
        FileWriter writer;
        try {
            writer = new FileWriter(file);
            writer.write(contents);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
