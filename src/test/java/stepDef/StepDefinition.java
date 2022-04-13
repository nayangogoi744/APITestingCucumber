package stepDef;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinition {

	RequestSpecification request;
	Response response;

	@Given("^User sets the base API request \"([^\"]*)\"$")
	public void user_sets_the_base_api_request(String url) {

		RestAssured.baseURI = url;
	}

	@Given("^User authenticate the API using \"([^\"]*)\"$")
	public void user_authenticate_the_api_using_token(String token) {
		request = given().auth().oauth2(token);
	}

	@When("^User sends the request to get all the repositories$")
	public void user_sends_the_request_to_get_all_the_repositories() {
		String path = "/user/repos";
		response = request.get(path).then().extract().response();
		System.out.println(response.print());
	}

	@Then("^User validates the response status is (-?\\d+)$")
	public void user_validates_the_response_status_is(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}
}
