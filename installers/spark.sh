#!/usr/bin/env bash
echo '----------------------------------------------'
echo ' INSTALLING SPARK'
echo '----------------------------------------------'

sudo wget --directory-prefix=/home/vagrant/packages/ http://ftp.unicamp.br/pub/apache/spark/spark-1.4.1/spark-1.4.1-bin-hadoop2.6.tgz
cd /home/vagrant/packages/
tar -zxvf spark-1.4.1-bin-hadoop2.6.tgz
echo 'export PATH="/home/vagrant/packages/spark-1.4.1-bin-hadoop2.6/bin:$PATH"' >> /home/vagrant/.bashrc
source ~/.bashrc
