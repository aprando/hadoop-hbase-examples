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

* Verificar o status do server:
```
db.serverStatus()
```

* Utilizando javascript no shell... =]
```
for (i = 0; i < 5; i++) {
	db.funcionarios.insert({
		'matricFunc': 203,
		'nomeFunc': 'Ester dos Anjos',
		'cargoFunc': 'presidente',
		'salarioFunc': '90000'
	})
}
```

* Você pode tornar o JSON de retorno bonito utilizando pretty():
```
db.usuario.find()
db.usuario.find().pretty()
```

* Consultando utilziando IN clause:
```
db.deptos.find({ siglaDepto: { $in: [ 'INFO', 'VEND' ] } })
````

* Consultando utilziando AND clause:
```
db.deptos.find( { siglaDepto: 'INFO', orcamentoGlobalDepto: { $lt: 1 } } )
````

* Consultando utilizando OR clause:
```
db.deptos.find( { $or: [
	 { numeroFuncionariosDepto: { $gt: 1 } },
	 { orcamentoGlobalDepto: { $lt: 800001 } } 
] } )
```

* Consultando utilizando AND with OR clause:
```
db.deptos.find(
   {
     siglaDepto: 'INFO', 
	 $or: [
	 	 { numeroFuncionariosDepto: { $gt: 1 } },
	 	 { orcamentoGlobalDepto: { $lt: 800001 } } 
	 ]
   }
)
```

* Removendo alguns documentos:
```
db.deptos.remove({siglaDepto: 'INFO'})
```

* Atualizando um documento:
```
db.deptos.update(
	{ numeroFuncionariosDepto: { $gt: 1 },
	{ "$set": { orcamentoGlobalDepto: 16000 }}
)
```

* CUIDADO! Se você não passar o $set, o documento todo será sobrescrito!
```
db.deptos.update(
	{ nome: "BLA" },
	{ orcamentoGlobalDepto: 16000 }
)
```

* E se você deseja atualizar multiplos documentos ao mesmo tempo, você deve explicitar utilizando o parametro multi:
```
db.deptos.update(
	{ numeroFuncionariosDepto: { $gt: 1 },
	{ orcamentoGlobalDepto: 16000 },
	{ multi: true }
)
```

# Comparando RDBMS com MongoDB

Para facilitar o entendimento, vamos comparar alguns scripts RDBMS e MOngoDB

## RDBMS

```
create table Funcionarios (
  matricFunc numeric(10),
  nomeFunc varchar(30) not null,
  cargoFunc varchar(30),
  salarioFunc numeric(9,2),
  primary key (matricFunc));

insert into funcionarios values (203,'Ester dos Anjos','presidente',90000);
insert into funcionarios values (202,'Fabio Almeida','analista de sistemas',3000);
insert into funcionarios values (220,'Angelina Almeida','analista de sistemas',3000);
insert into funcionarios values (204,'Maria dos Santos','analista de sistemas',2500);
insert into funcionarios values (205,'Maria dos Santos','analista de vendas',2500);
insert into funcionarios values (206,'Gustavo dos Santos','gerente',7500);
insert into funcionarios values (207,'Luiza Braz Lima','DBA',7000);
Insert into funcionarios values (230,'Debora Pereira','pesquisador1',7500);
Insert into funcionarios values (231,'Fabiola Rodrigues','pesquisador3',5000);
Insert into funcionarios values (233,'Antonio Pereira','pesquisador3',5000);
Insert into funcionarios values (235,'Fernando Lima Barreto','pesquisador2',6700);
Insert into funcionarios values (1,'Severino Cavalcanti','assessor da presidencia',7500);
Insert into funcionarios values (232,'Joana Cavalcanti','auxiliar',3000);

create table Deptos (
  siglaDepto varchar(6),
  nomeDepto varchar(30) not null,
  orcamentoGlobalDepto numeric(12,2),
  numeroFuncionariosDepto numeric(3),
  primary key (siglaDepto));

insert into Deptos values ('INFO','Informatica',2000000,5);
insert into Deptos values ('VEND','vendas',800000,1);
insert into Deptos values ('PRES','Presidencia',20000000,1);
insert into Deptos values ('PESQ','Pesquisa e Desenvolvimento',500000,0);

create table Projetos (
  codProj varchar(4),
  tituloProj varchar(50),
  orcamento numeric(12,2),
  prazoProj numeric(2),
  unidadePrazo varchar(7),
  coordProj numeric(10) not null,
  siglaDepto varchar(6) not null,
  primary key (codProj));

Alter table Projetos
  add check (unidadePrazo in ('dia','dias','mes','meses', 'ano','anos'));

Alter table Projetos 
  add foreign key (CoordProj) references Funcionarios;

Alter table Projetos 
  add foreign key (siglaDepto) references Deptos;

insert into Projetos values ('Pxml','Projeto XML',300000,2,'anos',220,'INFO');
insert into Projetos values ('PCMM','Projeto Modelo de Capacitacao para Maturidade',3000000,5,'anos',205,'INFO');
insert into Projetos values ('PMRH','Projeto Manutencao Sistema RH Folha',100000,6,'meses',220,'INFO');
Insert into projetos values ('CGP', 'Companhia de Gerencia de Projeto', 500000,5,'meses', 1, 'PRES');
Insert into projetos values ('SGBD', 'Novo SGBD PostgreSql', 20000,1,'ano', 230, 'PESQ');

create table FuncProj (
  codProj varchar(4),
  matricFunc numeric(10),
  totalHorasMes numeric(3) not null,
  primary key (codProj,matricFunc));

alter table FuncProj
  add foreign key (codProj) references Projetos;

alter table FuncProj
  add foreign key (matricFunc) references Funcionarios;

insert into FuncProj values ('Pxml',220,40);
insert into FuncProj values ('Pxml',204,80);
insert into FuncProj values ('Pxml',202,120);
insert into FuncProj values ('PCMM',205,60);
insert into FuncProj values ('PCMM',220,80);
insert into FuncProj values ('PMRH',220,40);
insert into FuncProj values ('PCMM',204,80);
insert into FuncProj values ('PCMM',202,40);
insert into FuncProj values ('PCMM',207,40);

insert into funcproj values ('CGP', 1,10);
insert into funcproj values ('CGP', 232,80);
insert into funcproj values ('SGBD',235,120);
insert into funcproj values ('SGBD', 233,40);
insert into funcproj values ('SGBD', 231,80);
insert into funcproj values ('SGBD', 230,40);
```

