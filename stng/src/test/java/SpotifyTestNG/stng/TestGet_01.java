package SpotifyTestNG.stng;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestGet_01 
{
	private static String path = "http://musicprojectdeployment.us-east-2.elasticbeanstalk.com/music/vinyl/";
    
    @Test
    public void getVinyls_WithAuth()
    {
    	RestAssured.baseURI = path;
    	
    	PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
    	authScheme.setUserName("client");
    	authScheme.setPassword("clientPassword");
    	RestAssured.authentication = authScheme;
    	
    	RequestSpecification httprequest = RestAssured.given();
    	
    	Response response = httprequest.request(Method.GET);
    	String result = response.getBody().asString();
    	System.out.println("Response is \n" + result);
    	int statusCode = response.statusCode();
    	Assert.assertEquals(statusCode, 200);
    }
    
    @Test
    public void getVinylByID_WithAuth()
    {
    	getVinylByID_WithAuth(1);
    }
    
    public int getVinylByID_WithAuth(int id)
    {
    	RestAssured.baseURI = path + id;
    	
    	PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
    	authScheme.setUserName("client");
    	authScheme.setPassword("clientPassword");
    	RestAssured.authentication = authScheme;
    	
    	RequestSpecification httprequest = RestAssured.given();
    	
    	Response response = httprequest.request(Method.GET);
    	//String result = response.getBody().asString();
    	//System.out.println("Response is \n" + result);
    	int statusCode = response.statusCode();
    	Assert.assertEquals(statusCode, 200);
    	
    	return statusCode;
    }

    @Test
    public void getVinyls_NoAuth()
    {
    	RestAssured.baseURI = path;
    	
    	PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
    	authScheme.setUserName("NOclient");
    	authScheme.setPassword("NOclientPassword");
    	RestAssured.authentication = authScheme;
    	
    	RequestSpecification httprequest = RestAssured.given();
    	
    	Response response = httprequest.request(Method.GET);
    	//String result = response.getBody().asString();
    	//System.out.println("Response is \n" + result);
    	int statusCode = response.statusCode();
    	Assert.assertEquals(statusCode, 401);
    }
    
    @Test
    public void getVinylByID_NoAuth()
    {
    	RestAssured.baseURI = path + "1";
    	
    	PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
    	authScheme.setUserName("NOclient");
    	authScheme.setPassword("NOclientPassword");
    	RestAssured.authentication = authScheme;
    	
    	RequestSpecification httprequest = RestAssured.given();
    	
    	Response response = httprequest.request(Method.GET);
    	//String result = response.getBody().asString();
    	//System.out.println("Response is \n" + result);
    	int statusCode = response.statusCode();
    	Assert.assertEquals(statusCode, 401);
    }
}
