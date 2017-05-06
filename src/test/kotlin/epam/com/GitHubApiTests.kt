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
        RestAssured.baseURI = gitHubApiUri
    }

    @Test
    fun loginToGitHubTest() {
        given()
                .header(headerKey, personalAccessToken)
                .When().get("/users/${accountName}")
                .then().log().all().body(containsString(accountName)).body(containsString(personalInfo)).statusCode(200)
    }

    @Test
    fun createDefaultRepositoryTest() {
        given()
                .header(headerKey, personalAccessToken)
                .body(newRepoParams)
                .When().post("/user/repos")
                .then().log().all().body(containsString(newRepoName)).statusCode(201);

    }

    @Test(dependsOnMethods = arrayOf("createDefaultRepositoryTest"))
    fun deleteRepositoryTest() {
        given()
                .header(headerKey, personalAccessToken)
                .When().delete("/repos/${accountName}/${newRepoName}")
                .then().log().all().statusCode(204)
    }

    @Test
    fun modifyRepositorySettingsTest() {
        given()
                .header(headerKey, personalAccessToken)
                .body(bodyForRepositoryModification)
                .When().patch("/repos/${accountName}/${defaultRepositoryName}")
                .then().log().all().statusCode(200)

    }

    @Test
    fun cannotCreatePrivateRepositoryTest() {
        given()
                .header(headerKey, personalAccessToken)
                .body(bodyForPrivateRepositoryCreation)
                .When().post("/user/repos")
                .then().log().all().body(containsString(upgradeAccountMessage)).statusCode(422)
    }

}


