#!/usr/bin/env bash
echo '----------------------------------------------'
echo ' INSTALLING HBASE'
echo '----------------------------------------------'

sudo wget --directory-prefix=/home/vagrant/packages/ http://ftp.unicamp.br/pub/apache/hadoop/core/stable/hadoop-2.7.1.tar.gz
cd /home/vagrant/packages/
tar -zxvf hadoop-2.7.1.tar.gz
cd hadoop-2.7.1/

