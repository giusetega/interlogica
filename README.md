# interlogica
Pasticceria per interlogica


aggiornare il nodeAffinity del persitentVolumehelm repo update
kubectl debug node/node_name -it --image=busybox -> cd host -> mkdir -p mnt/local-data

ingress installation stpes:
kubectl create namespace ingress-nginx
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update
helm install ingress-nginx ingress-nginx/ingress-nginx \
--namespace ingress-nginx \
--set controller.service.type=LoadBalancer


