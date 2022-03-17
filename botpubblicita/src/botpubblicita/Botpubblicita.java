/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import TelegramApi.*;
import java.io.IOException;
import java.util.Scanner;
import org.json.*;

/**
 *
 * @author nespoli_mattia
 */
public class Botpubblicita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ThreadAscolta t=new ThreadAscolta();
        
        t.start();
        
        
        //t.InviaMessaggio();
    }

}
