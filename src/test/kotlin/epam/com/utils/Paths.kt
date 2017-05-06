package epam.com.utils

/**
 * Created by Katerina_Karpenia on 5/6/2017.
 */

    val gitHubApiPath = "https://api.github.com"
    val loginToGitHubPath = "/users/${accountName}"
    val createRepositoryPath = "/user/repos"
    val getRepositoryPath = "/repos/${accountName}/${repositoryName}"
    val defaultRepositorySettingsPath = "/repos/${accountName}/${defaultRepositoryName}"
    val commitToRepositoryPath = "/repos/${accountName}/${defaultRepositoryName}/contents/${pathForCommit}"