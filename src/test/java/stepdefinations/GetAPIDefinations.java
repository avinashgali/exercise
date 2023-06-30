package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.GetResponseDTO;
import util.ApiCalling;
import util.RequestTypes;

import org.junit.Assert;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetAPIDefinations {
	
	private RequestSpecification request;
	private Response response;
	private ApiCalling apirequest;
	
	
	@Given("User can access the {string} api")
	public void user_can_access_the_api(String uri) {
		apirequest = new ApiCalling();
		request= null;
		response = apirequest.sendRequest(this.request, RequestTypes.GET, uri);
		Assert.assertEquals(response.getStatusCode(),200);	
	}
	
	@Then("User should get reponse code as {int}")
	public void user_should_get_reponse_code_as(int Statuscode) throws JacksonException, JsonProcessingException {
		Assert.assertEquals(response.getStatusCode(),Statuscode);
		
	}
	@Then("Response message contain user data with id {int}")
	public void response_message_should_be(int id) {
		ObjectMapper mapper = new ObjectMapper();
		GetResponseDTO userDataResponse = response.getBody().as(GetResponseDTO.class);
//		Assert.assertEquals(userDataResponse.data.id,id);
	}
	@Then("Retrieved response should have only {int} user")
	public void retrieved_response_should_countries(int cnt) {
		ObjectMapper mapper = new ObjectMapper();
		GetResponseDTO userDataResponse = response.getBody().as(GetResponseDTO.class);
//		Assert.assertEquals(userDataResponse.data.size(),cnt);
	}



}
