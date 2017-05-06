package epam.com

/**
 * Created by Katerina_Karpenia on 5/5/2017.
 */

    val gitHubApiUri = "https://api.github.com"
    val headerKey = "Authorization"
    val personalAccessToken = "Basic R2l0SHViVGVzdGluZ1Byb2plY3Q6OTQxYWM5YjE5MjAwYzM1ZWUwMTAyNDM4ODJkNWM2MTI1YzgzODQ4NQ=="
    val accountName = "GitHubTestingProject"
    val personalInfo = "private_repos"
    val defaultRepositoryName = "SampleRepository"
    val newRepoName = "GitHubRepoNew"
    val newRepoParams = """
    {
        "name": "${newRepoName}"
        }"""

    val bodyForRepositoryModification = """
    {
        "name": "${defaultRepositoryName}",
        "description": "This repository was modified again",
        "homepage": "https://github.com"
        }"""

    val bodyForPrivateRepositoryCreation = """
    {
        "name": "${newRepoName}",
        "private": true
        }"""

    val upgradeAccountMessage = "Please upgrade your plan to create a new private repository"
