/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mattia
 */
public class Utenti {

    ArrayList<Utente> lista;

    public Utenti() {
        lista = new ArrayList<>();
        try {
            List<String> linee = Files.readAllLines(Paths.get("NomiCitta.csv"));
            for (int i = 0; i < linee.size(); i++) {
                String[] utente = linee.get(i).split(";");
                lista.add(new Utente(utente[1],utente[2],Long.valueOf(utente[0]),Double.valueOf(utente[3]),Double.valueOf(utente[4])));
            }

        } catch (IOException ex) {
            Logger.getLogger(Utenti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
