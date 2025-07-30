#!/bin/sh

CONTAINER_ID=$(cat /proc/self/cgroup | grep -Eo '[0-9a-f]{64}' | head -n1)

echo "window.CONTAINER_ID=\"$CONTAINER_ID\";" > /usr/share/nginx/html/container-id.js

exec nginx -g 'daemon off;'
