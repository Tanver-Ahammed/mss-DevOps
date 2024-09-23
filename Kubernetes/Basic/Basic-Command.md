
# Kubernetes Command Cheat Sheet

---

## Run an nginx pod
```bash
kubectl run nginx --image=nginx
```

## Get the list of pods
```bash
kubectl get pods
```

## Get the list of pods with detailed node information
```bash
kubectl get pods -o wide
```

## Expose nginx pod as a service
```bash
kubectl expose pods nginx --name=nginx-web --port=80 --type=NodePort
```

## Get the list of services
```bash
kubectl get svc
```

## Run an apache pod in the 'test' namespace
```bash
kubectl run apache --image=httpd --namespace=test
```

## Expose apache pod as a service in the 'test' namespace
```bash
kubectl expose pods apache --name=web --port=80 --type=NodePort --n=test
```

## Generate nginx pod YAML configuration without creating the pod
```bash
kubectl run nginx --image=nginx --dry-run=client -o yaml > pod.yaml
```

## Create a deployment using the httpd image
```bash
kubectl create deploy webserver --image=httpd
```

## Get the list of deployments
```bash
kubectl get deploy
```

## Scale a replica set to 25 replicas
```bash
kubectl scale rs replicaset-1 --replicas=25
```

## Get the list of replica sets
```bash
kubectl get rs
```

## Taint node 'node01' with a 'NoSchedule' rule
```bash
kubectl taint nodes node01 color=red:NoSchedule
```

## Describe the taints on 'node01'
```bash
kubectl describe nodes node01 | grep -i taint
```

## Label the controlplane node with size=small
```bash
kubectl label nodes controlplane size=small
```
