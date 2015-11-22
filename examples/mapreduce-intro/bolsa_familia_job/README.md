# Bolsa Familia Map Reduce JOB

## Instruções iniciais

### Download dos dados 
Acessar o [Portal da Transparência](http://www.portaldatransparencia.gov.br/downloads/mensal.asp?c=BolsaFamiliaFolhaPagamento) e baixar um consolidado mensal (escolha o mês de sua preferência).

### Preparação do ambiente
Com o Hadoop instalado e configurado, siga os seguintes passos:
* Remova acentuação, header, e troque <tab> por ; do arquivo que você baixou utilizando o comando abaixo:
```
tail -n +2 201XXX_BolsaFamiliaFolhaPagamento.csv | iconv -f "ISO-8859-1" -t "ascii//TRANSLIT" | sed 's/\t/;/g' > bolsa_familia.csv
```

* Crie a estrutura no HDFS e transfira o arquivo de input do bolsa familia: 
```
hdfs dfs -mkdir /data
hdfs dfs -copyFromLocal bolsa_familia.csv /data/
```

* Empacote o job utilizando [MAVEN](https://maven.apache.org/). Para isso, acesse a raiz do projeto (aonde se encontra o arquivo pom.xml) e rode o comando abaixo. Este comando gerará arquivo bolsa_familia_pago-job.jar dentro da pasta /target, que é o JOB MapReduce do Bolsa Familia que rodaremos a seguir.
```
mvn clean package
```		

* Execute o Job Por UF ou Cidade:
```
hadoop jar bolsa_familia_pago-job.jar "UF" /data/bolsa_familia.csv /data/out_bolsa_familia
hadoop jar bolsa_familia_pago-job.jar "CIDADE" /data/bolsa_familia.csv /data/out_bolsa_familia 
```

* Verifique o arquivos que foram gerados através do Job:
```
hdfs dfs -ls /data/out_bolsa_familia
```

* Verifique o conteúdo gerado na pasta:
```
hdfs dfs -cat /data/out_bolsa_familia/part*
```

* Se você rodar o JOB mais de uma vez, não se esqueça de apagar a pasta de OUTPUT.
```
hdfs dfs -rm -r -skipTrash /data/out_bolsa_familia
```
