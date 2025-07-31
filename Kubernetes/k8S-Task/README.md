# Kubernetes Commands to Run and Expose Pods

## ✅ Step 1: Run the Pods

```bash
kubectl run backend --image=tanverit16/lackey-number:v2
kubectl run frontend --image=tanverit16/frondend:v5.3

kubectl expose pod backend \
  --name=backend \
  --type=ClusterIP \
  --port=8080 \
  --target-port=8080

kubectl expose pod frontend \
  --name=frontend \
  --type=NodePort \
  --port=80
