
import java.io.BufferedReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;

public class GithubCLI {

    public static void main(String[] a) throws JSONException
    {
        Files("Pratik151/GithubCLI");


    }
    public static void Repos()throws JSONException
    {
        JSONArray jarr = Modules.JArr("https://api.github.com/users/Pratik151/repos");
        ArrayList<String> al = Modules.Repos(jarr);
        for (String anAl : al) {
            System.out.println(anAl);
        }
    }

    public static void Files(String name)throws JSONException
    {
        String url="https://api.github.com/repos/"+name+"/branches/master";
        JSONObject jdata = Modules.JObj(url);
        JSONObject sha = jdata.getJSONObject("commit");
       url = sha.getJSONObject("commit").getJSONObject("tree").getString("url");
        url = url+"?recursive=1";
        jdata = Modules.JObj(url);
        JSONArray jarr =  jdata.getJSONArray("tree");
        for(int i =0;i<jarr.length();i++)
        {
            System.out.println(jarr.getJSONObject(i).getString("path"));
        }

    }
}

