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

## Run in Codespace ** [Optional] **

* Click on codespace
  
  ![image](https://github.com/stream2stream/arrakis_v2/assets/36617041/e32907bd-2a47-4b2b-8e06-567f4489fdc9)
  
* It will open new window with Visual studio in it

* In Editor in terminal first run
  
  ```cmd
  mvnw clean install
  ```
  ![image](https://github.com/stream2stream/arrakis_v2/assets/36617041/3796d45d-f303-4b2b-ad4c-9a1fc88dcf68)
  
* Once that is finished run below command
  
  ```cmd
  ./mvnw spring-boot:run -pl java-api
  ```
  ![image](https://github.com/stream2stream/arrakis_v2/assets/36617041/397e674a-3e3b-4868-b1bc-5ee84b40cc6a)

* Once finished on right bottom corner it asks for "Open in Browser" and "Make Public". Click on "Make Public"
  
  ![image](https://github.com/stream2stream/arrakis_v2/assets/36617041/b8fe7b3f-8ef9-47f0-af57-e3c03c0f4b88)
  
  
* Go to Ports, you will find an URL where application can be accessed
  ![image](https://github.com/stream2stream/arrakis_v2/assets/36617041/e9de9bdb-ae4d-4a89-a7cc-aeb80a4b486a)


## Run on a server ** [Optional] **
* This is completely Optional for coding challenge, make sure you will not enter any payment method to fly.io
* Register for an account on fly.io
  * Go to www.fly.io

    ![image](https://github.com/stream2stream/arrakis_v2/assets/36617041/eef6391e-8df1-4b11-ab2d-edb95d3cd723)
    
  * Click on signup
    
    ![image](https://github.com/stream2stream/arrakis_v2/assets/36617041/ba8368e4-b536-4551-9c9e-0b77617caf19)
    
  * Enter any personal account email id and password
    
    ![image](https://github.com/stream2stream/arrakis_v2/assets/36617041/7cc5ba20-ba23-4832-a63d-434eac1d8b5c)
    
  * Click on top left corner, it will take you to dashboard. Confirm you are using Trial Plan and there is no payment method added
    
    ![image](https://github.com/stream2stream/arrakis_v2/assets/36617041/88fcca42-68bc-4a6c-aa53-5fff1c5bf5ab)
    
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
