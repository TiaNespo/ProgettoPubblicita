/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import TelegramApi.Messaggio;
import TelegramApi.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author Mattia
 */
public class ThreadAscolta extends Thread {

    test t = new test();
    Messaggio m = new Messaggio();
    Messaggio vecchio;
    Utente u = new Utente();
    int contatore = 0;

    @Override
    public void run() {
        try {
            vecchio = t.Leggi();
        } catch (IOException ex) {
            Logger.getLogger(ThreadAscolta.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            try {
                Thread.sleep(500);
                try {
                    m = t.Leggi();
                    if (m.getMessage_id() != (vecchio.getMessage_id())) {
                        ControllaCitta();
                        vecchio = m;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ThreadAscolta.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadAscolta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void ControllaCitta() {

        try {
            if (m.getText().substring(0, 7).equals("/citta ")) {
                String c = m.getText().substring(7);
                PrimaCittaElenco(c);
            } 
        } catch (Exception ex) {
            Logger.getLogger(ThreadAscolta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void PrimaCittaElenco(String s) throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
        Element e = getElement("https://nominatim.openstreetmap.org/search?q=" + s + "&format=xml&addressdetails=1");
        Node place = e.getElementsByTagName("place").item(0);

        sendLocation(Double.parseDouble(place.getAttributes().getNamedItem("lat").getNodeValue()), Double.parseDouble(place.getAttributes().getNamedItem("lon").getNodeValue()),
        place.getAttributes().getNamedItem("display_name").getNodeValue());

        u.setFirst_name(m.getC().getFirst_name());
        u.setSecond_name(m.getC().getLast_name());
        u.setId(m.getC().getId());
        u.setCittà(place.getAttributes().getNamedItem("display_name").getNodeValue());
        u.setLatitudine(Double.parseDouble(place.getAttributes().getNamedItem("lat").getNodeValue()));
        u.setLongitudine(Double.parseDouble(place.getAttributes().getNamedItem("lon").getNodeValue()));
        
        u.SalvaCSV();
         
    }

    public static Element getElement(String url) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        var document = builder.parse(url);
        return document.getDocumentElement();
    }

    public void sendLocation(Double lat, Double longi, String s) throws MalformedURLException, IOException {
        URL url = new URL("https://api.telegram.org/bot5247364707:AAF0kPzYKpcoO1b99ORy5B7ZafT969B0ntc/sendLocation?chat_id=" + m.getC().getId() + "&latitude=" + lat + "&longitude=" + longi);
        url.openStream();        
       t.InviaMessaggio(s,m.getC());

    }
}
