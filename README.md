Clonando e inicializando submódulos
git clone --recurse-submodules <repo-url>

Caso você já tenha clonado o repositório sem os submódulos
git submodule update --init --recursive

docker compose -f signoz/deploy/docker/docker-compose.yaml up -d --build --force-recreate