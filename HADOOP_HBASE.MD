# Instalação do Hadoop e Hbase

## Realizar Dowload de pacotes
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
wget  http://ftp.unicamp.br/pub/apache/hadoop/common/hadoop-2.7.3/hadoop-2.7.3.tar.gz
````

* Baixar o hbase.
````
wget http://ftp.unicamp.br/pub/apache/hbase/0.98.22/hbase-0.98.22-hadoop1-bin.tar.gz
````

* Baixar o hive.
````
wget http://www.eu.apache.org/dist/hive/hive-1.2.1/apache-hive-1.2.1-bin.tar.gz
````

## Instalação do Hadoop

#### Standalone

Por default, o Hadoop é configurado para ser executado em um modo não-distribuído, como um único processo Java. 
Por isso, a instalação do modo standalone é bem simples:
* Descompacte o pacote do Hadoop e acessa a pasta:
```
tar -xvf hadoop-2.7.3.tar.gz
cd hadoop-2.7.3/
```

* Execute o comando abaixo e veja a documentação de como utilizar o script do hadoop:
```
./bin/hadoop
```

Para validar seu funcionamento, rode o exemplo abaixo. Nele nós executamos um programa 'grep' dentro do jar hadoop-mapreduce-examples-*.jar que recebe um diretorio, busca e apresenta todos os matches de uma regular expression em um diretorio output: 
```
mkdir input
cp etc/hadoop/*.xml input
./bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.3.jar grep input output 'dfs[a-z.]+'
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

## Instalação do HBase
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
