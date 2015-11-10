#!/usr/bin/env bash
echo '----------------------------------------------'
echo ' INSTALLING HBASE'
echo '----------------------------------------------'

#echo "127.0.0.1 localhost" >> /etc/hosts
#echo "127.0.0.1 ubuntu.ubuntu-domain ubuntu" >> /etc/hosts

sudo wget --directory-prefix=/home/vagrant/packages/ http://ftp.unicamp.br/pub/apache/hbase/0.98.14/hbase-0.98.14-hadoop2-bin.tar.gz
cd /home/vagrant/packages/
tar -zxvf hbase-0.98.14-hadoop2-bin.tar.gz
cd hbase-0.98.14-hadoop2-bin/

