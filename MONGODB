## Instalação do Mongo
Para instalar o MongoDB siga as instruções abaixo:

* Baixar o mongo.
````
wget https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-ubuntu1404-3.0.7.tgz
````

* Descompacte o arquivo baixado:
```
tar -xvf mongodb-linux-x86_64-ubuntu1404-3.0.7.tgz
```

* Crie uma pasta e mova todos os arquivos para ela:
```
mv mongodb-linux-x86_64-ubuntu1404-3.0.7 mongodb
```

* Coloque os binarios no PATH. 
```
export PATH=/home/hadoop/hadoop-handson/mongodb/bin:$PATH
```

* Crie o diretório que os dados serão armazenados.
Antes de inicializar o MongoDB pela primeira vez, crie o diretório que o processo mongod persistirá os dados. Por padrão, o processo mongod utiliza o diretorio /data/db.
```
sudo mkdir -p /data/db
```

* Adicione as permissões para esta pasta:
```
sudo chown hadoop.hadoop -R /data/
```

* Inicie o MongoDB.
Para iniciar o MongoDB, inicie o processo mongod, que vai ficar escutando conexoes (abra em uma aba separada para você analisar as logs).
```
./mongodb/bin/mongod
```

* Abra o mongo shell e execute os comandos! =]
```
./mongodb/bin/mongo
```

#### Entendendo as daemons do mongo

Quando você rodar os processos do mongo, vai utilizar basicamente 3 binarios:

* mongod é o processo principal do MongoDB. Ele lida com todos os requests, gerencia o acesso aos dados e performa operações gerenciais que rodam em background.

* mongos é utilizado para "MongoDB Shard", ou seja, é um serviço de rotina para as configurações de Shard do MongoDB aonde processa queries da aplicação e determina a localização dos dados dentro do cluster. Do ponto de vista da aplicação, o mongos funciona como o mongod.

* mongo é um shell JavaScript interativo.

#### Sharding e Replicaset

Replica Set consiste em replicar os dados entre instâncias de MongoDB, permitindo maior tolerância à falhas. 

Sharding consiste em dividir os dados (e a carga de I/O) entre instâncias de MongoDB ou entre Replica Sets, permitindo maior performance em leitura e escrita.

A criação de um Replica Set pode ser considerado um dos primeiros passos no processo de escala do MongoDB, pois ele garante redundância dos dados e tolerância à falhas, caso uma ou mais instâncias parem de funcionar, graças ao mecanismo de failover.
