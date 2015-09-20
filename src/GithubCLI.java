import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Base64;
import com.beust.jcommander.*;


public class GithubCLI {

    private String Github_Api = "https://api.github.com/";

    public static void main(String[] args) throws JSONException
    {
        GithubCLI gcli = new GithubCLI();
        JcomParser jcexp = new JcomParser();
        new JCommander(jcexp, args);

        if(jcexp.getRepos()!=null)
        {
            gcli.Repos(jcexp.getRepos());
        }

        else if(jcexp.getFiles()!=null)
        {
            gcli.Files(jcexp.getFiles());
        }

        else if(jcexp.getReadme()!=null)
        {
            gcli.Readme(jcexp.getReadme());
        }

        else if(jcexp.getFollowers()!=null)
        {
            gcli.Followers(jcexp.getFollowers());
        }

        else if(jcexp.getContributors()!=null)
        {
            gcli.Contributors(jcexp.getContributors());
        }

        else if(jcexp.getOrgs()!=null)
        {
            gcli.Orgs(jcexp.getOrgs());
        }
        
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

    public void Orgs(String name)throws JSONException
    {
        String url = Github_Api + "users/"+name+"/orgs";
        JSONArray jarr = Modules.JArr(url);
        for(int i=0;i<jarr.length();i++)
        {
            System.out.println(jarr.getJSONObject(i).getString("login"));
        }
    }
/* 
 * Downloading Repo
 
    public void dlZip(String name)throws JSONException
    {
        String url = Github_Api + "repos/" + name + "/zipball/master";
        
    }
*/


}

