#!/bin/bash

# Step 1: Disable swap (necessary for Kubernetes)
echo "Disabling swap..."
sudo swapoff -a
sudo sed -i '/swap/d' /etc/fstab

# Step 2: Update system packages
echo "Updating system packages..."
sudo apt-get update && sudo apt-get upgrade -y

# Step 3: Install container runtime (containerd)
echo "Installing containerd..."
sudo apt-get install -y containerd
sudo systemctl enable --now containerd

# Step 4: Install Kubernetes packages dependencies
echo "Installing required dependencies for Kubernetes..."
sudo apt-get install -y apt-transport-https ca-certificates curl gpg

# Step 5: Add the Kubernetes package repository
echo "Downloading and adding Kubernetes package repository..."
sudo mkdir -p -m 755 /etc/apt/keyrings
sudo curl -fsSL https://pkgs.k8s.io/core:/stable:/v1.32/deb/Release.key | sudo gpg --dearmor -o /etc/apt/keyrings/kubernetes-apt-keyring.gpg

# Step 6: Add the Kubernetes repository to sources list
echo "Adding Kubernetes repository to sources list..."
sudo echo 'deb [signed-by=/etc/apt/keyrings/kubernetes-apt-keyring.gpg] https://pkgs.k8s.io/core:/stable:/v1.32/deb/ /' | sudo tee /etc/apt/sources.list.d/kubernetes.list

# Step 7: Update apt package index again
echo "Updating apt package index..."
sudo apt-get update

# Step 8: Install kubelet, kubeadm, and kubectl
echo "Installing Kubernetes components (kubelet, kubeadm, kubectl)..."
sudo apt-get install -y kubelet kubeadm kubectl

# Step 9: Mark Kubernetes packages to hold (to prevent upgrades)
echo "Marking Kubernetes packages to hold..."
sudo apt-mark hold kubelet kubeadm kubectl

# Step 10: Enable and start the kubelet service
echo "Enabling and starting kubelet service..."
sudo systemctl enable --now kubelet

# Step 11: Enable IPv4 forwarding
echo "Enabling IPv4 forwarding..."
sudo sysctl -w net.ipv4.ip_forward=1
sudo sysctl -p

echo "Kubernetes setup complete!"
