#!/bin/bash

set -e

echo "[+] Disabling swap..."
sudo swapoff -a
sudo sed -i '/swap/d' /etc/fstab

echo "[+] Updating system packages..."
sudo apt-get update && sudo apt-get upgrade -y

echo "[+] Installing container runtime (containerd)..."
sudo apt-get install -y containerd
sudo systemctl enable --now containerd

echo "[+] Installing dependencies for Kubernetes..."
sudo apt-get install -y apt-transport-https ca-certificates curl gpg

echo "[+] Adding Kubernetes apt repository..."
sudo mkdir -p -m 755 /etc/apt/keyrings
curl -fsSL https://pkgs.k8s.io/core:/stable:/v1.32/deb/Release.key | sudo gpg --dearmor -o /etc/apt/keyrings/kubernetes-apt-keyring.gpg

echo 'deb [signed-by=/etc/apt/keyrings/kubernetes-apt-keyring.gpg] https://pkgs.k8s.io/core:/stable:/v1.32/deb/ /' | sudo tee /etc/apt/sources.list.d/kubernetes.list

echo "[+] Installing Kubernetes components (kubelet, kubeadm, kubectl)..."
sudo apt-get update
sudo apt-get install -y kubelet kubeadm kubectl
sudo apt-mark hold kubelet kubeadm kubectl
sudo systemctl enable --now kubelet

echo "[+] Enabling IPv4 forwarding..."
sudo sysctl -w net.ipv4.ip_forward=1
sudo sysctl -p

echo "[+] Kubernetes v1.32 setup completed. Please run 'sudo kubeadm init' to initialize your control plane."
