# Primeiros passos com MongoDB

* Para criar uma base de dados:
```
use mydatabase
```
Se essa base de dados não existir, o MongoDB vai cria-la para você.

* Para checar qual é a base de dados que estamos utilizando:
```
db
```

* Para listar todos os comandos possíveis:
```
help
```

* Para listar todas as base de dados disponívels:
```
show dbs
```

* Após difinir qual é a base de dados que você vai utilizar, utilize o comando abaixo para inserir um documento em uma collection:
```
db.mycoll.insert({name:"alan", rg:"34258999"})
```
Se a collection não existir, o MongoDB vai cria-la para você. Como não identificamos o _id, o valor também é definido para nós! =]

* Para listar todos os documentos de uma collection:
```
db.mycall.find()
```
