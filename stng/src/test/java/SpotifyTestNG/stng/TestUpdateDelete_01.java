package SpotifyTestNG.stng;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestUpdateDelete_01 {
	
	private static String path = "http://musicprojectdeployment.us-east-2.elasticbeanstalk.com/music/vinyl/";
	private String vinylID;
	
	private ObjectMapper om = new ObjectMapper();
	
	@SuppressWarnings("unchecked")
	@Test(priority = 0)
	public void addVinyl_WithAuth() throws ParseException, JsonMappingException, JsonProcessingException
	{
		RestAssured.baseURI = path;
		
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
    	authScheme.setUserName("client");
    	authScheme.setPassword("clientPassword");
    	RestAssured.authentication = authScheme;
    	
    	RequestSpecification httprequest = RestAssured.given();
    	
    	JSONObject reqparams = new JSONObject();
    	reqparams.put("albumTitle", "UpdateDeleteTest_01");
    	reqparams.put("artist", "UpdateDeleteTest_01");
    	reqparams.put("releaseDate", "1/1/00");
    	reqparams.put("serialCode", "TUD1");
    	reqparams.put("recordLabel", "UpdateDeleteTest_01");
    	reqparams.put("recordCondition", "New");
    	
    	httprequest.header("Content-Type", "application/JSON");
    	httprequest.body(reqparams.toJSONString());
    	
    	Response response = httprequest.request(Method.POST);
    	String res = response.getBody().asString();
    	JsonNode resj = om.readTree(res);
    	vinylID = resj.get("id").asText();
    	
    	System.out.println("\nNew Vinyl with ID: " + vinylID);
    	int statusCode = response.statusCode();
    	Assert.assertEquals(statusCode, 200);
	}
	
	@SuppressWarnings("unchecked")
	@Test(priority = 1)
	public void updateVinyl_NoAuth()
	{
		RestAssured.baseURI = path + vinylID;
		
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
    	authScheme.setUserName("NOclient");
    	authScheme.setPassword("NOclientPassword");
    	RestAssured.authentication = authScheme;
    	
    	RequestSpecification httprequest = RestAssured.given();
    	
    	JSONObject reqparams = new JSONObject();
    	reqparams.put("albumTitle", "UpdateSuccess");
    	reqparams.put("artist", "UpdateSuccess");
    	reqparams.put("releaseDate", "1/1/00");
    	reqparams.put("serialCode", "TUD1");
    	reqparams.put("recordLabel", "UpdateSuccess");
    	reqparams.put("recordCondition", "New");
    	
    	httprequest.header("Content-Type", "application/JSON");
    	httprequest.body(reqparams.toJSONString());
    	
    	Response response = httprequest.request(Method.PUT);
    	String res = response.getBody().asString();
    	System.out.println("\nUpdated Vinyl is:\n" + res);
    	int statusCode = response.statusCode();
    	Assert.assertEquals(statusCode, 401);
	}
	
	@SuppressWarnings("unchecked")
	@Test(priority = 1)
	public void updateVinyl_WithAuth()
	{
		RestAssured.baseURI = path + vinylID;
		
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
    	authScheme.setUserName("client");
    	authScheme.setPassword("clientPassword");
    	RestAssured.authentication = authScheme;
    	
    	RequestSpecification httprequest = RestAssured.given();
    	
    	JSONObject reqparams = new JSONObject();
    	reqparams.put("albumTitle", "UpdateSuccess");
    	reqparams.put("artist", "UpdateSuccess");
    	reqparams.put("releaseDate", "1/1/00");
    	reqparams.put("serialCode", "TUD1");
    	reqparams.put("recordLabel", "UpdateSuccess");
    	reqparams.put("recordCondition", "New");
    	
    	httprequest.header("Content-Type", "application/JSON");
    	httprequest.body(reqparams.toJSONString());
    	
    	Response response = httprequest.request(Method.PUT);
    	String res = response.getBody().asString();
    	System.out.println("\nUpdated Vinyl is:\n" + res);
    	int statusCode = response.statusCode();
    	Assert.assertEquals(statusCode, 200);
	}
	
	@Test(priority = 2)
	public void deleteVinyl_NoAuth()
	{
		RestAssured.baseURI = path + vinylID;
		
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
    	authScheme.setUserName("NOclient");
    	authScheme.setPassword("NOclientPassword");
    	RestAssured.authentication = authScheme;
    	
    	RequestSpecification httprequest = RestAssured.given();
    	
    	Response response = httprequest.request(Method.DELETE);
    	//String res = response.getBody().asString();
    	System.out.println("\nVinyl " + vinylID + " was successfully Deleted");
    	int statusCode = response.statusCode();
    	Assert.assertEquals(statusCode, 401);
	}
	
	@Test(priority = 3)
	public void deleteVinyl_WithAuth()
	{
		RestAssured.baseURI = path + vinylID;
		
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
    	authScheme.setUserName("client");
    	authScheme.setPassword("clientPassword");
    	RestAssured.authentication = authScheme;
    	
    	RequestSpecification httprequest = RestAssured.given();
    	
    	Response response = httprequest.request(Method.DELETE);
    	//String res = response.getBody().asString();
    	System.out.println("\nVinyl " + vinylID + " was successfully Deleted");
    	int statusCode = response.statusCode();
    	Assert.assertEquals(statusCode, 200);
	}
	
	@Test(priority = 4)
	public void deleteVinyl_NotExist()
	{
		RestAssured.baseURI = path + vinylID;
		
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
    	authScheme.setUserName("client");
    	authScheme.setPassword("clientPassword");
    	RestAssured.authentication = authScheme;
    	
    	RequestSpecification httprequest = RestAssured.given();
    	
    	Response response = httprequest.request(Method.DELETE);
    	//String res = response.getBody().asString();
    	System.out.println("\nVinyl " + vinylID + " was successfully Deleted");
    	int statusCode = response.statusCode();
    	Assert.assertEquals(statusCode, 500);
	}

}
