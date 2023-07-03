package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.response.GetResponseDTO;
import util.ApiCalling;
import util.Constants;
import util.RequestTypes;
import util.ResponseHandler;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;


public class GetAPIDefinations {
	
	private RequestSpecification request;
	private Response response;
	private ApiCalling apirequest;
	GetResponseDTO userDataResponse;
	private String base_url = Constants.BaseURL;
	
	
	@Given("User can access the {string} api")
	public void user_can_access_the_api(String uri) {
		apirequest = new ApiCalling();
		RestAssured.baseURI = base_url;
		request= RestAssured.given().queryParam("page","2");
		response = apirequest.sendRequest(this.request, RequestTypes.GET, uri);
		Assert.assertEquals(response.getStatusCode(),200);	
	}
	
	@Then("User should get reponse code as {int}")
	public void user_should_get_reponse_code_as(int Statuscode) {
		Assert.assertEquals(response.getStatusCode(),Statuscode);	
		this.userDataResponse = ResponseHandler.deserializedResponse(response, GetResponseDTO.class);
	}
	@Then("Response user data should have user with Id {int}")
	public void response_user_data_should_have_user_with_Id (int id) {
		Assert.assertTrue(id+" not present in response",userDataResponse.getData().stream().anyMatch(userData -> 
			userData.getId()==id));

	}
	@Then("Retrieved response should have only {int} user")
	public void retrieved_response_should_countries(int cnt) {
		Assert.assertEquals(userDataResponse.getData().size(),cnt);
	}



}
