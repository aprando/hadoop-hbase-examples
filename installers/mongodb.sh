#!/usr/bin/env bash
echo '----------------------------------------------'
echo ' INSTALLING MONGODB'
echo '----------------------------------------------'

sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 7F0CEB10
sudo echo "deb http://repo.mongodb.org/apt/ubuntu "$(lsb_release -sc)"/mongodb-org/3.0 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.0.list
sudo apt-get update

sudo apt-get install -y mongodb-org

#sudo sed -i '/bind_ip/d' /etc/mongod.conf
sudo service mongod restart
