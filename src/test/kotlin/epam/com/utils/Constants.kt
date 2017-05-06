package epam.com.utils

/**
 * Created by Katerina_Karpenia on 5/5/2017.
 */

    val headerKey = "Authorization"
    val personalAccessToken = "Basic R2l0SHViVGVzdGluZ1Byb2plY3Q6OTQxYWM5YjE5MjAwYzM1ZWUwMTAyNDM4ODJkNWM2MTI1YzgzODQ4NQ=="
    val accountName = "GitHubTestingProject"
    val personalInfo = "private_repos"
    val defaultRepositoryName = "SampleRepository"
    val repositoryName = "GitHubRepoNew"
    val fullRepositoryName = "${accountName}/${repositoryName}"
    val newRepositoryParams = """
    {
        "name": "${repositoryName}"
        }"""

    val repositoryDescription = "This repository was modified again"
    val bodyForRepositoryModification = """
    {
        "name": "${defaultRepositoryName}",
        "description": "${repositoryDescription}",
        "homepage": "https://github.com"
        }"""

    val bodyForPrivateRepositoryCreation = """
    {
        "name": "${repositoryName}",
        "private": true
        }"""

    val upgradeAccountMessage = "Please upgrade your plan to create a new private repository"

    val pathForCommit = "README.md"
    val messageForCommit = "add new commit"
    val bodyForCommitToRepository = """
    {
        "message": "${messageForCommit}",
        "committer": {
            "name": "Kate Karpenia",
            "email": "kate.karpenia@gmail.com"
        },
        "content": "bXkgdXBkYXRlZCBmaWxlIGNvbnRlbnRz",
        "sha": "fb617c9e42866ca24d0ff8e0c2725048f6f9530c"
        }"""

