## K8S example

1. Start minikube
2. Run `kubectl apply -f kp-config.yaml`
3. Run `minikube addons enable ingress`
4. Run `kubectl apply -f ingress.yaml`
5. Run `kubectl apply -f kp-first-service.yaml`
6. Run `kubectl apply -f kp-first-composer.yaml`
7. Run `kubectl apply -f kp-second-service.yaml`
8. Run `kubectl apply -f kp-second-composer.yaml`
9. Add to `%WINDIR%\System32\drivers\etc\hosts` file following line: `127.0.0.1 kp-example.com`
10. Get ingress pod name: `kubectl get pods -n ingress-nginx`
11. Start port forwarding: `kubectl -n ingress-nginx port-forward pod/ingress-nginx-controller-5d88495688-dxxgw --address 0.0.0.0 80:80 443:443`, where you should replace ingress-nginx-controller-5d88495688-dxxgw with your ingress pod name.

Now cluster is available on http://kp-example.com/

Try endpoints with postman collection.