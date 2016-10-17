## Instalação do Redis

Redis é uma base de dados muito poderosa, e talvez a mais simples de instalar e utilizar!
Para instala-lo, basta seguir os passos abaixo:

* Baixar o redis.
````
wget http://download.redis.io/releases/redis-3.0.5.tar.gz
````

* Descompacte o arquivo baixado:
```
tar -xvf redis-3.0.5.tar.gz 
```

* Como o redis é escrito utilizando a lingugem C, vamos buildar a solução com o comando make:
```
cd redis-3.0.5
make
```

* Após a compilação o diretório src é populado com:
	- redis-server é o servidor do Redis!
	- redis-sentinel é processo para monitoramento.
	- redis-benchmark utilizado para medir a performace do Redis.
	- redis-check-aof e redis-check-dump são utilizados quando há algum problema de arquivo corrompido.

* Inicie o redis-server (abra em outra aba para você ver os logs):
```
cd redis-3.0.5/src
redis-server
```

* Faça comandos utilizando redis-cli... =]
```
cd redis-3.0.5/src
redis-cli
```
