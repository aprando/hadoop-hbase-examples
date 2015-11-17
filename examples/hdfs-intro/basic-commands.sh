#Comandos básicos do HDFS.

## Criando um diretório:
Comando: hadoop fs -mkdir
```
   Usage: 
            hadoop fs -mkdir <paths> 
    Example:
            hadoop fs -mkdir /user/hadoop/dir1 /user/hadoop/dir2
            hadoop fs -mkdir hdfs://nn1.example.com/user/hadoop/dir
```

## Listar arquivos:
Comando: hadoop fs -ls
```
    Usage: 
            hadoop fs -ls <args>
    Example: 
            hadoop fs -ls /user/hadoop/dir1 /user/hadoop/dir2
            hadoop fs -ls /user/hadoop/dir1/filename.txt
            hadoop fs -ls hdfs://<hostname>:9000/user/hadoop/dir1/
```

## Verificando utilização de espaço no HDFS:
Comando: hadoop fs -du
```
    Usage:  
            hadoop fs -du URI
    Example:
            hadoop fs -du  /user/hadoop/ /user/hadoop/dir1/Sample.txt
```

## Adicionando arquivos dentro do HDFS:
Comando: hadoop fs -put
```
    Usage: 
            hadoop fs -put <localsrc> ... <HDFS_dest_Path>
    Example:
            hadoop fs -put /home/ec2-user/Samplefile.txt ./ambari.repo /user/hadoop/dir3/
```

## Recuperando arquivos do HDFS:
Comando: hadoop fs -get
```
    Usage: 
            hadoop fs -get <hdfs_src> <localdst> 
    Example:
            hadoop fs -get /user/hadoop/dir3/Samplefile.txt /home/
```

## Concatenando arquivos da máquina local em arquivos dentro do HDFS:
Comando: hadoop fs -getmerge
```
    Usage: 
            hadoop fs -getmerge <src> <localdst> [addnl]
    Example:
            hadoop fs -getmerge /user/hadoop/dir1/  ./Samplefile2.txt
    Option:
            addnl: can be set to enable adding a newline on end of each file
```

## Copia arquivos ou diretorios recursivamente dentro do hdfs
Comando: hadoop distcp
```
    Usage: 
            hadoop distcp <srcurl> <desturl>
    Example:
            hadoop distcp hdfs://<NameNode1>:8020/user/hadoop/dir1/ \ 
                    hdfs://<NameNode2>:8020/user/hadoop/dir2/
```

## Listando todos os comandos validos:
Comando: hadoop fs -help
```
    Example:    
            hadoop fs -help
```
