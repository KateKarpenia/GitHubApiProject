package epam.com

import com.jayway.restassured.RestAssured
import com.jayway.restassured.response.Response
import com.jayway.restassured.response.Validatable
import com.jayway.restassured.response.ValidatableResponse
import com.jayway.restassured.specification.RequestSpecification
import com.jayway.restassured.specification.ResponseSpecification

/**
 * Created by Katerina_Karpenia on 5/5/2017.
 */

open class RestAssuredSupport {

    fun Given(): RequestSpecification {
        return RestAssured.given()
    }

    fun RequestSpecification.When(): RequestSpecification {
        return this.`when`()
    }

    fun RequestSpecification.Then(): ResponseSpecification {
        return this.then()
    }

    fun Response.Then(): ValidatableResponse {
        return this.then()
    }

}