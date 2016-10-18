# Exemplo do Bolsa Familia

	## Criar uma pasta para jogar o Arquivo do Bolsa Familia (Pode jogar todos do Site)
		./bin/hdfs dfs -mkdir /data/hive_bolsa_familia

	## Copiar o arquivo usado no MRv2 para a Pasta criada
		./bin/hdfs dfs -cp /data/bolsa_familia.csv /data/hive_bolsa_familia

	## Criar um banco de Dados no Hive e fazer uso dele
		create database usp;
		use usp;		

	## Criar a Tabela no Hive apontando para a pasta com os arquivos do Bolsa Familia
		CREATE EXTERNAL TABLE bolsa_familia (
		UF STRING,
		Codigo_Municipio STRING,
		Nome_Municipio STRING,
		Codigo_Funcao STRING,
		Codigo_SubFuncao STRING,
		Codigo_Programa STRING,
		Codigo_Acao STRING,
		NIS STRING,
		Nome_Favorecido STRING,
		Fonte_Finalidade STRING,
		Valor_Parcela STRING,
		Mes_Competencia STRING) 
			ROW FORMAT DELIMITED FIELDS TERMINATED BY '\;' 
			LINES TERMINATED BY '\n' 
			STORED AS TEXTFILE LOCATION '/data/hive_bolsa_familia';

	## Selecionar os 100 primerios registros
		select UF, Nome_Municipio, Nome_Favorecido, Valor_Parcela from bolsa_familia limit 100;

	## Totalizar o Valor Pago do Bolsa Familia por Estado
		select UF, sum(Valor_Parcela) from bolsa_familia group by uf;

	## Quantificar o número de pessoas que recebem o bolsa familia por Cidade
		select Nome_Municipio, count(*) from bolsa_familia group by Nome_Municipio order by Nome_Municipio;