## MONGODB

```
use dbexemplo

-- Collection DEPTOS
db.deptos.insert({'siglaDepto':'INFO', 'nomeDepto': 'Informatica', 'orcamentoGlobalDepto': 2000000,  'numeroFuncionariosDepto': 5})
db.deptos.insert({'siglaDepto':'VEND', 'nomeDepto': 'vendas', 'orcamentoGlobalDepto': 800000,  'numeroFuncionariosDepto': 1})
db.deptos.insert({'siglaDepto':'PRES', 'nomeDepto': 'Presidencia', 'orcamentoGlobalDepto': 20000000,  'numeroFuncionariosDepto': 1})
db.deptos.insert({'siglaDepto':'PESQ', 'nomeDepto': 'Pesquisa e Desenvolvimento', 'orcamentoGlobalDepto': 500000,  'numeroFuncionariosDepto': 0})

-- Collection PROJETOS
db.projetos.insert({'codProj':'Pxml', 'tituloProj':'Projeto XML', 'orcamento':300000, 'prazoProj':2, 'unidadePrazo':'anos', 'coordProj':220, 'siglaDepto':'INFO'})
db.projetos.insert({'codProj':'PCMM', 'tituloProj':'Projeto Modelo de Capacitacao para Maturidade', 'orcamento':3000000, 'prazoProj':5, 'unidadePrazo':'anos', 'coordProj':205, siglaDepto:'INFO'})
db.projetos.insert({'codProj':'PMRH', 'tituloProj':'Projeto Manutencao Sistema RH Folha', 'orcamento':100000, 'prazoProj':6, 'unidadePrazo':'meses', 'coordProj':220, siglaDepto:'INFO'})
db.projetos.insert({'codProj':'CGP', 'tituloProj':'Companhia de Gerencia de Projeto', 'orcamento':500000, 'prazoProj':5, 'unidadePrazo':'meses', 'coordProj':1, 'siglaDepto':'PRES'})
db.projetos.insert({'codProj':'SGBD', 'tituloProj':'Novo SGBD PostgreSql', 'orcamento':20000, 'prazoProj':1, 'unidadePrazo':'ano', 'coordProj':230, 'siglaDepto':'PESQ'})

-- Collection FUNCIONARIOS
var projeto =  db.projetos.find({'codProj': 'Pxml'}).next()

db.funcionarios.insert({
	'matricFunc': 203,
	'nomeFunc': 'Ester dos Anjos',
	'cargoFunc': 'presidente',
	'salarioFunc': 90000, 
	'projetos': [{
		'projeto_id': projeto._id,
		'totalHorasMes': 30,
	}]}
)

db.funcionarios.insert({'matricFunc': 202,'nomeFunc': 'Fabio Almeida','cargoFunc': 'analista de sistemas','salarioFunc': '3000'})
db.funcionarios.insert({'matricFunc': 220,'nomeFunc': 'Angelina Almeida','cargoFunc': 'analista de sistemas','salarioFunc': '3000'})
db.funcionarios.insert({'matricFunc': 204,'nomeFunc': 'Maria dos Santos','cargoFunc': 'analista de sistemas','salarioFunc': '2500'})
db.funcionarios.insert({'matricFunc': 205,'nomeFunc': 'Maria dos Santos','cargoFunc': 'analista de sistemas','salarioFunc': '2500'})
db.funcionarios.insert({'matricFunc': 206,'nomeFunc': 'Gustavo dos Santos','cargoFunc': 'gerente','salarioFunc': '7500'})
db.funcionarios.insert({'matricFunc': 207,'nomeFunc': 'Luiza Braz Lima','cargoFunc': 'DBA','salarioFunc': '7000'})
db.funcionarios.insert({'matricFunc': 230,'nomeFunc': 'Debora Pereira','cargoFunc': 'pesquisador1','salarioFunc': '7500'})
db.funcionarios.insert({'matricFunc': 231,'nomeFunc': 'Fabiola Rodrigues','cargoFunc': 'pesquisador3','salarioFunc': '5000'})
db.funcionarios.insert({'matricFunc': 233,'nomeFunc': 'Antonio Pereira','cargoFunc': 'pesquisador3','salarioFunc': '5000'})
db.funcionarios.insert({'matricFunc': 235,'nomeFunc': 'Fernando Lima Barreto','cargoFunc': 'pesquisador2','salarioFunc': '6700'})
db.funcionarios.insert({'matricFunc': 1,'nomeFunc': 'Severino Cavalcanti','cargoFunc': 'assessor da presidencia','salarioFunc': '7500'})
db.funcionarios.insert({'matricFunc': 232,'nomeFunc': 'Joana Cavalcanti','cargoFunc': 'auxiliar','salarioFunc': '3000'})
```

