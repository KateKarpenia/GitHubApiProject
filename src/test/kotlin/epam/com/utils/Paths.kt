package epam.com.utils

/**
 * Created by Katerina_Karpenia on 5/6/2017.
 */

    const val GITHUB_API_PATH: String = "https://api.github.com"
    const val CREATE_REPOSITORY_PATH: String = "/user/repos"
    val LOGIN_TO_GITHUB_PATH: String = "/users/${ACCOUNT_NAME}"
    val GET_REPOSITORY_PATH: String = "/repos/${ACCOUNT_NAME}/${REPOSITORY_NAME}"
    val DEFAULT_REPOSITORY_SETTINGS_PATH: String = "/repos/${ACCOUNT_NAME}/${DEFAULT_REPOSITORY_NAME}"
    val COMMIT_TO_REPOSITORY_PATH: String = "/repos/${ACCOUNT_NAME}/${DEFAULT_REPOSITORY_NAME}/contents/${PATH_FOR_COMMIT}"