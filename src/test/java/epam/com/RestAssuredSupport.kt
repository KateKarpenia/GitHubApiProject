package epam.com

import com.jayway.restassured.specification.RequestSpecification

/**
 * Created by Katerina_Karpenia on 5/5/2017.
 */

open class RestAssuredSupport {
    fun RequestSpecification.When(): RequestSpecification {
        return this.`when`()
    }
}