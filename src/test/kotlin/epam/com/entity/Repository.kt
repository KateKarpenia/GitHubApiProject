package epam.com.entity

import com.fasterxml.jackson.annotation.JsonInclude

/**
 * Created by Kate on 16.05.17.
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class Repository(
        val name: String, val description: String, val homepage: String, val private: Boolean)

