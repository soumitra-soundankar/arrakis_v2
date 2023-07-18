# Welcome to the TDI Graduate Training Coding Project

## How to get started:

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

You can work with this project locally or in Github Codespaces.  With Codespaces you get 120 hours free per month, so keep within your quota.

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

Note:
From Codespaces, you can allow public access to the running application, see [here](https://docs.github.com/en/codespaces/developing-in-codespaces/forwarding-ports-in-your-codespace) for details. This will allow others outside of your codespace to navigate to the url - this can be useful for team testing or demos.  Alternatively you can push the code to a server as in the next section.
 
## Run on a server
* Register for an account on fly.io
* Install [flyctl](https://fly.io/docs/hands-on/install-flyctl/) 
* Authorise flyctl to access your fly account
```cmd
flyctl auth login
```
* Generate a new app, enter a unique name or generate one 
```cmd
flyctl apps create 
```
* Enter the app name into fly.toml
* Manually trigger the Java Deploy to fly.io workflow (or edit the action to trigger on push to main branch)
* App should be available on {appname}.fly.dev

Note:  you might need to scale the app resources
```cmd
fly scale memory 2048 -a {appname} (To scale memory)
```
or
```cmd
fly scale vm shared-cpu-2x {appname} (To scale CPU)
```
See [fly documentation](https://fly.io/docs/apps/scale-machine) for more guidance
