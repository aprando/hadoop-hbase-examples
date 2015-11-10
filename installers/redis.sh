#!/usr/bin/env bash
echo '----------------------------------------------'
echo ' INSTALLING REDIS'
echo '----------------------------------------------'

sudo apt-get install -y redis-server

#sudo sed -i '/bind/d' /etc/redis/redis.conf
