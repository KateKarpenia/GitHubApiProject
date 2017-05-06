package epam.com

import com.jayway.restassured.RestAssured
import com.jayway.restassured.RestAssured.given
import epam.com.utils.*
import org.hamcrest.CoreMatchers.containsString
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

/**
 * Created by Katerina_Karpenia on 5/5/2017.
 */

class GitHubApiTests : RestAssuredSupport() {

    @BeforeClass
    fun setup(){
        RestAssured.baseURI = gitHubApiPath
    }

    @Test
    fun loginToGitHubTest() {
        given()
                .header(headerKey, personalAccessToken)
                .When().get(loginToGitHubPath)
                .then().log().all().body(containsString(accountName)).body(containsString(personalInfo)).statusCode(success)
    }

    @Test
    fun createDefaultRepositoryTest() {
        given()
                .header(headerKey, personalAccessToken)
                .body(newRepoParams)
                .When().post(createRepositoryPath)
                .then().log().all().body(containsString(newRepoName)).statusCode(successfullyCreated);

    }

    @Test(dependsOnMethods = arrayOf("createDefaultRepositoryTest"))
    fun deleteRepositoryTest() {
        given()
                .header(headerKey, personalAccessToken)
                .When().delete(deleteRepositoryPath)
                .then().log().all().statusCode(successfullyDeleted)
    }

    @Test
    fun modifyRepositorySettingsTest() {
        given()
                .header(headerKey, personalAccessToken)
                .body(bodyForRepositoryModification)
                .When().patch(modifyRepositorySettingsPath)
                .then().log().all().statusCode(success)

    }

    @Test
    fun cannotCreatePrivateRepositoryTest() {
        given()
                .header(headerKey, personalAccessToken)
                .body(bodyForPrivateRepositoryCreation)
                .When().post(createRepositoryPath)
                .then().log().all().body(containsString(upgradeAccountMessage)).statusCode(unprocessableEntity)
    }

    @Test
    fun commitToRepositoryTest() {
        given()
                .header(headerKey, personalAccessToken)
                .body(bodyForCommitToRepository)
                .When().put(commitToRepositoryPath)
                .then().log().all().body(containsString(messageForCommit)).statusCode(success)
    }

}


