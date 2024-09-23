
# Kubernetes Commands

```bash
# Run an nginx pod
kubectl run nginx --image=nginx

# Get the list of pods
kubectl get pods

# Get the list of pods with detailed node information
kubectl get pods -o wide

# Expose nginx pod as a service
kubectl expose pods nginx --name=nginx-web --port=80 --type=NodePort

# Get the list of services
kubectl get svc

# Run an apache pod in the 'test' namespace
kubectl run apache --image=httpd --namespace=test

# Expose apache pod as a service in the 'test' namespace
kubectl expose pods apache --name=web --port=80 --type=NodePort --n=test

# Generate nginx pod yaml configuration without creating the pod
kubectl run nginx --image=nginx --dry-run=client -o yaml > pod.yaml

# Create a deployment using the httpd image
kubectl create deploy webserver --image=httpd 

# Get the list of deployments
kubectl get deploy

# Scale a replica set to 25 replicas
kubectl scale rs replicaset-1 --replicas=25

# Get the list of replica sets
kubectl get rs

# Taint node 'node01' with a 'NoSchedule' rule
kubectl taint nodes node01 color=red:NoSchedule

# Describe the taints on 'node01'
kubectl describe nodes node01 | grep -i taint

# Label the 'controlplane' node with 'size=small'
kubectl label nodes controlplane size=small
```
