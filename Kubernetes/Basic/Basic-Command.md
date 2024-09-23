
# Kubernetes Command Cheat Sheet

Below are some useful Kubernetes commands.

```bash
kubectl run nginx --image=nginx
```
[# Run an nginx pod](#)

```bash
kubectl get pods
```
[Copy](#)

```bash
kubectl get pods -o wide
```
[Copy](#)

```bash
kubectl expose pods nginx --name=nginx-web --port=80 --type=NodePort
```
[Copy](#)

```bash
kubectl get svc
```
[Copy](#)

```bash
kubectl run apache --image=httpd --namespace=test
```
[Copy](#)

```bash
kubectl expose pods apache --name=web --port=80 --type=NodePort --n=test
```
[Copy](#)

```bash
kubectl run nginx --image=nginx --dry-run=client -o yaml > pod.yaml
```
[Copy](#)

```bash
kubectl create deploy webserver --image=httpd
```
[Copy](#)

```bash
kubectl get deploy
```
[Copy](#)

```bash
kubectl scale rs replicaset-1 --replicas=25
```
[Copy](#)

```bash
kubectl get rs
```
[Copy](#)

```bash
kubectl taint nodes node01 color=red:NoSchedule
```
[Copy](#)

```bash
kubectl describe nodes node01 | grep -i taint
```
[Copy](#)

```bash
kubectl label nodes controlplane size=small
```
[Copy](#)
