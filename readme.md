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
6. Access the application:
- Forward a localhost port to a port on the Pod. Note: kubectl port-forward does not return. 
   Do not close the terminal:
   ```
   kubectl port-forward deployment/spring-k8s-configuration 8080:8080
   
   ```
- For long term solution, you need to expose app: add service to the `spring-k8s-configuration.yaml` file.
   Service forwards requests to a set of Pods. ClusterIP type makes Pods accessible only to other Pods,
   LoadBalancer for users outside the cluster.
   ```
   kubectl delete deployment/spring-k8s-configuration
   kubectl apply -f k8s/spring-k8s-configuration.yaml
   ```
   for accessing the application via browser/terminal, command runs as a process,
   creating a network route on the host to the service CIDR of the cluster using the cluster’s IP address
   as a gateway:
   ```
   minikube service spring-k8s-configuration
   ```
   *OR*
   ```
   minikube tunnel
   kubectl get svc
   curl http://REPLACE_WITH_EXTERNAL_IP:8080/objects
   ```
---