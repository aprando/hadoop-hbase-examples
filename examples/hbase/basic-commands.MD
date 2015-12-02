# Comandos básicos do HBase Shell

* Chamando um helper dos comandos.
```
hbase(main):001:0> help
```

* Criando uma tabela (você deve especificar o nome da tabela e a column family):
```
hbase(main):001:0> create 'test', 'cf'
0 row(s) in 0.4170 seconds
```

* Recupera informações da sua tabela.
```
hbase(main):002:0> list 'test'
TABLE
test
1 row(s) in 0.0180 seconds
=> ["test"]
```

* Insere dados em sua tabela.
```
hbase(main):003:0> put 'test', 'row1', 'cf:a', 'value1'
0 row(s) in 0.0850 seconds

hbase(main):004:0> put 'test', 'row2', 'cf:b', 'value2'
0 row(s) in 0.0110 seconds

hbase(main):005:0> put 'test', 'row3', 'cf:c', 'value3'
0 row(s) in 0.0100 seconds
````

* Busca todos os dados de uma vez:
```
hbase(main):006:0> scan 'test'
ROW                                      COLUMN+CELL
 row1                                    column=cf:a, timestamp=1421762485768, value=value1
 row2                                    column=cf:b, timestamp=1421762491785, value=value2
 row3                                    column=cf:c, timestamp=1421762496210, value=value3
3 row(s) in 0.0230 seconds
````

* Recupera um unico registro.
```
hbase(main):007:0> get 'test', 'row1'
COLUMN                                   CELL
 cf:a                                    timestamp=1421762485768, value=value1
1 row(s) in 0.0350 seconds
````

* Disabilita uma tabela (util para fazer alterações em sua configuração).
```
hbase(main):008:0> disable 'test'
0 row(s) in 1.1820 seconds

hbase(main):009:0> enable 'test'
0 row(s) in 0.1770 seconds
````

* Dropar a tabela.
```
hbase(main):011:0> drop 'test'
0 row(s) in 0.1370 seconds
```
