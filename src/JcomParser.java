
import com.beust.jcommander.*;

public class JcomParser
{
	
	 
	  @Parameter(names = "-repos" , description = "Get Repos from user profile url.")
	  private String repos;

	  @Parameter(names = "-files",description ="Get Files from the Repository.")
	  private String files;

	  @Parameter(names="-readme",description = "Display the Readme file from the repository.")
	  private String readme;

	  @Parameter(names = "-followers", description = "Get followers from the user profile.")
	  private String followers;

	  @Parameter(names = "-contributors", description = "Get the Contributors.")
	  private String contributors;

	  @Parameter(names = "-orgs", description = "Get the orgs.")
	  private String orgs;

	  public String getRepos()
	  {
	  	return repos;
	  }

	  public String getFiles()
	  {
	  	return files;
	  }

	  public String getReadme()
	  {
	  	return readme;
	  }

	  public String getFollowers()
	  {
	  	return followers;
	  }

	  public String getContributors()
	  {
	  	return contributors;
	  }

	  public String getOrgs()
	  {
	  	return orgs;
	  }
}