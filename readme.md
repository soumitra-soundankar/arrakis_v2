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

3. Run locally or in CodeSpaces
```cmd
mvnw.cmd spring-boot:run -pl java-api (Windows)
./mvnw spring-boot:run -pl java-api (Mac/Codespaces/Linux)
```
Frontend URL - http://localhost:8080/index.html 

Further Reference
* [frontend](./java-api/readme.md)
* [backend](./react-app/readme.md) 
 
4. Run on a server
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
