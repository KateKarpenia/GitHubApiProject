package epam.com.entity

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonUnwrapped

/**
 * Created by Kate on 17.05.17.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class Commit (
        val message: String, @JsonUnwrapped var committer: Committer, val content: String, val sha: String)

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class Committer (val name: String, val email: String)