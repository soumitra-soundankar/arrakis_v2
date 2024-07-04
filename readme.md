# Welcome to the TDI Graduate Training Coding Project

For the project brief, including requirements and ways of working see [here](./project-brief.md)

## How to get started:

TODO - update this for the internally hosted repository (on BitBucket or GitHub)
1. Fork this repository into your own personal space on GitHub.
2. You might want to setup branch protection if you are working in a team so direct commits to main are restricted and then branches and pull requests/reviews are required for all team members:
* In your repository navigation to Settings > Branches
* Under “Protected Branches” select 'main'
* Enable the following settings:
  * Protect this branch
  * Require pull request reviews before merging
  * Dismiss stale pull request approvals when new commits are pushed
  * Include administrators

## Working with the project:

1. Java 11 should be installed on your machine, verify

```cmd
java --version
```

2. Build the project

```cmd
mvnw.cmd clean install (Windows)
./mvnw clean install (Mac/Codespaces/Linux)
```

##  Run the project for local testing
For local testing before pushing the code use the following

```cmd
mvnw.cmd spring-boot:run -pl java-api (Windows)
./mvnw spring-boot:run -pl java-api (Mac/Codespaces/Linux)
```
Frontend URL - http://localhost:8080/index.html 

Further Reference
* [frontend](./java-api/readme.md)
* [backend](./react-app/readme.md)