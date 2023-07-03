package util;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class ApiCalling {
	
	private String base_url = Constants.BaseURL;
	public Response response;
	
	public Response sendRequest(RequestSpecification request, RequestTypes val ,String url)
	{
		response = null;
		RestAssured.baseURI=base_url;
		switch (val) {
		
		case GET:
			if (request==null) {
				response = RestAssured.get(url);
			} else {
				response = request.get(url);
			}
			break;
		case POST:
			if (request==null) {
				response = RestAssured.when().post(url);
			} else {
				response = request.post(url);
			}
			break;
		case DELETE:
			if (request==null) {
				response = RestAssured.when().delete(url);
			} else {
				response = request.delete(url);
			}
			break;
		case PUT:
			if (request==null) {
				response = RestAssured.when().put(url);
			} else {
				response = request.put(url);
			}
			break;
		default:
			System.out.print("Please provide request Type as GET/PUT/DELETE/POST");
		}
		return response;
	}

}