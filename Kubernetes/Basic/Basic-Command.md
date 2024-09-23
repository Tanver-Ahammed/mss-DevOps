
# Kubernetes Commands Description

1. `kubectl run nginx --image=nginx`  
   **Description**: Creates a pod running an nginx container.
   **Copy**: `kubectl run nginx --image=nginx`

2. `kubectl get pods`  
   **Description**: Lists all running pods in the default namespace.
   **Copy**: `kubectl get pods`

3. `kubectl get pods -o wide`  
   **Description**: Lists all running pods with additional information like node hosting the pod and IP.
   **Copy**: `kubectl get pods -o wide`

4. `kubectl expose pods nginx --name=nginx-web --port=80 --type=NodePort`  
   **Description**: Exposes the nginx pod as a service with NodePort on port 80.
   **Copy**: `kubectl expose pods nginx --name=nginx-web --port=80 --type=NodePort`

5. `kubectl get svc`  
   **Description**: Lists all services in the current namespace.
   **Copy**: `kubectl get svc`

6. `kubectl run apache --image=httpd --namespace=test`  
   **Description**: Creates a pod running an Apache HTTP server in the `test` namespace.
   **Copy**: `kubectl run apache --image=httpd --namespace=test`

7. `kubectl expose pods apache --name=web --port=80 --type=NodePort --n=test`  
   **Description**: Exposes the Apache pod as a service with NodePort on port 80 in the `test` namespace.
   **Copy**: `kubectl expose pods apache --name=web --port=80 --type=NodePort --n=test`

8. `kubectl run nginx --image=nginx --dry-run=client -o yaml > pod.yaml`  
   **Description**: Generates the YAML configuration for an nginx pod without creating it, saving it to `pod.yaml`.
   **Copy**: `kubectl run nginx --image=nginx --dry-run=client -o yaml > pod.yaml`

9. `kubectl create deploy webserver --image=httpd`  
   **Description**: Creates a deployment running an Apache HTTP server.
   **Copy**: `kubectl create deploy webserver --image=httpd`

10. `kubectl get deploy`  
    **Description**: Lists all deployments in the current namespace.
    **Copy**: `kubectl get deploy`

11. `kubectl scale rs replicaset-1 --replicas=25`  
    **Description**: Scales the replicaset named `replicaset-1` to 25 replicas.
    **Copy**: `kubectl scale rs replicaset-1 --replicas=25`

12. `kubectl get rs`  
    **Description**: Lists all ReplicaSets in the current namespace.
    **Copy**: `kubectl get rs`

13. `kubectl taint nodes node01 color=red:NoSchedule`  
    **Description**: Taints `node01` with the key `color`, value `red`, and effect `NoSchedule`.
    **Copy**: `kubectl taint nodes node01 color=red:NoSchedule`

14. `kubectl describe nodes node01 | grep -i taint`  
    **Description**: Describes the `node01` node and filters the taints applied to it.
    **Copy**: `kubectl describe nodes node01 | grep -i taint`

15. `kubectl label nodes controlplane size=small`  
    **Description**: Labels the `controlplane` node with the label `size=small`.
    **Copy**: `kubectl label nodes controlplane size=small`
