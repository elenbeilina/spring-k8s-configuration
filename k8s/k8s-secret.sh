kubectl create secret generic objects-config \
  --from-literal=object.name=surfboard \
  --from-file=colors=colors-data