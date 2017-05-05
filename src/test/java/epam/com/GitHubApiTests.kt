package epam.com

import com.jayway.restassured.RestAssured
import com.jayway.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.containsString
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

/**
 * Created by Katerina_Karpenia on 5/5/2017.
 */

class GitHubApiTests : RestAssuredSupport() {

    @BeforeClass
    fun setup(){
        RestAssured.baseURI = "https://api.github.com"
    }

    @Test
    fun loginToGitHubTest() {
        given()
                .header(headerKey, personalAccessToken)
                .When().get("/users/${accountName}")
                .then().body(containsString(accountName)).statusCode(200)
    }

    @Test
    fun createDefaultRepositoryTest() {
        given()
                .header(headerKey, personalAccessToken)
                .body(newRepoParams)
                .When().post("/user/repos")
                .then().body(containsString(newRepoName)).statusCode(201);
        
    }

    @Test
    fun deleteRepositoryTest() {
        given()
                .header(headerKey, personalAccessToken)
                .When().delete("/repos/${accountName}/${newRepoName}")
                .then().statusCode(204);
    }

}


