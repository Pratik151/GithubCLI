
import java.io.BufferedReader;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;

public class GithubCLI {

    public static void main(String[] a) throws JSONException
    {
        JSONArray jarr = Modules.JsonData("https://api.github.com/users/Pratik151/repos");
        ArrayList<String> al = Modules.Repos(jarr);
        for(int i=0;i<al.size();i++)
        {
            System.out.println(al.get(i));
        }


    }
}

