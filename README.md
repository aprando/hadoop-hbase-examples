# Sobre o Projeto
Este projeto realiza um overview com exemplos por todo o ecossistema Hadoop, desde sua instalação, configuração e projeto relacionados como Hive, Pig, Mahout e HBase. Além disso, é apresentado uma breve introdução as bases Redis e Mongo, dada a correlação entre os temas NoSQL e BigData.

## Ambiente
* Todos os exemplos são executados em um ambiente Unix.
* É necessário uma máquina com no mínimo 2 cores e 4GB de RAM para performance aceitável.

### Instalação do Sistema Operacional
Em nossas aulas vamos utilizar o Ubuntu Server 14.04 em uma máquina virtual.

#### Opção 1: Criando uma máquina virtual no VirtualBox ####

Para isso, basta seguir os passos:
* Baixar e instalar o [Virtual Box](https://www.virtualbox.org/). 
* Baixar a iso do [Ubuntu Server 14.04](http://www.ubuntu.com/download/server).
* Abir o Virtual Box.
* Clicar na opção "Novo".
![Passo1](https://raw.githubusercontent.com/aprando/hadoop-hbase-examples/master/images/passo-01.png)
* Selecionar o sistema operacional Linux Ubuntu.
![Passo2](https://raw.githubusercontent.com/aprando/hadoop-hbase-examples/master/images/passo-02.png)

* Nomear a VM e selecionar a quantidade de HD (mínimo de 8GB).
![Passo3](https://raw.githubusercontent.com/aprando/hadoop-hbase-examples/master/images/passo-03.png)

* Startar a sua VM.
* Selecionar a ISO que você realizou download para iniciarmos a instalação do Ubuntu Server 14.04 (isso ocorrerá apenas na primeira inicialização).
![Passo4](https://raw.githubusercontent.com/aprando/hadoop-hbase-examples/master/images/passo-04.png)

* Os próximos passos são referentes a instalação do Ubuntu na sua VM. Para eles, considerar:
  * Para a instalação, você pode selecionar a ligua de sua preferência.
  * Para o SO, recomendamos selecionar a lingua inglesa. 	
  * Região e localização São Paulo / Brasil.
  * Nome do usuário: hadoop
  * Senha do usuário: 12345678
  * Etapas relacionadas a proxy, segurança e demais programas que devem ser instalados, basta clicar em "next". 
  * Demais questionamentos, basta escolher a opção "padrão" e "next".	

#### Opção 2: Vagrant ####
Caso você seja um desenvolvedor experiente e conheça [vagrant](https://www.vagrantup.com/), basta utilizar nosso VagrantFile que esta na raiz do projeto! =]

Caso contratário, por favor, utilize a opção 1.

### Realizar Dowload de pacotes
Baixar todos os pacotes para utilizarmos na nossa instalação.
Para isso, basta rodar os comandos abaixo na sua vm
* Instalar Java:
````
sudo add-apt-repository ppa:webupd8team/java -y
sudo apt-get update
echo debconf shared/accepted-oracle-license-v1-1 select true | sudo debconf-set-selections
echo debconf shared/accepted-oracle-license-v1-1 seen true | sudo debconf-set-selections
sudo apt-get -y install oracle-java6-installer
sudo apt-get -y install oracle-java6-set-default
````

* Instalar softwares básicos.
````
sudo apt-get install ssh
sudo apt-get install rsync
````

* Baixar o hadoop.
````
wget  http://ftp.unicamp.br/pub/apache/hadoop/core/stable/hadoop-2.7.1.tar.gz
````

* Baixar o hbase.
````
wget http://mirror.nbtelecom.com.br/apache/hbase/1.1.2/hbase-1.1.2-bin.tar.gz
````

* Baixar o spark.
````
wget http://ftp.unicamp.br/pub/apache/spark/spark-1.4.1/spark-1.4.1-bin-hadoop2.6.tgz
````

* Baixar o hive.
````
wget http://www.eu.apache.org/dist/hive/hive-1.2.1/apache-hive-1.2.1-bin.tar.gz
````

* Baixar o pig.
````
wget http://www.eu.apache.org/dist/pig/latest/pig-0.15.0.tar.gz
````

* Baixar e instalar o redis.
````
sudo apt-get install -y redis-server
````

* Baixar e instalar o mongo.
````
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 7F0CEB10
sudo echo "deb http://repo.mongodb.org/apt/ubuntu "$(lsb_release -sc)"/mongodb-org/3.0 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.0.list
sudo apt-get update

sudo apt-get install -y mongodb-org
````

### Instalação do Hadoop
TODO

### Instalação do HBase
TODO

### Instalação do Mongo
TODO

### Instalação do Redis
TODO

## Agenda

* Aula 1
	- Instalação do Hadoop Standalone: ~30min
	- MapReduce Básico (word count): ~30min
	- HDFS Básico (ingestão de dados e consultas): ~45min
	- Instalação do Hadoop em cluster (explicar YARN + Apresentar cluster do cloudera): ~1h15

* Aula 2
	- Pig Básico: ~30min
	- Hive Básico: ~30min
	- Sqoop Básico + Ingestão de dados de um MySQL: ~1h
	- Queries Hive (mostrar as queries que faço em produção): 1h 

* Aula 3
	- Intro a IA + Mahout Básico: ~1h
	- Instalação HBase Standalone: ~30 min
	- HBase Básico: ~30 min
	- HBase Exemplos: ~30 min
	- Apresentar HBase em cluster (explicar HDFS + Apresentar cluster do cloudera):  30 min
	 
* Aula 4
	- Instalação MongoDB Standalone: ~30min
	- MongoDB Básico: ~30min
	- MongoDB Modelagem: ~30min
	- Instalação Redis Standalone: ~30min
	- Redis Básico: ~30min
	- Redis Modelagem: ~30min

