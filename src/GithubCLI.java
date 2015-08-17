import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Base64;


public class GithubCLI {

    private String Github_Api = "https://api.github.com/";

    public static void main(String[] a) throws JSONException
    {
        GithubCLI cli = new GithubCLI();
        cli.Files("Pratik151/GithubCLI");
        cli.Repos("Pratik151");
        cli.Readme("Pratik151/YoutubetoGifBot");
        cli.Followers("harshasrinivas");
        cli.Contributors("harshasrinivas/cli-github");
    }
    public void Repos(String name)throws JSONException
    {
        JSONArray jarr = Modules.JArr(Github_Api + "users/" + name + "/repos");
        ArrayList<String> ReposArray = new ArrayList<>();
        for (int i = 0; i < jarr.length(); i++) {
            ReposArray.add(jarr.getJSONObject(i).getString("name"));
        }
        
        for (String anAl : ReposArray) {
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

    public void Readme(String name)throws JSONException
    {
        JSONObject jobj = Modules.JObj(Github_Api+"repos/"+name+"/readme");
        String read = jobj.getString("content");
        byte[] valueDecoded= Base64.getMimeDecoder().decode(read);
        System.out.println(new String(valueDecoded));
    }

    public void Followers(String name)throws JSONException
    {
        JSONArray jarr = Modules.JArr(Github_Api+"users/"+name+"/followers");
        System.out.println("Number of followers: "+jarr.length());
        for(int i=0;i<jarr.length();i++)
        {
            System.out.println(jarr.getJSONObject(i).getString("login"));
        }
    }

    public void Contributors(String name) throws JSONException
    {
        String url= Github_Api + "repos/" + name + "/contributors";
        JSONArray jarr = Modules.JArr(url);
        System.out.println("****Contributors*****");
        for(int i=0;i<jarr.length();i++)
        {
            System.out.println(jarr.getJSONObject(i).getString("login"));
        }
    }

}

