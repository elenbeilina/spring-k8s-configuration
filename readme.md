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
6. Access the application, there is no LoadBalancer integrated in minikube, so:
   - Forward a localhost port to a port on the Pod. Note: kubectl port-forward does not return. 
      Do not close the terminal:
      ```
      kubectl port-forward deployment/spring-k8s-configuration 8080:8080
      ```
   - For long term solution, you need to expose app.
      Service forwards requests to a set of Pods. ClusterIP type makes Pods accessible only to other Pods,
      LoadBalancer for users outside the cluster.
      ```
      minikube tunnel
      kubectl expose deployment spring-k8s-configuration --type=LoadBalancer --port=8080
      ```
   - For accessing the application via browser/terminal, command runs as a process,
   creating a network route on the host to the service CIDR of the cluster using the cluster’s IP address
   as a gateway:
     ```
     minikube tunnel
     minikube service spring-k8s-configuration
     ```
     *OR*
     ```
     minikube tunnel
     kubectl get svc
     curl http://REPLACE_WITH_EXTERNAL_IP:8080/api/objects
     ```

   - Ingress exposes HTTP(S) routes, from outside the cluster to services within the cluster.
   Ingress controller fulfills the ingress rules. To enable Ingress controller:
      ```
       minikube addons enable ingress
       kubectl delete deployment/spring-k8s-configuration
       kubectl apply -f k8s/spring-k8s-configuration.yaml
       minikube tunnel
      ```
     
    Add the following line to the bottom of the /etc/hosts:
      ```
      127.0.0.1            spring-k8s-configuration.info
      ```
    >*Important! Implementation not working without tunnel.(minikube addons enable ingress-dns)* \
    >This solution is not working since Big Sur (MacOS): https://minikube.sigs.k8s.io/docs/handbook/addons/ingress-dns/ \
    >Issue: https://github.com/kubernetes/minikube/issues/12876
---