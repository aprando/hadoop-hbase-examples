# Sobre o Projeto
Este projeto realiza um overview de Big Data e NoSQL contemplando instalação, configuração e exemplos praticos de Hadoop, HBase, Mongo e Redis. 

## Intro
Todos os exemplos são executados em um ambiente Linux. Portanto, se você possui experiência com Linux, siga os manuais de instalação e configuração abaixo e prepare o ambiente na máquina que desejar.

Caso contrário, siga a instalação no tópico "Ambiente".

Manuais de instalação e configuração:

1. [MongoDB](https://github.com/aprando/hadoop-hbase-examples/blob/master/MONGODB.MD)
2. [Redis](https://github.com/aprando/hadoop-hbase-examples/blob/master/REDIS.MD)
3. [Hadoop e Hbase](https://github.com/aprando/hadoop-hbase-examples/blob/master/HADOOP_HBASE.MD)

## Ambiente

### Instalação do Sistema Operacional
Em nossas aulas vamos utilizar o Ubuntu Server 14.04 em uma máquina virtual.


#### Opção 1: Máquina virtual já criada... ####
Uma VM com Ubuntu Desktop instalado e com todos os pacotes baixados! =]
````
https://drive.google.com/open?id=0B6BAj1gwpQqKSFZ6aHNpLXpqTkE
````

#### Opção 2: Criando uma máquina virtual no VirtualBox ####

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

#### Opção 3: Vagrant ####
Caso você seja um desenvolvedor experiente e conheça [vagrant](https://www.vagrantup.com/), basta utilizar nosso VagrantFile que esta na raiz do projeto! =]

Caso contratário, por favor, utilize a opção 1.

