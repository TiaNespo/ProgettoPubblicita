/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.*;

/**
 *
 * @author nespoli_mattia
 */
public class test {

    From f = new From();
    Chat c = new Chat();

    public void Esegui() throws MalformedURLException, IOException {
        URL url = new URL("https://api.telegram.org/bot5247364707:AAF0kPzYKpcoO1b99ORy5B7ZafT969B0ntc/getUpdates");
        InputStream is = url.openConnection().getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line = null;
        String s = "";
        while ((line = reader.readLine()) != null) {
            s += line;
        }
        System.out.println(s);
        ConvertJSON(s);
    }

    public void InviaMessaggio() throws MalformedURLException, IOException {

        Scanner s=new Scanner(System.in);
        String testo=s.nextLine();
        URL url = new URL("https://api.telegram.org/bot5247364707:AAF0kPzYKpcoO1b99ORy5B7ZafT969B0ntc/sendMessage?chat_id="+c.getId()+"&text="+testo);
        url.openStream();

    }

    public void ConvertJSON(String s) {
        String jsonString = s; //assign your JSON String here
        JSONObject objs = new JSONObject(jsonString);
        //String v = obj.getString("nome");
        //System.out.println(v);
        JSONArray arr = objs.getJSONArray("result"); // notice that `"posts": [...]`
        for (int i = 0; i < arr.length(); i++) {
            //Risultato post_id = arr.getJSONObject(i);
            JSONObject result = arr.getJSONObject(i);

            f.setId(result.getJSONObject("message").getJSONObject("from").getLong("id"));
            f.setIs_bot(result.getJSONObject("message").getJSONObject("from").getBoolean("is_bot"));
            f.setFirst_name(result.getJSONObject("message").getJSONObject("from").getString("first_name"));
            f.setLast_name(result.getJSONObject("message").getJSONObject("from").getString("last_name"));
            f.setUsername(result.getJSONObject("message").getJSONObject("from").getString("username"));
            f.setLanguage_code(result.getJSONObject("message").getJSONObject("from").getString("language_code"));

            c.setId(result.getJSONObject("message").getJSONObject("chat").getLong("id"));
            c.setFirst_name(result.getJSONObject("message").getJSONObject("chat").getString("first_name"));
            c.setLast_name(result.getJSONObject("message").getJSONObject("chat").getString("last_name"));
            c.setUsername(result.getJSONObject("message").getJSONObject("chat").getString("username"));
            c.setType(result.getJSONObject("message").getJSONObject("chat").getString("type"));

            Messaggio m = new Messaggio(result.getLong("update_id"), f, c, result.getJSONObject("message").getLong("date"), result.getJSONObject("message").getString("text"));

            System.out.println(m.ToString());
        }
    }
}
