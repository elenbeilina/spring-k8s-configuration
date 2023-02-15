### Spring k8s configuration.
This simple spring-boot app with rest api, that returns values from spring properties.

#### Test scenario:

1. Build project:
    ```
    mvn clean package
    ```
2. Run local k8s cluster:
   ```
    minikube start
   ```
3. To point your shell to minikube’s docker-daemon, run:
   ```
    eval $(minikube -p minikube docker-env)
   ```
4. Build docker image with tag: spring-k8s-configuration:
   ```
   docker build -t aqua-len/spring-k8s-configuration .
   ```
5. To create a deployment run the command:
   ```
   kubectl apply -f k8s/deployment.yaml
   ```
6. Forward a local port to a port on the Pod:
   ```
   kubectl port-forward deployment/spring-k8s-configuration 8080:8080
   ```
---