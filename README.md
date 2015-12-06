# Sobre o Projeto
Este projeto realiza um overview com exemplos por todo o ecossistema Hadoop, desde sua instalação, configuração e projeto relacionados como Hive, Pig, Mahout e HBase. Além disso, é apresentado uma breve introdução as bases Redis e Mongo, dada a correlação entre os temas NoSQL e BigData.

## Ambiente
* Todos os exemplos são executados em um ambiente Unix.
* É necessário uma máquina com no mínimo 2 cores e 4GB de RAM para performance aceitável.

### Instalação do Sistema Operacional
Em nossas aulas vamos utilizar o Ubuntu Server 14.04 em uma máquina virtual.

#### Opção 1: Criando uma máquina virtual no VirtualBox ####

Para isso, basta seguir os passos:

1. Baixar e instalar o [Virtual Box](https://www.virtualbox.org/). 
2. Baixar a iso do [Ubuntu Desktop 14.04.1](http://old-releases.ubuntu.com/releases/14.04.2/ubuntu-14.04.1-desktop-amd64.iso).
3. Abrir o Virtual Box.
4. Clicar na opção "Novo".
![Passo1](https://raw.githubusercontent.com/aprando/hadoop-hbase-examples/master/images/passo-01.png)
5. Selecionar o sistema operacional Linux Ubuntu.
![Passo2](https://raw.githubusercontent.com/aprando/hadoop-hbase-examples/master/images/passo-02.png)
6. Nomear a VM e selecionar a quantidade de HD (mínimo de 16GB).
![Passo3](https://raw.githubusercontent.com/aprando/hadoop-hbase-examples/master/images/passo-03.png)
7. Entrar no menu "Settings" -> "System" -> "Motherboard" e selecionar a quantidade de memoria RAM com mínimo de 2048MB (2GB).
![Passo5](https://raw.githubusercontent.com/aprando/hadoop-hbase-examples/master/images/passo-05.png)
8. Entrar no menu "Settings" -> "System" -> "Processor" e selecionar a quantidade de cores de CPU com mínimo de 4 cores.
![Passo6](https://raw.githubusercontent.com/aprando/hadoop-hbase-examples/master/images/passo-06.png)
9. Entrar no menu "Settings" -> "Display" -> "Vídeo" e selecionar a quantidade de memoria de 128GB RAM e opcao "Enable 3D Aceleration".
![Passo7](https://raw.githubusercontent.com/aprando/hadoop-hbase-examples/master/images/passo-07.png)
10. Entrar no menu "Settings" -> "General" -> "Advanced" e habilitar copy e past entre a máquina virtual e a máquina host.
![Passo8](https://raw.githubusercontent.com/aprando/hadoop-hbase-examples/master/images/passo-08.png)

11. Startar a sua VM.
12. Selecionar a ISO que você realizou download para iniciarmos a instalação do Ubuntu Server 14.04 (isso ocorrerá apenas na primeira inicialização).
![Passo4](https://raw.githubusercontent.com/aprando/hadoop-hbase-examples/master/images/passo-04.png)

13. Inicie a instalação do Ubuntu Desktop na sua VM selecionando a língua de sua preferência.
14. Escolha a região e localização São Paulo / Brasil.
15. Durante a instalação, você deve escolher o padrão do seu teclado, o nome do usuário do SO (sugestão: hadoop) e a senha do usuário (sugestão: 123456).
16. Demais questionamentos, basta escolher a opção "padrão" e "next".
17. Após finalizar a instalação do SO, abra o terminal e instala o virtualbox-guest para desfrutar sua VM em full screen:
```
sudo apt-get update
sudo apt-get install virtualbox-guest-dkms virtualbox-guest-utils virtualbox-guest-x11
```

#### Opção 2: Vagrant ####
Caso você seja um desenvolvedor experiente e conheça [vagrant](https://www.vagrantup.com/), basta utilizar nosso VagrantFile que esta na raiz do projeto! =]

Caso contratário, por favor, utilize a opção 1.

#### Opção 3: Máquina virtual já criada... ####
Também disponibilizamos uma VM com Ubuntu Desktop instalado e com todos os pacotes baixados! =]
Esta opção contempla toda a instalação acima e os pacotes abaixo, porém nenhuma instalação foi realizada.
Por favor, confira se os itens 7, 8, 9 e 10 estão OK!
````
https://drive.google.com/folderview?id=0B6BAj1gwpQqKSzY5dnhNemc2OGc&usp=sharing
````

### Realizar Dowload de pacotes
Baixar todos os pacotes para utilizarmos na nossa instalação em uma unica pasta.
Para isso, basta rodar os comandos abaixo na sua vm
* Criar pasta e acessa-la:
````
mkdir ~/hadoop-handson
cd ˜/hadoop-handson
````

* Instalar Java:
````
sudo add-apt-repository ppa:webupd8team/java -y
sudo apt-get update
echo debconf shared/accepted-oracle-license-v1-1 select true | sudo debconf-set-selections
echo debconf shared/accepted-oracle-license-v1-1 seen true | sudo debconf-set-selections
sudo apt-get -y install oracle-java7-installer
sudo apt-get -y install oracle-java7-set-default
````

* Altere o arquivo ~/.bashrc e adicione a linha abaixo:
````
export JAVA_HOME=/usr/lib/jvm/java-7-oracle
````

* Instalar Maven:
````
sudo apt-get install maven
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
wget http://www.eu.apache.org/dist/hbase/1.1.2/hbase-1.1.2-bin.tar.gz
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

* Baixar o mahout.
````
wget http://ftp.unicamp.br/pub/apache/mahout/0.11.1/apache-mahout-distribution-0.11.1.tar.gz
````

* Baixar o sqoop.
````
wget http://ftp.unicamp.br/pub/apache/sqoop/1.99.6/sqoop-1.99.6-bin-hadoop200.tar.gz
````


* Baixar o redis.
````
wget http://download.redis.io/releases/redis-3.0.5.tar.gz
````

* Baixar o mongo.
````
wget https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-ubuntu1404-3.0.7.tgz
````

### Instalação do Hadoop

#### Standalone

Por default, o Hadoop é configurado para ser executado em um modo não-distribuído, como um único processo Java. 
Por isso, a instalação do modo standalone é bem simples:
* Descompacte o pacote do Hadoop e acessa a pasta:
```
tar -xvf hadoop-2.7.1.tar.gz
cd hadoop-2.7.1/
```

* Execute o comando abaixo e veja a documentação de como utilizar o script do hadoop:
```
./bin/hadoop
```

Para validar seu funcionamento, rode o exemplo abaixo. Nele nós executamos um programa 'grep' dentro do jar hadoop-mapreduce-examples-*.jar que recebe um diretorio, busca e apresenta todos os matches de uma regular expression em um diretorio output: 
```
mkdir input
cp etc/hadoop/*.xml input
./bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.1.jar grep input output 'dfs[a-z.]+'
cat output/*
```

#### Pseudo-distribuído
Hadoop também pode ser executado em uma única máquina em um modo pseudo-distribuído, onde cada daemon Hadoop roda em um processo Java separado. 

Para isso, siga as configurações a seguir.

##### Acesso SSH 
O Hadoop gerencia todos os nós do seu cluster por meio de acesso SSH. Como nosso exemplo roda em um unico nó pseudo-distribuido, precisamos configurar o acesso SSH para localhost e o usuário hadoop (ou o usuário ubuntu que você vai rodar seus jobs).
```
ssh-keygen
cat $HOME/.ssh/id_rsa.pub > $HOME/.ssh/authorized_keys
ssh localhost
```

##### Configuração da JDK (para evitar problemas)...
O Hadoop é escrito em Java, portanto todos os processos que subimos no SO utilizam a JDK.
Para que o Hadoop utilize a versão correta, altere o arquivo etc/hadoop/hadoop-env.sh:

```
export JAVA_HOME=/usr/lib/jvm/java-7-oracle
```

##### Configuração do HDFS 

* Altere o arquivo etc/hadoop/core-site.xml:
```
<configuration>
    <property>
        <name>fs.defaultFS</name>
        <value>hdfs://localhost:9000</value>
    </property>
</configuration>
```

* Altere o arquivo etc/hadoop/hdfs-site.xml::
```
<configuration>
    <property>
        <name>dfs.replication</name>
        <value>1</value>
    </property>
</configuration>
```

* Formate o filesystem:
```
./bin/hdfs namenode -format
```

* Inicie as deamons DataNode e NameNode (um arquivo de log é escrito no diretorio $HADOOP_HOME/logs).
```
./sbin/start-dfs.sh
```

* Navegue pela interface web do NameNode:
```
http://localhost:50070/
```

* Make the HDFS directories required to execute MapReduce jobs:
```
./bin/hdfs dfs -mkdir /user
./bin/hdfs dfs -mkdir /user/<username>
```

* Quando finalizar, pare as deamons:
```
./sbin/stop-dfs.sh
```

##### Configuração do YARN

* Altere o arquivo: etc/hadoop/mapred-site.xml
```
<configuration>
    <property>
        <name>mapreduce.framework.name</name>
        <value>yarn</value>
    </property>
</configuration>
```

* Altere o arquivo: etc/hadoop/yarn-site.xml
```
<configuration>
    <property>
        <name>yarn.nodemanager.aux-services</name>
        <value>mapreduce_shuffle</value>
    </property>
</configuration>
```

* Inicie as daemons ResourceManager e NodeManager:
```
sbin/start-yarn.sh
```

* Navegue pela interface web do ResourceManager:
```
 http://localhost:8088/
```

* Quando finalizar, pare as deamons:
```
./sbin/stop-yarn.sh
```

##### Validando a instalação

* Copie alguns arquivos de input no hdfs:
```
./bin/hdfs dfs -put etc/hadoop input
```

* Rode o comando grep do jar de exemplo.
```
./bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.1.jar grep input output 'dfs[a-z.]+'
```

* Examine os arquivos de saida baixando eles para sua maquina local:
```
./bin/hdfs dfs -get output output
cat output/*
```

* ou veja os arquivos de saida dentro do proprio hdfs:
```
./bin/hdfs dfs -cat output/*
```

### Instalação do HBase
Assim como o Hadoop, o HBase pode ser instalado nos modos Standalone, Pseudo-distribuido e Distribuido.

#### Standalone
De forma muito parecida com o Hadoop Standalone, o HBase simula em sua máquina utilizando o seu SO como filesytem. Para isso, basta seguir as instruções abaixo:

* O HBase espera um loopback do IP, que na distribuição Ubuntu pode causar alguns problemas. Para tratar, alterar seu /etc/hosts:
```
127.0.0.1 localhost
127.0.0.1 ubuntu.ubuntu-domain ubuntu
```

* Descompate seu arquivo e acesse a pasta:
```
$ tar xzvf hbase-<?eval ${project.version}?>-bin.tar.gz
$ cd hbase-<?eval ${project.version}?>/
```

* Edite o arquivo conf/hbase-site.xml:
```
<configuration>
  <property>
    <name>hbase.rootdir</name>
    <value>file:///home/testuser/hbase</value>
  </property>
  <property>
    <name>hbase.zookeeper.property.dataDir</name>
    <value>/home/testuser/zookeeper</value>
  </property>
</configuration>
```

* Altere o seu arquivo conf/hbase-env.sh com a JAVA_HOME.
```
export JAVA_HOME=/usr/lib/jvm/java-7-oracle
```

* Suba o HBase! =]
```
bin/start-hbase.sh
```

* Pronto! O HBase esta no ar. Você pode utilizar o shell e realizar suas primeiras queries:
```
./bin/hbase shell
```

#### Pseudo-distribuido
Neste modo o HBase roda em apenas um host, porém cada HBase daemon (HMaster, HRegionServer e Zookeeper) roda em um procesos separado. Por padrão, ao menos que você configure o hbase.rootdir como descrito no Standalone mode, seus dados ainda serão salvos em /tmp/, mas com a opção de utilizar o HDFS ao invés do seu Filesystem.

Observação: este passo assume que você já subiu o Hadoop e HDFS pseudo-distribuido com sucesso.

* Pare o HBASE se ele estiver rodando.
* Edit o arquivo hbase-site.xml.
```
<property>
  <name>hbase.cluster.distributed</name>
  <value>true</value>
</property>
<property>
  <name>hbase.rootdir</name>
  <value>hdfs://localhost:8020/hbase</value>
</property>
```

* Suba o HBase.
```
./bin/start-hbase.sh
```

* Verifique a pasta hbase criada no HDFS.
```
./hadoop-<version>/bin/hadoop fs -ls /hbase
```

* Recrie as tabelas do modo standalone e consulte a pasta do HDFS novamente! Você vera os arquivos sendo armazendos no HDFS! =]

### Instalação do Mongo
Para instalar o MongoDB siga as instruções abaixo:

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

### Instalação do Redis
Redis é uma base de dados muito poderosa, e talvez a mais simples de instalar e utilizar!
Para instala-lo, basta seguir os passos abaixo:

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

## Agenda

* Aula 1
	- Instalação do Hadoop Standalone e Pseudo-distribuido.
	- HDFS Básico (ingestão de dados e consultas).
	- MapReduce Básico (word count).
	- MapReduce do Bolsa Familia.

* Aula 2
	- Revisão Aula 	
	- Hive Básico.
	- Hive com Bolsa Familia.
	- Cloudera Manager Overview.
	- Intro a IA + Mahout Básico.

* Aula 3
	- Instalação de um cluster Hadoop.
	- Instalação HBase Standalone.
	- HBase Básico.
	- HBase Exemplos.
	- Apresentar HBase em cluster (explicar HDFS + Apresentar cluster do cloudera).
	 
* Aula 4
 	- Instalação MongoDB Standalone.
	- MongoDB Básico.
	- MongoDB Modelagem.
	- Instalação Redis Standalone.
	- Redis Básico.
	- Redis Modelagem.

