# Instruções para rodar o Job do Bolsa Familia

* Copiando para o HDFS

	# Remover acentuacao e header, trocar <tab> por ;
		tail -n +2 201510_BolsaFamiliaFolhaPagamento.csv | iconv -f "ISO-8859-1" -t "ascii//TRANSLIT" | sed 's/\t/;/g' > bolsa_familia.csv


	# Criar um diretório /data
		hdfs dfs -mkdir /data

	# Jogando o arquivo para o HDFS
		hdfs dfs -put bolsa_familia.csv /data/

	# Verificando se o arquivo está no local
		hdfs dfs -ls /data
		hdfs dfs -cat /data/bolsa_familia.csv

* Map Reduce - Yarn

	# Empacotar o Codigo
		mvn clean package

	# Apagar o pasta de OUTPUT (nao pode existir para o Job abaixo) 
		hdfs dfs -rm -r -skipTrash /data/out_bolsa_familia

	# Executar o Job Por UF ou Cidade
		hadoop jar bolsa_familia_pago-job.jar "UF" /data/bolsa_familia.csv /data/out_bolsa_familia
		hadoop jar bolsa_familia_pago-job.jar "CIDADE" /data/bolsa_familia.csv /data/out_bolsa_familia 

	# Verificar o arquivos que foram gerados através do Job
		hdfs dfs -ls /data/out_bolsa_familia

	# Verificar o conteúdo Gerado na Pasta
		hdfs dfs -cat /data/out_bolsa_familia/part*
