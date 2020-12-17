package SpotifyTestNG.stng;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestPost_01 {
	
	private static String path = "http://musicprojectdeployment.us-east-2.elasticbeanstalk.com/music/vinyl/";
	
	@SuppressWarnings("unchecked")
	@Test
	public void addVinyl_WithAuth()
	{
		RestAssured.baseURI = path;
		
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
    	authScheme.setUserName("client");
    	authScheme.setPassword("clientPassword");
    	RestAssured.authentication = authScheme;
    	
    	RequestSpecification httprequest = RestAssured.given();
    	
    	JSONObject reqparams = new JSONObject();
    	reqparams.put("albumTitle", "PostTest_01");
    	reqparams.put("artist", "PostTest_01");
    	reqparams.put("releaseDate", "1/1/00");
    	reqparams.put("serialCode", "TPM1");
    	reqparams.put("recordLabel", "PostTest_01");
    	reqparams.put("recordCondition", "New");
    	
    	httprequest.header("Content-Type", "application/JSON");
    	httprequest.body(reqparams.toJSONString());
    	
    	Response response = httprequest.request(Method.POST);
    	String res = response.getBody().asString();
    	System.out.println("Response is " + res);
    	int statusCode = response.statusCode();
    	Assert.assertEquals(statusCode, 200);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addVinyl_NoAuth()
	{
		RestAssured.baseURI = path;
		
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
    	authScheme.setUserName("NOclient");
    	authScheme.setPassword("NOclientPassword");
    	RestAssured.authentication = authScheme;
    	
    	RequestSpecification httprequest = RestAssured.given();
    	
    	JSONObject reqparams = new JSONObject();
    	reqparams.put("albumTitle", "PostTest_01");
    	reqparams.put("artist", "PostTest_01");
    	reqparams.put("releaseDate", "1/1/00");
    	reqparams.put("serialCode", "TPM1");
    	reqparams.put("recordLabel", "PostTest_01");
    	reqparams.put("recordCondition", "New");
    	
    	httprequest.header("Content-Type", "application/JSON");
    	httprequest.body(reqparams.toJSONString());
    	
    	Response response = httprequest.request(Method.POST);
    	String res = response.getBody().asString();
    	System.out.println("Response is " + res);
    	int statusCode = response.statusCode();
    	Assert.assertEquals(statusCode, 401);
	}

}
