# Update Matcha theme into k8s deployment
According to the guideline of theme deployment from Keycloak https://www.keycloak.org/docs/latest/server_development/#deploying-themes

Bellow is steps to create a jar file the theme folder and update to k8s deployment folder

- Go to `matcha` folder
```shell
cd matcha
```
- Run the jar command line to create a jar file
```shell
jar cvf matcha.jar *
```
- Copy `matcha.jar` file to `k8s/deploy/keycloak/themes` folder