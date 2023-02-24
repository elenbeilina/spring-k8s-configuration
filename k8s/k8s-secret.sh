kubectl create secret generic objects-config \
  --from-literal=spring-k8s-configuration.object-name=car \
  --from-literal=spring-k8s-configuration.colors=white,red,blue