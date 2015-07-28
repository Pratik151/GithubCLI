import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Modules {
    public static JSONArray JArr(String link) {
        JSONArray jarr = null;
        try {

            StringBuilder sb = new StringBuilder();
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(in);
            if (br != null) {
                int cp;
                while ((cp = br.read()) != -1) {
                    sb.append((char) cp);
                }
                br.close();
            }
            jarr = new JSONArray(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jarr;
    }

    public static JSONObject JObj(String link) {
        JSONObject jobj = null;
        try {

            StringBuilder sb = new StringBuilder();
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(in);
            if (br != null) {
                int cp;
                while ((cp = br.read()) != -1) {
                    sb.append((char) cp);
                }
                br.close();

            }
            jobj = new JSONObject(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobj;
    }

    public static ArrayList Repos(JSONArray jarr) throws JSONException {
        ArrayList<String> ReposArray = new ArrayList<>();
        for (int i = 0; i < jarr.length(); i++) {
            ReposArray.add(jarr.getJSONObject(i).getString("name"));
        }
        return ReposArray;
    }

}
