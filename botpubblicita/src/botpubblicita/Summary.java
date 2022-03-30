/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

/**
 *
 * @author Mattia
 */
public class Summary {

    /*    
        //lettura di un file JSon
    
        URL url= new URL("");
        InputStream is = url.openConnection().getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String lineafile = null;
        String allfile = "";
        while ((lineafile = reader.readLine()) != null) {
            allfile += lineafile;
        }
    
        //parsing del file JSon
    
        JSONObject objs = new JSONObject(allfile);
        JSONArray arr = objs.getJSONArray("eventuale nome dell'array"); // notice that `"posts": [...]`
        if (!arr.isEmpty()) {
            for (int i = 0; i < arr.length(); i++) {
                JSONObject result = arr.getJSONObject(i);
                result.getJSONObject(" ").getJSONObject(" ").getString(" "));
            }
        }
    
        //scrittura file csv
    
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
    
        //lettura file csv
    
        Files.readAllLines(Paths.get("NomiCitta.csv"))
        
        //lettura file xml
        chiamata alla procedura sottostante
        Element e = getElement("https://nominatim.openstreetmap.org/search?q=" CITTA DA CERCARE "&format=xml&addressdetails=1");
    
        funzione per la lettura del file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        var document = builder.parse(url);
        return document.getDocumentElement();
        
        
        Node place = e.getElementsByTagName("place").item(0); -> ritorna un vettore di place        
        place.getAttributes().getNamedItem("lat").getNodeValue() -> per prendere un attributo del place
    
        
    
    
     */
}
