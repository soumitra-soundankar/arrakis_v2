How to get started:

1. Java 11 should be installed on your machine, verify

```cmd
java --version
```

2. Build the project

```cmd
mvnw.cmd clean install (Windows)
./mvnw clean install (Mac/Codespaces/Linux)
```

3. Issue following command to have it up locally or in CodeSpaces
```cmd
mvnw.cmd spring-boot:run -pl java-api (Windows)
./mvnw spring-boot:run -pl java-api (Mac/Codespaces/Linux)
```
Frontend URL - http://localhost:8080/index.html 

Further Reference
* [frontend](./java-api/readme.md)
* [backend](./react-app/readme.md) 
 
3. Deploy to Fly
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