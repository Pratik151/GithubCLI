
import java.io.BufferedReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;

public class GithubCLI {

    private String Github_Api = "https://api.github.com/";

    public static void main(String[] a) throws JSONException
    {
        GithubCLI cli = new GithubCLI();
        cli.Files("Pratik151/GithubCLI");
        cli.Repos("Pratik151");


    }
    public void Repos(String name)throws JSONException
    {
        JSONArray jarr = Modules.JArr(Github_Api+"users/"+name+"/repos");
        ArrayList<String> al = Modules.Repos(jarr);
        for (String anAl : al) {
            System.out.println(anAl);
        }
    }

    public void Files(String name)throws JSONException
    {
        String url=Github_Api+"repos/"+name+"/branches/master";
        JSONObject jdata = Modules.JObj(url);
        jdata = jdata.getJSONObject("commit");
       url = jdata.getJSONObject("commit").getJSONObject("tree").getString("url");
        url = url+"?recursive=1";
        jdata = Modules.JObj(url);
        JSONArray jarr = jdata.getJSONArray("tree");
        for(int i =0;i<jarr.length();i++)
        {
            System.out.println(jarr.getJSONObject(i).getString("path"));
        }

    }
}

