package epam.com

import com.fasterxml.jackson.databind.ObjectMapper
import com.jayway.restassured.builder.RequestSpecBuilder
import com.jayway.restassured.filter.log.RequestLoggingFilter
import com.jayway.restassured.filter.log.ResponseLoggingFilter
import com.jayway.restassured.specification.RequestSpecification
import epam.com.utils.*
import org.hamcrest.CoreMatchers.containsString
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import com.fasterxml.jackson.module.kotlin.*
import epam.com.entity.Commit
import epam.com.entity.Committer
import epam.com.entity.Repository

/**
 * Created by Katerina_Karpenia on 5/5/2017.
 */

class GitHubApiTests : RestAssuredSupport() {

    lateinit var requestSpecification: RequestSpecification
    var mapper: ObjectMapper = jacksonObjectMapper()

    @BeforeClass
    fun setup() {
        requestSpecification = RequestSpecBuilder()
                .setBaseUri(GITHUB_API_PATH)
                .addHeader(HEADER_KEY, PERSONAL_ACCESS_TOKEN)
                .addFilter(RequestLoggingFilter())
                .addFilter(ResponseLoggingFilter())
                .build()
    }

    @Test
    fun loginToGitHubTest() {

        Given()
                .spec(requestSpecification)
                .When().get(LOGIN_TO_GITHUB_PATH)
                .Then().body(containsString(ACCOUNT_NAME)).body(containsString(PERSONAL_INFO)).statusCode(SUCCESS)
    }

    @Test
    fun createDefaultRepositoryTest() {

        val repositoryForCreation = Repository (REPOSITORY_NAME, REPOSITORY_DESCRIPTION, HOMEPAGE, false)
        val bodyForRepositoryCreation = mapper.writeValueAsString(repositoryForCreation)

        Given()
                .spec(requestSpecification)
                .body(bodyForRepositoryCreation)
                .When().post(CREATE_REPOSITORY_PATH)
                .Then().body(containsString(REPOSITORY_NAME)).statusCode(SUCCESSFULLY_CREATED);
        Given()
                .spec(requestSpecification)
                .When().get(GET_REPOSITORY_PATH)
                .Then().body(containsString(FULL_REPOSITORY_NAME)).statusCode(SUCCESS)

        Given()
                .spec(requestSpecification)
                .When().delete(GET_REPOSITORY_PATH)
                .Then().statusCode(SUCCESSFULLY_DELETED)
    }

    @Test
    fun modifyRepositorySettingsTest() {

        val repositoryForModification = Repository (DEFAULT_REPOSITORY_NAME, REPOSITORY_DESCRIPTION, HOMEPAGE, false)
        val bodyForRepositoryModification = mapper.writeValueAsString(repositoryForModification)

        Given()
                .spec(requestSpecification)
                .body(bodyForRepositoryModification)
                .When().patch(DEFAULT_REPOSITORY_SETTINGS_PATH)
                .Then().statusCode(SUCCESS)
        Given()
                .spec(requestSpecification)
                .When().get(DEFAULT_REPOSITORY_SETTINGS_PATH)
                .Then().body(containsString(REPOSITORY_DESCRIPTION)).statusCode(SUCCESS)

    }

    @Test
    fun cannotCreatePrivateRepositoryTest() {

        val privateRepositoryForCreation = Repository (REPOSITORY_NAME, REPOSITORY_DESCRIPTION, HOMEPAGE, true)
        val bodyForPrivateRepositoryCreation = mapper.writeValueAsString(privateRepositoryForCreation)

        Given()
                .spec(requestSpecification)
                .body(bodyForPrivateRepositoryCreation)
                .When().post(CREATE_REPOSITORY_PATH)
                .Then().body(containsString(UPGRADE_ACCOUNT_MESSAGE)).statusCode(UNPROCESSABLE_ENTITY)
    }

    @Test
    fun commitToRepositoryTest() {

        val committer = Committer (COMMITTER_NAME, COMMITTER_EMAIL)
        val commitToRepository = Commit (MESSAGE_FOR_COMMIT, committer, CONTENT_FOR_COMMIT, SHA)
        val bodyForCommit = mapper.writeValueAsString(commitToRepository)

        Given()
                .spec(requestSpecification)
                .body(bodyForCommit)
                .When().put(COMMIT_TO_REPOSITORY_PATH)
                .Then().body(containsString(MESSAGE_FOR_COMMIT)).statusCode(SUCCESS)
    }

}



